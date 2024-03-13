package af.cmr.indyli.akdemia.business.entity;

import jakarta.persistence.*;

import java.util.Date;

import org.aspectj.weaver.patterns.IfPointcut.IfFalsePointcut;

/**
 * This class represents a Session entity. It encapsulates information about
 * an individual who is employed by a company and participates in intra-session,
 * it extends {@link User}
 */
@Entity
@Table(name = "AKDEMIA_SESSION")
@Inheritance(strategy = InheritanceType.JOINED)
public class Session implements IEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "CODE")
	private String code;
	@Column(name = "DURATION")
	private Integer duration;
	@Column(name = "PRICE")
	private Float price;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "DATE")
	private Date date;
	@Column(name = "LACATION")
	private String location;
	@Column(name = "SESSION_SCORE")
	private Integer sessionScore;
	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "ID_AKDEMIA_TRAINER")
	private Trainer trainer;
	@ManyToOne(optional = false, cascade = CascadeType.DETACH)
	@JoinColumn(name = "ID_AKDEMIA_TRAINING")
	private Training training;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getSessionScore() {
		 if(sessionScore==null){
			 return -1;
		}
		return sessionScore;
	}

	public void setSessionScore(int sessionScore) {
		this.sessionScore = sessionScore;
	}

	@Override
	public Date getCreationDate() {
		return creationDate;
	}

	@Override
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	@Override
	public Date getUpdateDate() {
		return updateDate;
	}

	@Override
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
