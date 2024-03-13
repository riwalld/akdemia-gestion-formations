package af.cmr.indyli.akdemia.business.service;

import java.util.List;

import af.cmr.indyli.akdemia.business.dao.IEmployeeSouscriptionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.EmployeeSouscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.EmployeeSouscriptionFullDTO;
import af.cmr.indyli.akdemia.business.entity.EmployeeSouscription;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing user
 * EmployeeSouscription, providing specific operations for {@link EmployeeSouscription} entities.
 *
 * @see IAbstractAkdemiaService
 */
public interface IEmployeeSouscriptionService
		extends IAbstractAkdemiaService<EmployeeSouscription, EmployeeSouscriptionBasicDTO, EmployeeSouscriptionFullDTO, IEmployeeSouscriptionRepository> {

	List<EmployeeSouscriptionFullDTO> findAllFull();

}
