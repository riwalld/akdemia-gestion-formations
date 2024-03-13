package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp3eConfig;
import af.cmr.indyli.akdemia.business.dto.basic.IntraSessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.SessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.TrainerBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.TrainingBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.IntraSessionFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.TrainerFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.TrainingFullDTO;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = { AkdemiaBusinessGp3eConfig.class })
@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IntraSessionServiceTest {

	@Resource(name = ConstsValues.ServiceKeys.INTRA_SESSION_SERVICE_KEY)
	private IIntraSessionService intraSessionService;

	@Resource(name = ConstsValues.ServiceKeys.TRAINER_SERVICE_KEY)

	private ITrainerService iTrainerService;
	@Resource(name = ConstsValues.ServiceKeys.TRAINING_SERVICE_KEY)

	private ITrainingService iTrainingService;
	private IntraSessionFullDTO sessionForAllTest = null;
	private Integer idCreatedSession = null;

	@BeforeAll
	void prepare() throws AkdemiaBusinessException {

	}
/*
	@BeforeEach
	void setUp() throws AkdemiaBusinessException {
		
		TrainingFullDTO training = new TrainingFullDTO();
		training.setTitle("new formation");
		iTrainingService.create(training);

		TrainerFullDTO trainer = new TrainerFullDTO();
		trainer.setFirstname("myname");
		trainer.setEmail("tesff");
		iTrainerService.create(trainer);
		
		
		IntraSessionFullDTO traning = getSampleTheme();
		
		
		traning.setTrainer(new TrainerBasicDTO());
		traning.setTraining(iTrainingService.findById(1));
		traning.setDate(new Date());
		this.sessionForAllTest = this.intraSessionService.create(traning);

		System.out.println("ID CREATE... " + sessionForAllTest.getId());

		assertNotNull(traning);
	}

	@Test
	void testCreate() throws AkdemiaBusinessException {
		IntraSessionFullDTO session = getSampleTheme();
		session.setCode("05ghte");
		session = this.intraSessionService.create(session);
		idCreatedSession = session.getId();

		assertNotNull(session);
	}

	@Test
	void testFindAll() {
		List<IntraSessionFullDTO> themes = this.intraSessionService.findAllFull();
		assertEquals(1, themes.size());
	}

	@Test
	void testFindById() throws AkdemiaBusinessException {
		IntraSessionFullDTO theme = this.intraSessionService.findById(this.sessionForAllTest.getId());
		assertNotNull(theme);
		assertEquals(this.sessionForAllTest.getCode(), theme.getCode());
	}

	@Test
	void testUpdate() throws AkdemiaBusinessException, AccessDeniedException {
		IntraSessionFullDTO themeToUpdate = getSampleTheme();
		String updateCode = "anothercode0";
		themeToUpdate.setId(this.sessionForAllTest.getId());
		themeToUpdate.setCode(updateCode);

		IntraSessionFullDTO updatedSession = this.intraSessionService.update(themeToUpdate);
		assertEquals(updateCode, updatedSession.getCode());
	}

	@Test
	void testDelete() throws AkdemiaBusinessException, AccessDeniedException {
		this.intraSessionService.deleteById(this.sessionForAllTest.getId());

		assertNull(this.intraSessionService.findById(this.sessionForAllTest.getId()));
		sessionForAllTest = null;
	}

	@AfterEach
	void rollback() throws AkdemiaBusinessException, AccessDeniedException {
		iTrainingService.deleteById(0);
		iTrainerService.deleteById(0);
		if (sessionForAllTest != null)
			this.intraSessionService.deleteById(this.sessionForAllTest.getId());
		if (idCreatedSession != null)
			this.intraSessionService.deleteById(idCreatedSession);
	}

	IntraSessionFullDTO getSampleTheme() throws AkdemiaBusinessException {

		IntraSessionFullDTO theme = new IntraSessionFullDTO();
		theme.setCode("codeSession");
		theme.setDescription("this is a good session");
		theme.setTraining(iTrainingService.findById(1));
		theme.setTrainer(iTrainerService.findById(1));
		theme.setCreationDate(new Date());

		return theme;
	}*/
}
