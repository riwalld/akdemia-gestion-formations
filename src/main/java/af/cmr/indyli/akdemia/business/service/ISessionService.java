package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.dao.ISessionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.SessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.SessionFullDTO;
import af.cmr.indyli.akdemia.business.entity.Session;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing user
 * Session, providing specific operations for {@link Session} entities.
 *
 * @see IAbstractAkdemiaService
 */
public interface ISessionService
		extends IAbstractAkdemiaService<Session, SessionBasicDTO, SessionFullDTO, ISessionRepository> {

}
