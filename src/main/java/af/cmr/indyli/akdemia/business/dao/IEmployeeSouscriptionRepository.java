package af.cmr.indyli.akdemia.business.dao;

import af.cmr.indyli.akdemia.business.entity.Company;
import af.cmr.indyli.akdemia.business.entity.Employee;
import af.cmr.indyli.akdemia.business.entity.EmployeeSouscription;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface serves as a repository for managing {@link EmployeeSouscription} entities
 * in the database. It extends JpaRepository, providing CRUD operations for the
 * {@link EmployeeSouscription} entity with Integer as the type of its primary key.
 */
@Repository(value = ConstsValues.ConstsDAO.EMPL_SOUSCRIPTION_DAO_KEY)
public interface IEmployeeSouscriptionRepository extends JpaRepository<EmployeeSouscription, Integer> {

}