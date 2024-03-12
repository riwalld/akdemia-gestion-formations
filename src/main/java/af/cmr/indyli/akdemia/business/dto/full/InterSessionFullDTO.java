package af.cmr.indyli.akdemia.business.dto.full;

import java.util.ArrayList;
import java.util.List;

import af.cmr.indyli.akdemia.business.dto.medium.InterSessionMediumDTO;
import af.cmr.indyli.akdemia.business.entity.ParticularSouscription;

/**
 * This class represents a basic Data Transfer Object (DTO) for a {@link af.cmr.indyli.akdemia.business.entity.InterSession}
 * entity.
 */

public class InterSessionFullDTO extends InterSessionMediumDTO {
	
	private static final long serialVersionUID = 1L;
	private List<ParticularSouscription> particularSouscriptions = new ArrayList<>();
	
	public List<ParticularSouscription> getParticularSouscriptions() {
		return particularSouscriptions;
	}
	public void setParticularSouscriptions(List<ParticularSouscription> particularSouscriptions) {
		this.particularSouscriptions = particularSouscriptions;
	}
}
