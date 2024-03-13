package af.cmr.indyli.akdemia.business.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * This class represents an ParticularSouscription entity. It encapsulates information about
 * the amount of employees suscribed to an intra-session
 */
@Entity
@Table(name = "AKDEMIA_PARTICULAR_SOUSCRIPTION")
public class ParticularSouscription implements IEntity {

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
	@JoinColumn(name = "ID_AKDEMIA_INTER_SESSION" )
	private InterSession interSession;
	@ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "ID_AKDEMIA_PARTICULAR")
	private Particular particular;

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

	public InterSession getInterSession() {
		return interSession;
	}

	public void setInterSession(InterSession interSession) {
		this.interSession = interSession;
	}

	public Particular getParticular() {
		return particular;
	}

	public void setParticular(Particular particular) {
		this.particular = particular;
	}
	
}
