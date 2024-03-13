package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.InterSessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.ParticularBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.ParticularSouscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.entity.ParticularSouscription;

/**
 * This class represents a medium Data Transfer Object (DTO) for a
 * {@link ParticularSouscription} entity. It extends {@link ParticularSouscription} and inherits basic
 * information about a manager. Medium DTOs typically include additional details
 * beyond the basic DTO but exclude complex associations like lists.
 */

public class ParticularSouscriptionMediumDTO extends ParticularSouscriptionBasicDTO {
	private static final long serialVersionUID = 1L;
	private InterSessionBasicDTO interSession;
	private ParticularBasicDTO particular;
	
	public InterSessionBasicDTO getInterSession() {
		return interSession;
	}
	public void setInterSession(InterSessionBasicDTO interSession) {
		this.interSession = interSession;
	}
	public ParticularBasicDTO getParticular() {
		return particular;
	}
	public void setParticular(ParticularBasicDTO particularBasicDTO) {
		this.particular = particularBasicDTO;
	}
	
}
