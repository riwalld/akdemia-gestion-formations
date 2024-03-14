package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.IInterSessionRepository;
import af.cmr.indyli.akdemia.business.dao.IParticularSouscriptionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.ParticularSouscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.ParticularSouscriptionFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.ParticularSouscriptionFullDTO;
import af.cmr.indyli.akdemia.business.entity.InterSession;
import af.cmr.indyli.akdemia.business.entity.ParticularSouscription;
import af.cmr.indyli.akdemia.business.entity.ParticularSouscription;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.IParticularSouscriptionService;
import af.cmr.indyli.akdemia.business.utils.ConstBusinessRules;
import af.cmr.indyli.akdemia.business.utils.ConstRejectBusinessMessage;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Service implementation class for managing {@link ParticularSouscription}
 * entity, extending the
 * AbstractAkdemiaServiceImpl class. This class provides specific functionality
 * for managing ParticularSouscriptions, including CRUD operations and
 * validation.
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.PARTICULAR_SOUSCRIPTION_SERVICE_KEY)
public class ParticularSouscriptionImpl extends
		AbstractAkdemiaServiceImpl<ParticularSouscription, ParticularSouscriptionBasicDTO, ParticularSouscriptionFullDTO, IParticularSouscriptionRepository>
		implements IParticularSouscriptionService {

	@Resource(name = ConstsValues.ConstsDAO.PART_SOUSCRIPTION_DAO_KEY)
	private IParticularSouscriptionRepository particularSouscriptionRepository;
	
	@Resource(name = ConstsValues.ConstsDAO.INTER_SESSION)
	private IInterSessionRepository interSessionRepository;
	
	public ParticularSouscriptionImpl() {
		super(ParticularSouscription.class, ParticularSouscriptionBasicDTO.class, ParticularSouscriptionFullDTO.class);
	}

	@Override
	public IParticularSouscriptionRepository getDAO() {
		return this.particularSouscriptionRepository;
	}

	@Override
	public ParticularSouscriptionFullDTO create(ParticularSouscriptionFullDTO view) throws AkdemiaBusinessException {
		
		ParticularSouscription employeeSouscription = particularSouscriptionRepository.findByParticularNameAndSessionCode(view.getParticular().getLastname(), view.getInterSession().getCode());
		System.out.println(particularSouscriptionRepository.findByInterSession(view.getInterSession().getCode()));
		if (employeeSouscription == null) {
			view.setCreationDate(new Date());
			if(particularSouscriptionRepository.findByInterSession(view.getInterSession().getCode()).size()>= particularSouscriptionRepository.findMinPArticipants(view.getInterSession().getCode()));{
				InterSession interSession =interSessionRepository.findById(view.getInterSession().getId()).get();
				interSession.setStatus(ConstsValues.SessionStatus.CONFIRMED);
				interSessionRepository.save(interSession);
			}
			ParticularSouscription entity = this.getDAO()
					.saveAndFlush(this.getModelMapper().map(view, ParticularSouscription.class));

			return this.getModelMapper().map(entity, ParticularSouscriptionFullDTO.class);
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG20);
	}

	@Override
	public ParticularSouscriptionFullDTO update(ParticularSouscriptionFullDTO viewToUpdate)
			throws AkdemiaBusinessException, AccessDeniedException {
		boolean isParticularSouscriptionExist = this.findAll().stream().anyMatch(
				p -> viewToUpdate.getId().equals(p.getId()));
		if (!isParticularSouscriptionExist) {
			viewToUpdate.setUpdateDate(new Date());
			ParticularSouscription entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
			if (entity != null) {
				BeanUtils.copyProperties(viewToUpdate, entity);
				this.getDAO().saveAndFlush(entity);
			} else {
				throw new AkdemiaBusinessException(ConstRejectBusinessMessage.UPDATE_OBJECT_NOT_FOUND);
			}
			return viewToUpdate;
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG06);
	}

	@Override
	public void deleteById(int id) throws AkdemiaBusinessException, AccessDeniedException {
		var tmpParticularSouscription = this.findById(id);

		if (tmpParticularSouscription == null) {
			throw new AkdemiaBusinessException(ConstRejectBusinessMessage.DELETE_OBJECT_NOT_FOUND);
		} else {
			this.getDAO().deleteById(id);
		}
	}
	
	@Override
	public List<ParticularSouscriptionFullDTO> findAllFull() {
		return this.getDAO().findAll().stream().map(p -> this.getModelMapper().map(p, ParticularSouscriptionFullDTO.class)).toList();
	}
	
	@Override
	public List<ParticularSouscriptionFullDTO> findBySession(Integer id) {
		return particularSouscriptionRepository.findByInterSessionId(id).stream().map(p -> this.getModelMapper().map(p, ParticularSouscriptionFullDTO.class)).toList();
	}

	@Override
	public void deleteByIdSessionAndIdParticular(int idSession, int idParticipant) {
		particularSouscriptionRepository.deleteByIdSessionAndIdParticular(idSession, idParticipant);
		
	}
}