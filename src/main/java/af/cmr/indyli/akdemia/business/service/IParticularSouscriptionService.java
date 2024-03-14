package af.cmr.indyli.akdemia.business.service;

import java.util.List;

import af.cmr.indyli.akdemia.business.dao.IParticularSouscriptionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.ParticularSouscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.ParticularSouscriptionFullDTO;
import af.cmr.indyli.akdemia.business.entity.ParticularSouscription;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing user
 * ParticularSouscription, providing specific operations for {@link ParticularSouscription} entities.
 *
 * @see IAbstractAkdemiaService
 */
public interface IParticularSouscriptionService
		extends IAbstractAkdemiaService<ParticularSouscription, ParticularSouscriptionBasicDTO, ParticularSouscriptionFullDTO, IParticularSouscriptionRepository> {

	List<ParticularSouscriptionFullDTO> findAllFull();

	List<ParticularSouscriptionFullDTO> findBySession(Integer id);

}
