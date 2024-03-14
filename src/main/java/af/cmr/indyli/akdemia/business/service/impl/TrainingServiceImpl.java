package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.ITrainingRepository;
import af.cmr.indyli.akdemia.business.dao.ITrainingRepository;
import af.cmr.indyli.akdemia.business.dto.basic.TrainingBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.EmployeeFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.TrainingFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.TrainingFullDTO;
import af.cmr.indyli.akdemia.business.entity.Training;
import af.cmr.indyli.akdemia.business.entity.Training;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.ITrainingService;
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
 * Service implementation class for managing {@link Training} entity, extending the
 * AbstractAkdemiaServiceImpl class. This class provides specific functionality
 * for managing Trainings, including CRUD operations and validation.
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.TRAINING_SERVICE_KEY)
public class TrainingServiceImpl extends AbstractAkdemiaServiceImpl<Training, TrainingBasicDTO, TrainingFullDTO, ITrainingRepository>
		implements ITrainingService {

	@Resource(name = ConstsValues.ConstsDAO.TRAINING_KEY)
	private ITrainingRepository trainingRepository;

	public TrainingServiceImpl() {
		super(Training.class, TrainingBasicDTO.class, TrainingFullDTO.class);
	}

	@Override
	public ITrainingRepository getDAO() {
		return this.trainingRepository;
	}


	@Override
	public TrainingFullDTO create(TrainingFullDTO view) throws AkdemiaBusinessException {
		Training training = this.getDAO().findByTitle(view.getTitle());
		if (training == null) {
			view.setCreationDate(new Date());
			Training entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, Training.class));
			view.setId(entity.getId());
			return view;
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG04);
	}

	@Override
	public TrainingFullDTO update(TrainingFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
		boolean isTrainingExist = this.findAll().stream().anyMatch(
				p -> viewToUpdate.getTitle().equals(p.getTitle()) && !viewToUpdate.getId().equals(p.getId()));
		if (!isTrainingExist) {
			viewToUpdate.setUpdateDate(new Date());
			Training entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
			if (entity != null) {
				BeanUtils.copyProperties(viewToUpdate, entity);
				this.getDAO().saveAndFlush(entity);
			} else {
				throw new AkdemiaBusinessException(ConstRejectBusinessMessage.UPDATE_OBJECT_NOT_FOUND);
			}
			return viewToUpdate;
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG21);
	}
	

	@Override
	public void deleteById(int id) throws AkdemiaBusinessException, AccessDeniedException {
		var tmpTraining = this.findById(id);

		if (tmpTraining == null) {
			throw new AkdemiaBusinessException(ConstRejectBusinessMessage.DELETE_OBJECT_NOT_FOUND);
		}else {
			this.getDAO().deleteById(id);
		}
	}
	
	@Override
	public List<TrainingFullDTO> findAllFull() {
		return this.getDAO().findAll().stream().map(p -> this.getModelMapper().map(p, TrainingFullDTO.class)).toList();
	}
}