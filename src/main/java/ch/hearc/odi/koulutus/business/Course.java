package ch.hearc.odi.koulutus.business;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Course  implements Serializable {

  private Long id;
  private int year;
  private int maxNumberOfParticipants;
  public enum CourseStatus {OPEN ("open"), CONFIRMED ("confirmed"), CANCELED ("canceled");
    private String coursStatus;
    //Constructeur
    CourseStatus(String coursStatus){
      this.coursStatus = coursStatus;
    }
    public String toString() { return super.toString().toLowerCase();}
  }
  private CourseStatus status;

  public enum QuarterEnum {NUMBER_1(Integer.valueOf(1)), NUMBER_2(Integer.valueOf(2)), NUMBER_3(Integer.valueOf(3)), NUMBER_4(Integer.valueOf(4)
    private Integer quarterEnum;
    //Constructeur
    QuarterEnum(Integer quarterEnum){
      this.quarterEnum = quarterEnum;
    }
    public String toString() { return super.toString().toLowerCase();}
  }
  private QuarterEnum quarter;
  private List<Session> sessions;

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getMaxNumberOfParticipants() {
    return maxNumberOfParticipants;
  }

  public void setMaxNumberOfParticipants(int maxNumberOfParticipants) {
    this.maxNumberOfParticipants = maxNumberOfParticipants;
  }

  public CourseStatus getStatus() {
    return status;
  }

  public void setStatus(CourseStatus status) {
    this.status = status;
  }

  public List<Session> getSessions() {
    return sessions;
  }

  public void setSessions(List<Session> sessions) {
    this.sessions = sessions;
  }

  public QuarterEnum getQuarter() {
    return quarter;
  }
  public void setQuarter(QuarterEnum quarter) {
    this.quarter = quarter;
  }
}
