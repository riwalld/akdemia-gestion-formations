package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.IntraSessionBasicDTO;
import af.cmr.indyli.akdemia.business.entity.IntraSession;

/**
 * This class represents a medium Data Transfer Object (DTO) for a {@link IntraSession}
 * entity. It extends {@link IntraSessionBasicDTO} and inherits basic information about
 * a IntraSession. Medium DTOs typically include additional details beyond the basic DTO
 * but exclude complex associations like lists.
 */
public class IntraSessionMediumDTO extends IntraSessionBasicDTO {
	public IntraSessionMediumDTO() {
	}
}