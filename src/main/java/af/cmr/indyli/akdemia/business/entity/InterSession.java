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

    @OneToMany(mappedBy = "interSession", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ParticularSouscription> particularSouscriptions = new ArrayList<>();
}
