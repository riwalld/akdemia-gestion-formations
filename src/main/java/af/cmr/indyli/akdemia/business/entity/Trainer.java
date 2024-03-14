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
public class Trainer extends User {
	@Column(name = "ACTIVITY")
	private String activity;
	@Column(name = "CV_LINK")
	private String cvLink;
	@Column(name = "FIRSTNAME")
	private String firstname;
	@Column(name = "LASTNAME")
	private String lastname;
	@Column(name = "GENDER")
	private String gender;

	@OneToMany(mappedBy = "trainer")
	private List<Session> sessions = new ArrayList<>();

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getCvLink() {
		return cvLink;
	}

	public void setCvLink(String cvLink) {
		this.cvLink = cvLink;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

}
