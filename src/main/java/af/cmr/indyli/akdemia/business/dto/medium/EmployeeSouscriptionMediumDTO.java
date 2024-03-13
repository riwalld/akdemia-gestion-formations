package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.EmployeeBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.EmployeeSouscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.IntraSessionBasicDTO;
import af.cmr.indyli.akdemia.business.entity.EmployeeSouscription;

/**
 * This class represents a medium Data Transfer Object (DTO) for a
 * {@link EmployeeSouscription} entity. It extends {@link EmployeeSouscription} and inherits basic
 * information about a manager. Medium DTOs typically include additional details
 * beyond the basic DTO but exclude complex associations like lists.
 */

public class EmployeeSouscriptionMediumDTO extends EmployeeSouscriptionBasicDTO {
	private IntraSessionBasicDTO intraSession;
	private EmployeeBasicDTO employeeBasicDTO;
	
	public IntraSessionBasicDTO getIntraSession() {
		return intraSession;
	}
	public void setIntraSession(IntraSessionBasicDTO intraSessionBasicDTO) {
		this.intraSession = intraSessionBasicDTO;
	}
	public EmployeeBasicDTO getEmployee() {
		return employeeBasicDTO;
	}
	public void setEmployee(EmployeeBasicDTO employeeBasicDTO) {
		this.employeeBasicDTO = employeeBasicDTO;
	}
}
