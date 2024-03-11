package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.dao.IIntraSessionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.IntraSessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.IntraSessionFullDTO;
import af.cmr.indyli.akdemia.business.entity.IntraSession;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing user
 * IntraSession, providing specific operations for {@link IntraSession} entities.
 *
 * @see IAbstractAkdemiaService
 */
public interface IIntraSessionService
		extends IAbstractAkdemiaService<IntraSession, IntraSessionBasicDTO, IntraSessionFullDTO, IIntraSessionRepository> {

}
