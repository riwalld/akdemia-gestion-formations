package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.ITrainerRepository;
import af.cmr.indyli.akdemia.business.dto.basic.TrainerBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.TrainerFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.TrainerFullDTO;
import af.cmr.indyli.akdemia.business.entity.Trainer;
import af.cmr.indyli.akdemia.business.entity.Trainer;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.ITrainerService;
import af.cmr.indyli.akdemia.business.service.IUserService;
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
 * Service implementation class for managing {@link Trainer} entity, extending the
 * AbstractAkdemiaServiceImpl class. This class provides specific functionality
 * for managing Trainers, including CRUD operations and validation.
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.TRAINER_SERVICE_KEY)
public class TrainerServiceImpl extends AbstractAkdemiaServiceImpl<Trainer, TrainerBasicDTO, TrainerFullDTO, ITrainerRepository>
		implements ITrainerService {

	@Resource(name = ConstsValues.ConstsDAO.TRAINER_KEY)
	private ITrainerRepository TrainerRepository;
	@Resource(name = ConstsValues.ServiceKeys.USER_SERVICE_KEY)
	private IUserService userService;
	
	public TrainerServiceImpl() {
		super(Trainer.class, TrainerBasicDTO.class, TrainerFullDTO.class);
	}

	@Override
	public ITrainerRepository getDAO() {
		return this.TrainerRepository;
	}


	@Override
	public TrainerFullDTO create(TrainerFullDTO view) throws AkdemiaBusinessException {
		if (!userService.isExistUserByEmail(view.getEmail())) {
			view.setCreationDate(new Date());
			Trainer entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, Trainer.class));

			return this.getModelMapper().map(entity, TrainerFullDTO.class);
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG02);
	}

	@Override
	public TrainerFullDTO update(TrainerFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
		if (!userService.isExistUserByEmail(viewToUpdate.getEmail(), viewToUpdate.getId())) {
			viewToUpdate.setUpdateDate(new Date());
			Trainer entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
			if (entity != null) {
				BeanUtils.copyProperties(viewToUpdate, entity);
				this.getDAO().saveAndFlush(entity);
			} else {
				throw new AkdemiaBusinessException(ConstRejectBusinessMessage.UPDATE_OBJECT_NOT_FOUND);
			}
			return viewToUpdate;
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG02);
	}
}