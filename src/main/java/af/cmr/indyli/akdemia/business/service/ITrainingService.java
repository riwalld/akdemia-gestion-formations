package af.cmr.indyli.akdemia.business.service;

import java.util.List;

import af.cmr.indyli.akdemia.business.dao.ITrainingRepository;
import af.cmr.indyli.akdemia.business.dto.basic.TrainingBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.TrainingFullDTO;
import af.cmr.indyli.akdemia.business.entity.Training;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing user
 * Training, providing specific operations for {@link Training} entities.
 *
 * @see IAbstractAkdemiaService
 */
public interface ITrainingService
		extends IAbstractAkdemiaService<Training, TrainingBasicDTO, TrainingFullDTO, ITrainingRepository> {

	List<TrainingFullDTO> findAllFull();

}
