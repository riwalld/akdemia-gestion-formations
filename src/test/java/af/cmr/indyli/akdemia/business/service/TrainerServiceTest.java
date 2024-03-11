package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp3eConfig;
import af.cmr.indyli.akdemia.business.dto.basic.TrainerBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.TrainerFullDTO;
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
public class TrainerServiceTest {

	@Resource(name = ConstsValues.ServiceKeys.TRAINER_SERVICE_KEY)
	private ITrainerService TrainerService;
	private TrainerFullDTO trainerForAllTest = null;

	private Integer idCreatedTrainer = null;

	@BeforeEach
	void setUp() throws AkdemiaBusinessException {
		TrainerFullDTO traning = getSampleTheme();
		this.trainerForAllTest = this.TrainerService.create(traning);

		System.out.println("ID CREATE... " + trainerForAllTest.getId());

		assertNotNull(traning);
	}

	@Test
	void testCreate() throws AkdemiaBusinessException {
		TrainerFullDTO theme = getSampleTheme();
		theme.setEmail("testNew@gmail.com");
		theme = this.TrainerService.create(theme);
		idCreatedTrainer = theme.getId();

		assertNotNull(theme);
	}

	@Test
	void testFindAll() {
		List<TrainerBasicDTO> themes = this.TrainerService.findAll();
		assertEquals(1, themes.size());
	}

	@Test
	void testFindById() throws AkdemiaBusinessException {
		TrainerFullDTO theme = this.TrainerService.findById(this.trainerForAllTest.getId());
		assertNotNull(theme);
		assertEquals(this.trainerForAllTest.getEmail(), theme.getEmail());
	}

	@Test
	void testUpdate() throws AkdemiaBusinessException, AccessDeniedException {
		TrainerFullDTO themeToUpdate = getSampleTheme();
		String updateEmail = "testmodif@gmail.com";
		themeToUpdate.setId(this.trainerForAllTest.getId());
		themeToUpdate.setEmail(updateEmail);

		TrainerFullDTO updatedTrainer = this.TrainerService.update(themeToUpdate);
		assertEquals(updateEmail, updatedTrainer.getEmail());
	}

	@Test
	void testDelete() throws AkdemiaBusinessException, AccessDeniedException {
		this.TrainerService.deleteById(this.trainerForAllTest.getId());

		assertNull(this.TrainerService.findById(this.trainerForAllTest.getId()));
		trainerForAllTest = null;
	}

	@AfterEach
	void rollback() throws AkdemiaBusinessException, AccessDeniedException {
		if (trainerForAllTest != null)
			this.TrainerService.deleteById(this.trainerForAllTest.getId());
		if (idCreatedTrainer != null)
			this.TrainerService.deleteById(idCreatedTrainer);
	}

	TrainerFullDTO getSampleTheme() {
		TrainerFullDTO theme = new TrainerFullDTO();
		theme.setEmail("My Trainer");
		theme.setActivity("Developer");
		theme.setCreationDate(new Date());

		return theme;
	}
}
