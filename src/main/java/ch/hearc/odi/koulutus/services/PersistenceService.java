/*
 * Copyright (c) 2019. Cours outils de développement intégré, HEG-Arc
 */

package ch.hearc.odi.koulutus.services;


import ch.hearc.odi.koulutus.business.Course;
import ch.hearc.odi.koulutus.business.Participant;
import ch.hearc.odi.koulutus.business.Pojo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceService {

  private EntityManagerFactory entityManagerFactory;

  public PersistenceService() {
    //  an EntityManagerFactory is set up once for an application
    //  IMPORTANT: the name here matches the name of persistence-unit in persistence.xml
    entityManagerFactory = Persistence.createEntityManagerFactory("ch.hearc.odi.koulutus.jpa");
  }

  @Override
  public void finalize() throws Throwable {
    entityManagerFactory.close();
    super.finalize();
  }

  public Pojo createAndPersistAPojo(String myProperty) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Pojo pojo = new Pojo();
    pojo.setSomeProperty(myProperty);
    entityManager.persist(pojo);
    entityManager.getTransaction().commit();
    entityManager.close();
    return pojo;
  }

  public ArrayList<Participant> getParticipants() {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    List<Participant> participants = entityManager
        .createQuery("from Participant", Participant.class)
        .getResultList();
    entityManager.getTransaction().commit();
    entityManager.close();
    return (ArrayList<Participant>) participants;
  }

  public Participant getParticipantById(Long participantId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Participant participant = entityManager.find(Participant.class, participantId);
/*
    if (participant == null) {
      throw new PersonException("Person " + personId + " was not found");
    }
*/
    entityManager.getTransaction().commit();
    entityManager.close();

    return participant;
  }

  public Participant createAndPersistParticipant(Participant participant) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    entityManager.persist(participant);
    entityManager.getTransaction().commit();
    entityManager.close();
    return participant;
  }

  public void deleteParticipantById(Long participantId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    Participant participant = entityManager.find(Participant.class, participantId);
    if (participant == null) {
      return;
    }
    entityManager.getTransaction().begin();
    entityManager.remove(participant);
    entityManager.getTransaction().commit();
    entityManager.close();
  }

  public Participant updateParticipantById(Long participantId, Participant newParticipant) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Participant participant = entityManager.find(Participant.class, participantId);
    participant.setFirstName(newParticipant.getFirstName());
    participant.setLastName(newParticipant.getLastName());
    participant.setBirthdate(newParticipant.getBirthdate());
    entityManager.getTransaction().commit();
    return participant;
  }

  public List<Course> getCoursesByParticipantId(Long participantId) {
    return null;
  }
}





