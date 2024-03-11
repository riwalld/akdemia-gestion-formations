package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp3eConfig;
import af.cmr.indyli.akdemia.business.dto.basic.TrainingBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.TrainingFullDTO;
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
public class TrainingServiceTest {

	@Resource(name = ConstsValues.ServiceKeys.TRAINING_SERVICE_KEY)
	private ITrainingService TrainingService;
	private TrainingFullDTO trainingForAllTest = null;

	private Integer idCreatedTraining = null;

	@BeforeEach
	void setUp() throws AkdemiaBusinessException {
		TrainingFullDTO traning = getSampleTheme();
		this.trainingForAllTest = this.TrainingService.create(traning);

		System.out.println("ID CREATE... " + trainingForAllTest.getId());

		assertNotNull(traning);
	}

	@Test
	void testCreate() throws AkdemiaBusinessException {
		TrainingFullDTO theme = getSampleTheme();
		theme.setTitle("Informatique");
		theme = this.TrainingService.create(theme);
		idCreatedTraining = theme.getId();

		assertNotNull(theme);
	}

	@Test
	void testFindAll() {
		List<TrainingBasicDTO> themes = this.TrainingService.findAll();
		assertEquals(1, themes.size());
	}

	@Test
	void testFindById() throws AkdemiaBusinessException {
		TrainingFullDTO theme = this.TrainingService.findById(this.trainingForAllTest.getId());
		assertNotNull(theme);
		assertEquals(this.trainingForAllTest.getTitle(), theme.getTitle());
	}

	@Test
	void testUpdate() throws AkdemiaBusinessException, AccessDeniedException {
		TrainingFullDTO themeToUpdate = getSampleTheme();
		String updateTitle = "Updated title";
		themeToUpdate.setId(this.trainingForAllTest.getId());
		themeToUpdate.setTitle(updateTitle);

		TrainingFullDTO updatedTraining = this.TrainingService.update(themeToUpdate);
		assertEquals(updateTitle, updatedTraining.getTitle());
	}

	@Test
	void testDelete() throws AkdemiaBusinessException, AccessDeniedException {
		this.TrainingService.deleteById(this.trainingForAllTest.getId());

		assertNull(this.TrainingService.findById(this.trainingForAllTest.getId()));
		trainingForAllTest = null;
	}

	@AfterEach
	void rollback() throws AkdemiaBusinessException, AccessDeniedException {
		if (trainingForAllTest != null)
			this.TrainingService.deleteById(this.trainingForAllTest.getId());
		if (idCreatedTraining != null)
			this.TrainingService.deleteById(idCreatedTraining);
	}

	TrainingFullDTO getSampleTheme() {
		TrainingFullDTO theme = new TrainingFullDTO();
		theme.setTitle("My Training");
		theme.setDescription("Example theme description");
		theme.setCreationDate(new Date());

		return theme;
	}
}
