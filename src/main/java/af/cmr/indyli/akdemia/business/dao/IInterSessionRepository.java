package af.cmr.indyli.akdemia.business.dao;

import af.cmr.indyli.akdemia.business.entity.EmployeeSouscription;
import af.cmr.indyli.akdemia.business.entity.InterSession;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * This interface serves as a repository for managing {@link InterSession} entities
 * in the database. It extends JpaRepository, providing CRUD operations for the
 * {@link InterSession} entity with Integer as the type of its primary key.
 */
@Repository(value = ConstsValues.ConstsDAO.INTER_SESSION)
public interface IInterSessionRepository extends JpaRepository<InterSession, Integer> {
	@Query("from InterSession m where m.training.title =:trainingTitle")
    List<InterSession> findByTrainingTitle(String trainingTitle);
}