package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.CompanyBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.IntraSessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.TrainerBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.TrainingBasicDTO;
import af.cmr.indyli.akdemia.business.entity.IntraSession;

/**
 * This class represents a medium Data Transfer Object (DTO) for a {@link IntraSession}
 * entity. It extends {@link IntraSessionBasicDTO} and inherits basic information about
 * a IntraSession. Medium DTOs typically include additional details beyond the basic DTO
 * but exclude complex associations like lists.
 */
public class IntraSessionMediumDTO extends IntraSessionBasicDTO {

	private static final long serialVersionUID = 1L;
	private TrainingBasicDTO training;
	private TrainerBasicDTO trainer;
	private CompanyBasicDTO company;
	
	public CompanyBasicDTO getCompany() {
		return company;
	}
	public void setCompany(CompanyBasicDTO company) {
		this.company = company;
	}
	public TrainingBasicDTO getTraining() {
		return training;
	}
	public void setTraining(TrainingBasicDTO training) {
		this.training = training;
	}
	public TrainerBasicDTO getTrainer() {
		return trainer;
	}
	public void setTrainer(TrainerBasicDTO trainer) {
		this.trainer = trainer;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


}