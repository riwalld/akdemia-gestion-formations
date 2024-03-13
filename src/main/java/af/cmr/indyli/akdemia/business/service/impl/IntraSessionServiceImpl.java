package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.IIntraSessionRepository;
import af.cmr.indyli.akdemia.business.dao.ITrainingRepository;
import af.cmr.indyli.akdemia.business.dto.basic.IntraSessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.IntraSessionFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.IntraSessionFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.IntraSessionFullDTO;
import af.cmr.indyli.akdemia.business.entity.IntraSession;
import af.cmr.indyli.akdemia.business.entity.IntraSession;
import af.cmr.indyli.akdemia.business.entity.IntraSession;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.IIntraSessionService;
import af.cmr.indyli.akdemia.business.utils.ConstBusinessRules;
import af.cmr.indyli.akdemia.business.utils.ConstRejectBusinessMessage;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Service implementation class for managing {@link IntraSession} entity, extending the
 * AbstractAkdemiaServiceImpl class. This class provides specific functionality
 * for managing IntraSessions, including CRUD operations and validation.
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.INTRA_SESSION_SERVICE_KEY)
public class IntraSessionServiceImpl extends AbstractAkdemiaServiceImpl<IntraSession, IntraSessionBasicDTO, IntraSessionFullDTO, IIntraSessionRepository>
		implements IIntraSessionService {

	@Resource(name = ConstsValues.ConstsDAO.INTRA_SESSION)
	private IIntraSessionRepository sessionRepository;
	
	@Resource(name = ConstsValues.ConstsDAO.TRAINING_KEY)
	private ITrainingRepository trainingRepository;

	public IntraSessionServiceImpl() {
		super(IntraSession.class, IntraSessionBasicDTO.class, IntraSessionFullDTO.class);
	}

	@Override
	public IIntraSessionRepository getDAO() {
		return this.sessionRepository;
	}


	@Override
	public IntraSessionFullDTO create(IntraSessionFullDTO view) throws AkdemiaBusinessException {
		List<IntraSession> session = this.getDAO().findByTrainingTitle(view.getTraining().getTitle());

		if (trainingRepository.findByTitle(view.getTraining().getTitle()) != null) {
			view.setCreationDate(new Date());
			IntraSession entity = this.getDAO()
					.saveAndFlush(this.getModelMapper().map(view, IntraSession.class));
			return this.getModelMapper().map(entity, IntraSessionFullDTO.class);
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG22);
	}

	@Override
	public IntraSessionFullDTO update(IntraSessionFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
		boolean isIntraSessionExist = this.findAll().stream().anyMatch(
				p -> viewToUpdate.getCode().equals(p.getCode()) && !viewToUpdate.getId().equals(p.getId()));
		if (!isIntraSessionExist) {
			viewToUpdate.setUpdateDate(new Date());
			IntraSession entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
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
		var tmpIntraSession = this.findById(id);

		if (tmpIntraSession == null) {
			throw new AkdemiaBusinessException(ConstRejectBusinessMessage.DELETE_OBJECT_NOT_FOUND);
		}else {
			this.getDAO().deleteById(id);
		}
	}
	@Override
	public List<IntraSessionFullDTO> findAllFull() {
		return this.getDAO().findAll().stream().map(p -> this.getModelMapper().map(p, IntraSessionFullDTO.class)).toList();
	}
}