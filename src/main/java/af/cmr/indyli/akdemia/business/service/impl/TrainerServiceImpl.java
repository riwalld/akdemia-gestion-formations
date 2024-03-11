package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.ITrainerRepository;
import af.cmr.indyli.akdemia.business.dto.basic.TrainerBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.TrainerFullDTO;
import af.cmr.indyli.akdemia.business.entity.Trainer;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.ITrainerService;
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

	public TrainerServiceImpl() {
		super(Trainer.class, TrainerBasicDTO.class, TrainerFullDTO.class);
	}

	@Override
	public ITrainerRepository getDAO() {
		return this.TrainerRepository;
	}


	@Override
	public TrainerFullDTO create(TrainerFullDTO view) throws AkdemiaBusinessException {
		Trainer Trainer = this.getDAO().findTrainerByEmail(view.getEmail());

		if (Trainer== null) {
			view.setCreationDate(new Date());
			Trainer entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, Trainer.class));
			view.setId(entity.getId());
			return view;
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG05);
	}

	@Override
	public TrainerFullDTO update(TrainerFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
		boolean isTrainerExist = this.findAll().stream().anyMatch(
				p -> viewToUpdate.getEmail().equals(p.getEmail()) && !viewToUpdate.getId().equals(p.getId()));
		if (!isTrainerExist) {
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
		throw new AkdemiaBusinessException(ConstBusinessRules.RG06);
	}
	

	@Override
	public void deleteById(int id) throws AkdemiaBusinessException, AccessDeniedException {
		var tmpTrainer = this.findById(id);

		if (tmpTrainer == null) {
			throw new AkdemiaBusinessException(ConstRejectBusinessMessage.DELETE_OBJECT_NOT_FOUND);
		}else {
			this.getDAO().deleteById(id);
		} 
	}
}