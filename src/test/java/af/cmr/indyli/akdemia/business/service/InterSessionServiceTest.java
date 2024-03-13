package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp3eConfig;
import af.cmr.indyli.akdemia.business.dto.basic.InterSessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.TrainingBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.InterSessionFullDTO;
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
public class InterSessionServiceTest {

	@Resource(name = ConstsValues.ServiceKeys.INTER_SESSION_SERVICE_KEY)
	private IInterSessionService InterSessionService;
	private InterSessionFullDTO sessionForAllTest = null;

	private Integer idCreatedInterSession = null;
/*
	@BeforeEach
	void setUp() throws AkdemiaBusinessException {
		InterSessionFullDTO traning = getSampleInterSession();
		this.sessionForAllTest = this.InterSessionService.create(traning);

		System.out.println("ID CREATE... " + sessionForAllTest.getId());

		assertNotNull(traning);
	}

	@Test
	void testCreate() throws AkdemiaBusinessException {
		InterSessionFullDTO session = getSampleInterSession();
		session.setCode("05ghte");
		session = this.InterSessionService.create(session);
		idCreatedInterSession = session.getId();

		assertNotNull(session);
	}

	@Test
	void testFindAll() {
		
		List<InterSessionBasicDTO> themes = this.InterSessionService.findAll();
		assertEquals(1, themes.size());
	}

	@Test
	void testFindById() throws AkdemiaBusinessException {
		InterSessionFullDTO theme = this.InterSessionService.findById(this.sessionForAllTest.getId());
		assertNotNull(theme);
		assertEquals(this.sessionForAllTest.getCode(), theme.getCode());
	}

	@Test
	void testUpdate() throws AkdemiaBusinessException, AccessDeniedException {
		InterSessionFullDTO themeToUpdate = getSampleInterSession();
		String updateCode = "anothercode0";
		themeToUpdate.setId(this.sessionForAllTest.getId());
		themeToUpdate.setCode(updateCode);

		InterSessionFullDTO updatedInterSession = this.InterSessionService.update(themeToUpdate);
		assertEquals(updateCode, updatedInterSession.getCode());
	}

	@Test
	void testDelete() throws AkdemiaBusinessException, AccessDeniedException {
		this.InterSessionService.deleteById(this.sessionForAllTest.getId());

		assertNull(this.InterSessionService.findById(this.sessionForAllTest.getId()));
		sessionForAllTest = null;
	}

	@AfterEach
	void rollback() throws AkdemiaBusinessException, AccessDeniedException {
		if (sessionForAllTest != null)
			this.InterSessionService.deleteById(this.sessionForAllTest.getId());
		if (idCreatedInterSession != null)
			this.InterSessionService.deleteById(idCreatedInterSession);
	}

	InterSessionFullDTO getSampleInterSession() {
		TrainingBasicDTO training = new TrainingBasicDTO();
		InterSessionFullDTO theme = new InterSessionFullDTO();
		theme.setCode("codeInterSession");
		
		
		theme.setDescription("this is a good session");
		theme.setCreationDate(new Date());

		return theme;
	}*/
}
