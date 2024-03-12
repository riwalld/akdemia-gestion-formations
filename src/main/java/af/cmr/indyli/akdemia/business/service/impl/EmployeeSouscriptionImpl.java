package af.cmr.indyli.akdemia.business.service.impl;

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
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.Optional;

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
	private IEmployeeSouscriptionRepository EmployeeSouscriptionRepository;

	public EmployeeSouscriptionImpl() {
		super(EmployeeSouscription.class, EmployeeSouscriptionBasicDTO.class, EmployeeSouscriptionFullDTO.class);
	}

	@Override
	public IEmployeeSouscriptionRepository getDAO() {
		return this.EmployeeSouscriptionRepository;
	}

	@Override
	public EmployeeSouscriptionFullDTO create(EmployeeSouscriptionFullDTO view) throws AkdemiaBusinessException {
		Optional<EmployeeSouscription> employeeSouscription = this.getDAO().findById(view.getId());

		if (employeeSouscription.isEmpty()) {
			view.setCreationDate(new Date());
			EmployeeSouscription entity = this.getDAO()
					.saveAndFlush(this.getModelMapper().map(view, EmployeeSouscription.class));
			view.setId(entity.getId());
			return view;
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG05);
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
}