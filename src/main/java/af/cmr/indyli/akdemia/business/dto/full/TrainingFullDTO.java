package af.cmr.indyli.akdemia.business.dto.full;

import java.util.ArrayList;
import java.util.List;

import af.cmr.indyli.akdemia.business.dto.basic.SessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.SubTopicBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.TopicBasicDTO;
import af.cmr.indyli.akdemia.business.dto.medium.TrainingMediumDTO;
import af.cmr.indyli.akdemia.business.entity.Session;
import af.cmr.indyli.akdemia.business.entity.Training;

/**
 * This class represents a full Data Transfer Object (DTO) for a {@link Training}
 * entity, it extends {@link TrainingMediumDTO}.
 */
public class TrainingFullDTO extends TrainingMediumDTO {
	
	private static final long serialVersionUID = 1L;
	private List<SubTopicFullDTO> subtopics = new ArrayList<>();
	private List<SessionBasicDTO> sessions = new ArrayList<>();
	
	
	public List<SessionBasicDTO> getSessions() {
		return sessions;
	}
	public void setSessions(List<SessionBasicDTO> sessions) {
		this.sessions = sessions;
	}
	public List<SubTopicFullDTO> getSubtopics() {
		return subtopics;
	}
	public void setSubtopics(List<SubTopicFullDTO> subtopics) {
		this.subtopics = subtopics;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
