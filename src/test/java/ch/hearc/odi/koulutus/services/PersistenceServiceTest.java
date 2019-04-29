package ch.hearc.odi.koulutus.services;

import static org.junit.Assert.*;

import ch.hearc.odi.koulutus.business.Course;
import ch.hearc.odi.koulutus.business.Course.QuarterEnum;
import ch.hearc.odi.koulutus.business.Participant;
import ch.hearc.odi.koulutus.business.Program;
import ch.hearc.odi.koulutus.exception.ParticipantException;
import ch.hearc.odi.koulutus.exception.ProgramException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;

public class PersistenceServiceTest {

  private PersistenceService persistenceService;
  private EntityManagerFactory entityManagerFactory;

  @Before
  public void setUp() throws Exception {
    persistenceService = new PersistenceService();
    entityManagerFactory = Persistence.createEntityManagerFactory("ch.hearc.odi.koulutus.jpa");
  }

  @Test
  public void createAndPersistAProgram() throws ProgramException {
    Program program = new Program();
    program.setName("Cuisine coréenne");
    program.setRichDescription("Le Pays du matin calme se situe à la confluence entre la Chine et le Japon. Dans ce contexte spécifique, la cuisine coréenne, si elle semble plonger ses racines dans les traditions culinaires de ses voisins...");
    program.setField("Gatronomie");
    program.setPrice(150);
    program = persistenceService.createAndPersistProgram(program);
    long expectedProgramId = program.getId();
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    Program actualProgram = entityManager.find(Program.class, expectedProgramId);

    assertEquals(program, actualProgram);
  }

  @Test
  public void createAndPersistAParticipant() throws ParticipantException {
    Participant participant = new Participant();
    participant.setFirstName("Sabrina");
    participant.setLastName("Hillow");
    participant.setBirthdate("15.03.1997");
    participant = persistenceService.createAndPersistParticipant(participant);
    long expectedParticipantId = participant.getId();
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    Participant actualParticipant = entityManager.find(Participant.class, expectedParticipantId);

    assertEquals(participant, actualParticipant);
  }

  @Test
  public void createAndPersistACourse() throws Exception{
    Course course = new Course();
    //TODO: fix enum?
    course.setQuarter(QuarterEnum.NUMBER_2);
    course.setYear(2018);
    course.setMaxNumberOfParticipants(5);
    //TODO: test and add program if needed
    course = persistenceService.createAndPersistCourse(1L, course);
    long expectedCourseId = course.getId();
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    Course actualCourse = entityManager.find(Course.class, expectedCourseId);

    assertEquals(course, actualCourse);
  }
}