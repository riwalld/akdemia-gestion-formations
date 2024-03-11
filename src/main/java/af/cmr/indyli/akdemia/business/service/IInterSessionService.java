package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.dao.IInterSessionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.InterSessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.InterSessionFullDTO;
import af.cmr.indyli.akdemia.business.entity.InterSession;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing user
 * InterSession, providing specific operations for {@link InterSession} entities.
 *
 * @see IAbstractAkdemiaService
 */
public interface IInterSessionService
		extends IAbstractAkdemiaService<InterSession, InterSessionBasicDTO, InterSessionFullDTO, IInterSessionRepository> {

}
