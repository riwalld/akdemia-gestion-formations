package af.cmr.indyli.akdemia.business.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an InterSession entity. It encapsulates information about
 * the amount of employees suscribed to an intra-session
 */
@Entity
@Table(name = "AKDEMIA_INTRA_SESSION")
public class IntraSession extends Session {

    @OneToMany(mappedBy = "intraSession", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private List<EmployeeSouscription> employeeSouscriptions = new ArrayList<>();

    @ManyToOne(
            fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_AKDEMIA_COMPANY"
    )
    private Company company;

	public List<EmployeeSouscription> getEmployeeSouscriptions() {
		return employeeSouscriptions;
	}

	public void setEmployeeSouscriptions(List<EmployeeSouscription> employeeSouscriptions) {
		this.employeeSouscriptions = employeeSouscriptions;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
