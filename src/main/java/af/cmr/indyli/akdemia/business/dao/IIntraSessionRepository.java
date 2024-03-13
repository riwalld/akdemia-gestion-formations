package af.cmr.indyli.akdemia.business.dao;

import af.cmr.indyli.akdemia.business.entity.EmployeeSouscription;
import af.cmr.indyli.akdemia.business.entity.IntraSession;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * This interface serves as a repository for managing {@link IntraSession} entities
 * in the database. It extends JpaRepository, providing CRUD operations for the
 * {@link IntraSession} entity with Integer as the type of its primary key.
 */
@Repository(value = ConstsValues.ConstsDAO.INTRA_SESSION)
public interface IIntraSessionRepository extends JpaRepository<IntraSession, Integer> {
	@Query("from IntraSession m where m.training.title =:trainingTitle")
    List<IntraSession> findByTrainingTitle(String trainingTitle);

}