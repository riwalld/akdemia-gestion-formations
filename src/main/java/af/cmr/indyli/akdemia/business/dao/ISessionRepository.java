package af.cmr.indyli.akdemia.business.dao;

import af.cmr.indyli.akdemia.business.entity.EmployeeSouscription;
import af.cmr.indyli.akdemia.business.entity.Session;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface serves as a repository for managing {@link Session} entities
 * in the database. It extends JpaRepository, providing CRUD operations for the
 * {@link Session} entity with Integer as the type of its primary key.
 */
@Repository(value = ConstsValues.ConstsDAO.SESSION_KEY)
public interface ISessionRepository extends JpaRepository<Session, Integer> {
    Session findSessionByCode(String code);
}