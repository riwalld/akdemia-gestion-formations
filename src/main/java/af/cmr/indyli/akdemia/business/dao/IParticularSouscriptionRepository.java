package af.cmr.indyli.akdemia.business.dao;

import af.cmr.indyli.akdemia.business.entity.EmployeeSouscription;
import af.cmr.indyli.akdemia.business.entity.ParticularSouscription;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * This interface serves as a repository for managing {@link ParticularSouscription} entities
 * in the database. It extends JpaRepository, providing CRUD operations for the
 * {@link ParticularSouscription} entity with Integer as the type of its primary key.
 */
@Repository(value = ConstsValues.ConstsDAO.PART_SOUSCRIPTION_DAO_KEY)
public interface IParticularSouscriptionRepository extends JpaRepository<ParticularSouscription, Integer> {
	
	@Query("from ParticularSouscription m where m.interSession.code =:code and m.particular.lastname =:lastname")
	ParticularSouscription findByParticularNameAndSessionCode(String lastname, String code);

}