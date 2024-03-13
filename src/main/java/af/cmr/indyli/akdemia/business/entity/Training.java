package af.cmr.indyli.akdemia.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class represents a Training entity. It encapsulates information about
 * a training in which is created sessions from it
 */
@Entity
@Table(name = "AKDEMIA_TRAINING")
public class Training implements IEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "TRAINING_PRICE")
	int trainingPrice;
	@Column(name = "LOGO")
	private String logo;

	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;
	
	@ManyToOne
	@JoinColumn(name = "ID_AKDEMIA_REQUIREMENT")
	private Requirement requirement;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "content", joinColumns = @JoinColumn(name = "ID_AKDEMIA_TRAINING"), inverseJoinColumns = @JoinColumn(name = "ID"))
	private List<SubTopic> subtopics = new ArrayList<>();

	@OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
	private List<Session> sessions = new ArrayList<>();

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public Date getCreationDate() {
		return creationDate;
	}

	@Override
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public Date getUpdateDate() {
		return updateDate;
	}

	@Override
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTrainingPrice() {
		return trainingPrice;
	}

	public void setTrainingPrice(int trainingPrice) {
		this.trainingPrice = trainingPrice;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	public List<SubTopic> getSubtopics() {
		return subtopics;
	}

	public void setSubtopics(List<SubTopic> subtopics) {
		this.subtopics = subtopics;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

}
