package af.cmr.indyli.akdemia.business.dto.full;

import java.util.ArrayList;
import java.util.List;

import af.cmr.indyli.akdemia.business.dto.basic.EmployeeBasicDTO;
import af.cmr.indyli.akdemia.business.dto.medium.CompanyMediumDTO;
import af.cmr.indyli.akdemia.business.entity.Company;

/**
 * This class represents a full Data Transfer Object (DTO) for a {@link Company}
 * entity, it extends {@link CompanyMediumDTO}.
 */
public class CompanyFullDTO extends CompanyMediumDTO {
	private static final long serialVersionUID = 1L;
	private List<EmployeeBasicDTO> employees = new ArrayList<>();


	public CompanyFullDTO() {
	}

	public List<EmployeeBasicDTO> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeBasicDTO> employees) {
		this.employees = employees;
	}

}
