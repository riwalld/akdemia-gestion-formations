package af.cmr.indyli.akdemia.business.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an InterSession entity. It encapsulates information
 * about
 * the amount of employees suscribed to an intra-session
 */
@Entity
@Table(name = "AKDEMIA_INTER_SESSION")
public class InterSession extends Session {
    @Column(name = "MIN_PARTICIPANTS")
    Integer minParticipants;

    @OneToMany(mappedBy = "interSession", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private List<ParticularSouscription> particularSouscriptions = new ArrayList<>();

	public Integer getMinParticipants() {
		return minParticipants;
	}

	public void setMinParticipants(Integer minParticipants) {
		this.minParticipants = minParticipants;
	}

	public List<ParticularSouscription> getParticularSouscriptions() {
		return particularSouscriptions;
	}

	public void setParticularSouscriptions(List<ParticularSouscription> particularSouscriptions) {
		this.particularSouscriptions = particularSouscriptions;
	}
    
    
}
