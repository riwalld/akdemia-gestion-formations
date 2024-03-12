package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.ISessionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.SessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.SessionFullDTO;
import af.cmr.indyli.akdemia.business.entity.Session;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.ISessionService;
import af.cmr.indyli.akdemia.business.utils.ConstBusinessRules;
import af.cmr.indyli.akdemia.business.utils.ConstRejectBusinessMessage;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;

/**
 * Service implementation class for managing {@link Session} entity, extending the
 * AbstractAkdemiaServiceImpl class. This class provides specific functionality
 * for managing Sessions, including CRUD operations and validation.
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.SESSION_SERVICE_KEY)
public class SessionServiceImpl extends AbstractAkdemiaServiceImpl<Session, SessionBasicDTO, SessionFullDTO, ISessionRepository>
		implements ISessionService {

	@Resource(name = ConstsValues.ConstsDAO.SESSION_KEY)
	private ISessionRepository sessionRepository;

	public SessionServiceImpl() {
		super(Session.class, SessionBasicDTO.class, SessionFullDTO.class);
	}

	@Override
	public ISessionRepository getDAO() {
		return this.sessionRepository;
	}


	@Override
	public SessionFullDTO create(SessionFullDTO view) throws AkdemiaBusinessException {
		Session session = this.getDAO().findSessionByCode(view.getCode());

		if (session == null) {
			view.setCreationDate(new Date());
			Session entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, Session.class));
			view.setId(entity.getId());
			return view;
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG05);
	}

	@Override
	public SessionFullDTO update(SessionFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
		boolean isSessionExist = this.findAll().stream().anyMatch(
				p -> viewToUpdate.getCode().equals(p.getCode()) && !viewToUpdate.getId().equals(p.getId()));
		if (!isSessionExist) {
			viewToUpdate.setUpdateDate(new Date());
			Session entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
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
		var tmpSession = this.findById(id);

		if (tmpSession == null) {
			throw new AkdemiaBusinessException(ConstRejectBusinessMessage.DELETE_OBJECT_NOT_FOUND);
		}else {
			this.getDAO().deleteById(id);
		}
	}
}