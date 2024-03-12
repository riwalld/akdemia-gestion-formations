package af.cmr.indyli.akdemia.business.dao;

import af.cmr.indyli.akdemia.business.entity.Training;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface serves as a repository for managing {@link Training} entities
 * in the database. It extends JpaRepository, providing CRUD operations for the
 * {@link Training} entity with Integer as the type of its primary key.
 */
@Repository(value = ConstsValues.ConstsDAO.TRAINING_KEY)
public interface ITrainingRepository extends JpaRepository<Training, Integer> {
    Training findByTitle(String title);
}