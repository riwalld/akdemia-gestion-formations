package af.cmr.indyli.akdemia.business.dto.basic;

import af.cmr.indyli.akdemia.business.dto.IDTO;
import af.cmr.indyli.akdemia.business.entity.ParticularSouscription;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class represents a basic Data Transfer Object (DTO) for a
 * {@link af.cmr.indyli.akdemia.business.entity.Session}
 * entity.
 */

public class InterSessionBasicDTO implements IDTO {
	private Integer id;
	String code;
	int duration;
	float price;
	String description;
	String status;
	Date date;
	String location;
	int sessionScore;
	private Date creationDate;
	private Date updateDate;
	private int minParticipants;
	private List<ParticularSouscription> particularSouscriptions = new ArrayList<>();

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

	@Override
	public Date getUpdateDate() {
		return updateDate;
	}

	@Override
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
