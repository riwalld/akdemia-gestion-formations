package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.InterSessionBasicDTO;
import af.cmr.indyli.akdemia.business.entity.InterSession;

/**
 * This class represents a medium Data Transfer Object (DTO) for a {@link InterSession}
 * entity. It extends {@link InterSessionBasicDTO} and inherits basic information about
 * a InterSession. Medium DTOs typically include additional details beyond the basic DTO
 * but exclude complex associations like lists.
 */
public class InterSessionMediumDTO extends InterSessionBasicDTO {
	public InterSessionMediumDTO() {
	}
}