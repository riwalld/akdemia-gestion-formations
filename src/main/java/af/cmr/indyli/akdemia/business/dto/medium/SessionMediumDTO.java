package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.SessionBasicDTO;
import af.cmr.indyli.akdemia.business.entity.Session;

/**
 * This class represents a medium Data Transfer Object (DTO) for a {@link Session}
 * entity. It extends {@link SessionBasicDTO} and inherits basic information about
 * a Session. Medium DTOs typically include additional details beyond the basic DTO
 * but exclude complex associations like lists.
 */
public class SessionMediumDTO extends SessionBasicDTO {
	public SessionMediumDTO() {
	}
}