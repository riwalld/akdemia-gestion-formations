package af.cmr.indyli.akdemia.business.dto.basic;

import af.cmr.indyli.akdemia.business.dto.IDTO;
import af.cmr.indyli.akdemia.business.entity.EmployeeSouscription;
import af.cmr.indyli.akdemia.business.dto.basic.IntraSessionBasicDTO;

import java.util.Date;

/**
 * This class represents a basic Data Transfer Object (DTO) for a
 * {@link EmployeeSouscription} entity.
 */

public class EmployeeSouscriptionBasicDTO implements IDTO {

	private Integer id;
	private String status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
