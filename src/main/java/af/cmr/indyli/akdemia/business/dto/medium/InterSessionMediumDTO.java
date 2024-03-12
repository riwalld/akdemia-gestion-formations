package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.InterSessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.TrainerBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.TrainingBasicDTO;
import af.cmr.indyli.akdemia.business.entity.InterSession;

/**
 * This class represents a medium Data Transfer Object (DTO) for a {@link InterSession}
 * entity. It extends {@link InterSessionBasicDTO} and inherits basic information about
 * a InterSession. Medium DTOs typically include additional details beyond the basic DTO
 * but exclude complex associations like lists.
 */
public class InterSessionMediumDTO extends InterSessionBasicDTO {
	
	private static final long serialVersionUID = 1L;
	private TrainingBasicDTO training;
	private TrainerBasicDTO trainer;
/*	
	public InterSessionMediumDTO() {
		super();
	}*/
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