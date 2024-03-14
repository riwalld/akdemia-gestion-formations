package af.cmr.indyli.akdemia.business.service.impl;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import af.cmr.indyli.akdemia.business.dao.IEmployeeSouscriptionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.EmployeeSouscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.EmployeeSouscriptionFullDTO;
import af.cmr.indyli.akdemia.business.entity.EmployeeSouscription;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.IEmployeeSouscriptionService;
import af.cmr.indyli.akdemia.business.utils.ConstBusinessRules;
import af.cmr.indyli.akdemia.business.utils.ConstRejectBusinessMessage;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;

/**
 * Service implementation class for managing {@link EmployeeSouscription}
 * entity, extending the
 * AbstractAkdemiaServiceImpl class. This class provides specific functionality
 * for managing EmployeeSouscriptions, including CRUD operations and
 * validation.
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.EMPLOYEE_SOUSCRIPTION_SERVICE_KEY)
public class EmployeeSouscriptionImpl extends
		AbstractAkdemiaServiceImpl<EmployeeSouscription, EmployeeSouscriptionBasicDTO, EmployeeSouscriptionFullDTO, IEmployeeSouscriptionRepository>
		implements IEmployeeSouscriptionService {

	@Resource(name = ConstsValues.ConstsDAO.EMPL_SOUSCRIPTION_DAO_KEY)
	private IEmployeeSouscriptionRepository employeeSouscriptionRepository;

	public EmployeeSouscriptionImpl() {
		super(EmployeeSouscription.class, EmployeeSouscriptionBasicDTO.class, EmployeeSouscriptionFullDTO.class);
	}

	@Override
	public IEmployeeSouscriptionRepository getDAO() {
		return this.employeeSouscriptionRepository;
	}

	@Override
	public EmployeeSouscriptionFullDTO create(EmployeeSouscriptionFullDTO view) throws AkdemiaBusinessException {
		
		EmployeeSouscription employeeSouscription = employeeSouscriptionRepository.findByEmployeeNameAndSessionCode(view.getEmployee().getLastname(), view.getIntraSession().getCode());
		if (employeeSouscription == null) {
			view.setCreationDate(new Date());
			EmployeeSouscription entity = this.getDAO()
					.saveAndFlush(this.getModelMapper().map(view, EmployeeSouscription.class));

			return this.getModelMapper().map(entity, EmployeeSouscriptionFullDTO.class);
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG20);
	}

	@Override
	public EmployeeSouscriptionFullDTO update(EmployeeSouscriptionFullDTO viewToUpdate)
			throws AkdemiaBusinessException, AccessDeniedException {
		boolean isEmployeeSouscriptionExist = this.findAll().stream().anyMatch(
				p -> viewToUpdate.getId().equals(p.getId()));
		if (!isEmployeeSouscriptionExist) {
			viewToUpdate.setUpdateDate(new Date());
			EmployeeSouscription entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
			if (entity != null) {
				BeanUtils.copyProperties(viewToUpdate, entity);
				this.getDAO().saveAndFlush(entity);
			} else {
				throw new AkdemiaBusinessException(ConstRejectBusinessMessage.UPDATE_OBJECT_NOT_FOUND);
			}
			return viewToUpdate;
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG06);
	}

	@Override
	public void deleteById(int id) throws AkdemiaBusinessException, AccessDeniedException {
		var tmpEmployeeSouscription = this.findById(id);

		if (tmpEmployeeSouscription == null) {
			throw new AkdemiaBusinessException(ConstRejectBusinessMessage.DELETE_OBJECT_NOT_FOUND);
		} else {
			this.getDAO().deleteById(id);
		}
	}
	
	@Override
	public List<EmployeeSouscriptionFullDTO> findAllFull() {
		return this.getDAO().findAll().stream().map(p -> this.getModelMapper().map(p, EmployeeSouscriptionFullDTO.class)).toList();
	}

	@Override
	public List<EmployeeSouscriptionFullDTO> findBySession(Integer id) {
		return employeeSouscriptionRepository.findByIntraSessionId(id).stream().map(p -> this.getModelMapper().map(p, EmployeeSouscriptionFullDTO.class)).toList();
	}

	@Override
	public void deleteByIdSessionAndIdParticular(int idSession, int idParticipant) {
		employeeSouscriptionRepository.deleteByIdSessionAndIdEmployee(idSession, idParticipant);		
	}
	
}