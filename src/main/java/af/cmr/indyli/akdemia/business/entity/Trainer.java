package af.cmr.indyli.akdemia.business.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Trainer entity. It encapsulates information about
 * an individual who is employed by a company and participates in intra-session,
 * it extends {@link User}
 */
@Entity
@Table(name = "AKDEMIA_TRAINER")
@Inheritance(strategy = InheritanceType.JOINED)
public class Trainer extends User {
	@Column(name = "ACTIVITY")
	private String activity;
	@Column(name = "CV_LINK")
	private String cvLink;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "GENDER")
	private String gender;

	@OneToMany(mappedBy = "trainer")
	private List<Session> sessions = new ArrayList<>();

}
