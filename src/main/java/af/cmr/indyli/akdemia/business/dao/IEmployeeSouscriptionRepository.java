package af.cmr.indyli.akdemia.business.dao;

import af.cmr.indyli.akdemia.business.dto.full.EmployeeSouscriptionFullDTO;
import af.cmr.indyli.akdemia.business.entity.EmployeeSouscription;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.transaction.Transactional;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * This interface serves as a repository for managing {@link EmployeeSouscription} entities
 * in the database. It extends JpaRepository, providing CRUD operations for the
 * {@link EmployeeSouscription} entity with Integer as the type of its primary key.
 */
@Repository(value = ConstsValues.ConstsDAO.EMPL_SOUSCRIPTION_DAO_KEY)
public interface IEmployeeSouscriptionRepository extends JpaRepository<EmployeeSouscription, Integer> {
	@Query("from EmployeeSouscription m where m.intraSession.code =:sessionCode and m.employee.lastname =:employeeName")
	    EmployeeSouscription findByEmployeeNameAndSessionCode(@Param("employeeName") String employeeName, @Param("sessionCode") String sessionCode);

	@Query("from EmployeeSouscription m where m.intraSession.id =:id")
	List<EmployeeSouscription> findByIntraSessionId(Integer id);

	@Modifying
	@Transactional
	@Query("delete from EmployeeSouscription m where m.intraSession.id = :intraSessionId and m.employee.id = :employeeId")
	void deleteByIdSessionAndIdEmployee(int intraSessionId, int employeeId);

}