package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.IParticularSouscriptionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.ParticularSouscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.ParticularSouscriptionFullDTO;
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
@Service(ConstsValues.ServiceKeys.TRAINER_SERVICE_KEY)
public class ParticularSouscriptionImpl extends
		AbstractAkdemiaServiceImpl<ParticularSouscription, ParticularSouscriptionBasicDTO, ParticularSouscriptionFullDTO, IParticularSouscriptionRepository>
		implements IParticularSouscriptionService {

	@Resource(name = ConstsValues.ConstsDAO.TRAINER_KEY)
	private IParticularSouscriptionRepository ParticularSouscriptionRepository;

	public ParticularSouscriptionImpl() {
		super(ParticularSouscription.class, ParticularSouscriptionBasicDTO.class, ParticularSouscriptionFullDTO.class);
	}

	@Override
	public IParticularSouscriptionRepository getDAO() {
		return this.ParticularSouscriptionRepository;
	}

	@Override
	public ParticularSouscriptionFullDTO create(ParticularSouscriptionFullDTO view) throws AkdemiaBusinessException {
		Optional<ParticularSouscription> ParticularSouscription = this.getDAO().findById(view.getId());

		if (ParticularSouscription.isEmpty()) {
			view.setCreationDate(new Date());
			ParticularSouscription entity = this.getDAO()
					.saveAndFlush(this.getModelMapper().map(view, ParticularSouscription.class));
			view.setId(entity.getId());
			return view;
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG05);
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
}