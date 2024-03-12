package af.cmr.indyli.akdemia.business.dto.basic;

import af.cmr.indyli.akdemia.business.dto.IDTO;
import af.cmr.indyli.akdemia.business.entity.Trainer;

import java.util.Date;;

/**
 * This class represents a basic Data Transfer Object (DTO) for a
 * {@link Trainer}
 * entity.
 */
public class TrainingBasicDTO implements IDTO {
	private Integer id;
	private String title;
	private String description;
	private int trainingPrice;
	private String logo;
	private Date creationDate;
	private Date updateDate;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
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
