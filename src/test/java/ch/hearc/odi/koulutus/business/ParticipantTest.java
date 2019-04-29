package ch.hearc.odi.koulutus.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ParticipantTest {
  @Test
  public void participantPropretiesTest(){
    int testPrice = 45;
    Program myProgram = new Program();
    myProgram.setPrice(45);
    assertEquals(testPrice, myProgram.getPrice());
  }
}
