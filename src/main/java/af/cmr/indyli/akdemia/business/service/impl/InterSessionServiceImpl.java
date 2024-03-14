package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.IInterSessionRepository;
import af.cmr.indyli.akdemia.business.dao.ITrainingRepository;
import af.cmr.indyli.akdemia.business.dto.basic.InterSessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.EmployeeFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.InterSessionFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.InterSessionFullDTO;
import af.cmr.indyli.akdemia.business.entity.InterSession;
import af.cmr.indyli.akdemia.business.entity.InterSession;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.IInterSessionService;
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
 * Service implementation class for managing {@link InterSession} entity, extending the
 * AbstractAkdemiaServiceImpl class. This class provides specific functionality
 * for managing InterSessions, including CRUD operations and validation.
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.INTER_SESSION_SERVICE_KEY)
public class InterSessionServiceImpl extends AbstractAkdemiaServiceImpl<InterSession, InterSessionBasicDTO, InterSessionFullDTO, IInterSessionRepository>
		implements IInterSessionService {

	@Resource(name = ConstsValues.ConstsDAO.INTER_SESSION)
	private IInterSessionRepository sessionRepository;
	
	@Resource(name = ConstsValues.ConstsDAO.TRAINING_KEY)
	private ITrainingRepository trainingRepository;
	
	public InterSessionServiceImpl() {
		super(InterSession.class, InterSessionBasicDTO.class, InterSessionFullDTO.class);
	}

	@Override
	public IInterSessionRepository getDAO() {
		return this.sessionRepository;
	}


	@Override
	public InterSessionFullDTO create(InterSessionFullDTO view) throws AkdemiaBusinessException {
		
		List<InterSession> session = this.getDAO().findByTrainingTitle(view.getTraining().getTitle());

		if (trainingRepository.findByTitle(view.getTraining().getTitle()) != null) {
			view.setStatus(ConstsValues.SessionStatus.WAITING);
			view.setCreationDate(new Date());
			InterSession entity = this.getDAO()
					.saveAndFlush(this.getModelMapper().map(view, InterSession.class));
			return this.getModelMapper().map(entity, InterSessionFullDTO.class);
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG22);
	}

	@Override
	public InterSessionFullDTO update(InterSessionFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
		boolean isInterSessionExist = this.findAll().stream().anyMatch(
				p -> viewToUpdate.getCode().equals(p.getCode()) && !viewToUpdate.getId().equals(p.getId()));
		if (!isInterSessionExist) {
			viewToUpdate.setUpdateDate(new Date());
			InterSession entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
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
		var tmpInterSession = this.findById(id);

		if (tmpInterSession == null) {
			throw new AkdemiaBusinessException(ConstRejectBusinessMessage.DELETE_OBJECT_NOT_FOUND);
		}else {
			this.getDAO().deleteById(id);
		}
	}
	
	@Override
	public List<InterSessionFullDTO> findAllFull() {
		return this.getDAO().findAll().stream().map(p -> this.getModelMapper().map(p, InterSessionFullDTO.class)).toList();
	}
}