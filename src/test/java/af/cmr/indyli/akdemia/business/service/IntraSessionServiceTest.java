package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp3eConfig;
import af.cmr.indyli.akdemia.business.dto.basic.SessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.SessionFullDTO;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = { AkdemiaBusinessGp3eConfig.class })
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IntraSessionServiceTest {

	@Resource(name = ConstsValues.ServiceKeys.SESSION_SERVICE_KEY)
	private ISessionService SessionService;
	private SessionFullDTO sessionForAllTest = null;

	private Integer idCreatedSession = null;

	@BeforeEach
	void setUp() throws AkdemiaBusinessException {
		SessionFullDTO traning = getSampleTheme();
		this.sessionForAllTest = this.SessionService.create(traning);

		System.out.println("ID CREATE... " + sessionForAllTest.getId());

		assertNotNull(traning);
	}

	@Test
	void testCreate() throws AkdemiaBusinessException {
		SessionFullDTO session = getSampleTheme();
		session.setCode("05ghte");
		session = this.SessionService.create(session);
		idCreatedSession = session.getId();

		assertNotNull(session);
	}

	@Test
	void testFindAll() {
		List<SessionBasicDTO> themes = this.SessionService.findAll();
		assertEquals(1, themes.size());
	}

	@Test
	void testFindById() throws AkdemiaBusinessException {
		SessionFullDTO theme = this.SessionService.findById(this.sessionForAllTest.getId());
		assertNotNull(theme);
		assertEquals(this.sessionForAllTest.getCode(), theme.getCode());
	}

	@Test
	void testUpdate() throws AkdemiaBusinessException, AccessDeniedException {
		SessionFullDTO themeToUpdate = getSampleTheme();
		String updateCode = "anothercode0";
		themeToUpdate.setId(this.sessionForAllTest.getId());
		themeToUpdate.setCode(updateCode);

		SessionFullDTO updatedSession = this.SessionService.update(themeToUpdate);
		assertEquals(updateCode, updatedSession.getCode());
	}

	@Test
	void testDelete() throws AkdemiaBusinessException, AccessDeniedException {
		this.SessionService.deleteById(this.sessionForAllTest.getId());

		assertNull(this.SessionService.findById(this.sessionForAllTest.getId()));
		sessionForAllTest = null;
	}

	@AfterEach
	void rollback() throws AkdemiaBusinessException, AccessDeniedException {
		if (sessionForAllTest != null)
			this.SessionService.deleteById(this.sessionForAllTest.getId());
		if (idCreatedSession != null)
			this.SessionService.deleteById(idCreatedSession);
	}

	SessionFullDTO getSampleTheme() {
		SessionFullDTO theme = new SessionFullDTO();
		theme.setCode("codeSession");
		theme.setDescription("this is a good session");
		theme.setCreationDate(new Date());

		return theme;
	}
}
