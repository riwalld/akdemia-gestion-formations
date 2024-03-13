package af.cmr.indyli.akdemia.business.dto.full;

import java.util.ArrayList;
import java.util.List;

import af.cmr.indyli.akdemia.business.dto.basic.EmployeeSouscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.medium.IntraSessionMediumDTO;
import af.cmr.indyli.akdemia.business.entity.EmployeeSouscription;

/**
 * This class represents a basic Data Transfer Object (DTO) for a {@link af.cmr.indyli.akdemia.business.entity.IntraSession}
 * entity.
 */

public class IntraSessionFullDTO extends IntraSessionMediumDTO {
	
	private static final long serialVersionUID = 1L;
	
	private List<EmployeeSouscriptionBasicDTO> employeeSouscriptions = new ArrayList<>();
	

	public List<EmployeeSouscriptionBasicDTO> getEmployeeSouscriptions() {
		return employeeSouscriptions;
	}

	public void setEmployeeSouscriptions(List<EmployeeSouscriptionBasicDTO> employeeSouscriptions) {
		this.employeeSouscriptions = employeeSouscriptions;
	}
	
	
}
