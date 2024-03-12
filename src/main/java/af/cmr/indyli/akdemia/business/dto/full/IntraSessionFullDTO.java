package af.cmr.indyli.akdemia.business.dto.full;

import java.util.ArrayList;
import java.util.List;

import af.cmr.indyli.akdemia.business.dto.medium.IntraSessionMediumDTO;
import af.cmr.indyli.akdemia.business.entity.EmployeeSouscription;

/**
 * This class represents a basic Data Transfer Object (DTO) for a {@link af.cmr.indyli.akdemia.business.entity.IntraSession}
 * entity.
 */

public class IntraSessionFullDTO extends IntraSessionMediumDTO {
	
	private static final long serialVersionUID = 1L;
	
	private List<EmployeeSouscription> employeeSouscriptions = new ArrayList<>();
	

	public List<EmployeeSouscription> getEmployeeSouscriptions() {
		return employeeSouscriptions;
	}

	public void setEmployeeSouscriptions(List<EmployeeSouscription> employeeSouscriptions) {
		this.employeeSouscriptions = employeeSouscriptions;
	}
	
	
}
