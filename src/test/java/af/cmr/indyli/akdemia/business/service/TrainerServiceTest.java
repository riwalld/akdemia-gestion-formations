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

import java.io.Console;
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
		TrainerFullDTO trainer = getSampletrainer();
		trainer.setFirstName("myName");
		this.trainerForAllTest = this.TrainerService.create(trainer);

		System.out.println("ID CREATE... " + trainerForAllTest.getId());

		assertNotNull(trainer);
	}

	@Test
	void testCreate() throws AkdemiaBusinessException {
		TrainerFullDTO trainer = getSampletrainer();
		trainer.setEmail("testNew@gmail.com");
		trainer.setFirstName("myName");
		trainer = this.TrainerService.create(trainer);
		idCreatedTrainer = trainer.getId();

		assertNotNull(trainer);
	}

	@Test
	void testFindAll() {
		List<TrainerBasicDTO> trainers = this.TrainerService.findAll();
		assertEquals(1, trainers.size());
	}

	@Test
	void testFindById() throws AkdemiaBusinessException {
		TrainerFullDTO trainer = this.TrainerService.findById(this.trainerForAllTest.getId());
		assertNotNull(trainer);
		System.out.println(trainer.getFirstName());
		assertNotNull(trainer.getFirstName());
		assertEquals(this.trainerForAllTest.getEmail(), trainer.getEmail());
	}

	@Test
	void testUpdate() throws AkdemiaBusinessException, AccessDeniedException {
		TrainerFullDTO trainerToUpdate = getSampletrainer();
		String updateEmail = "testmodif@gmail.com";
		trainerToUpdate.setId(this.trainerForAllTest.getId());
		trainerToUpdate.setEmail(updateEmail);

		TrainerFullDTO updatedTrainer = this.TrainerService.update(trainerToUpdate);
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

	TrainerFullDTO getSampletrainer() {
		TrainerFullDTO trainer = new TrainerFullDTO();
		trainer.setEmail("My Trainer");
		trainer.setActivity("Developer");
		trainer.setCreationDate(new Date());

		return trainer;
	}
}
