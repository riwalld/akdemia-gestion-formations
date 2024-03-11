package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.dao.ITrainerRepository;
import af.cmr.indyli.akdemia.business.dto.basic.TrainerBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.TrainerFullDTO;
import af.cmr.indyli.akdemia.business.entity.Trainer;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing user
 * trainer, providing specific operations for {@link Trainer} entities.
 *
 * @see IAbstractAkdemiaService
 */
public interface ITrainerService
		extends IAbstractAkdemiaService<Trainer, TrainerBasicDTO, TrainerFullDTO, ITrainerRepository> {

}
