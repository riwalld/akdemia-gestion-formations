package af.cmr.indyli.akdemia.business.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * This class represents an EmployeeSouscription entity. It encapsulates information about
 * the amount of employees suscribed to an intra-session
 */
@Entity
@Table(name = "AKDEMIA_EMPLOYEE_SOUSCRIPTION")
public class EmployeeSouscription implements IEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	@ManyToOne(optional = false, cascade = CascadeType.DETACH)
	@JoinColumn(name = "ID_AKDEMIA_INTRA_SESSION")
	private IntraSession intraSession;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "ID_AKDEMIA_EMPLOYEE")
	private Employee employee;
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {this.id=id;

	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public IntraSession getIntraSession() {
		return intraSession;
	}

	public void setIntraSession(IntraSession intraSession) {
		this.intraSession = intraSession;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
