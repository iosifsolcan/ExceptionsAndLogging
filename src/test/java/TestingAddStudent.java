import org.example.StudentRepository.AddStudent.AddStudent;
import org.example.StudentRepository.CheckStudentData.CheckData;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class TestingAddStudent {
  private boolean valid;
  private final static Logger logger=Logger.getLogger(TestingAddStudent.class.getName());

  @Test
  public void testAddStudent() {
    AddStudent student = new AddStudent();
    student.setFirstName("Ioan,");
    student.setLastName("Mihalca,");
    student.setDateOfBirth("2000-05-11,");
    student.setGender("m,");
    student.setID("6344475235");
    CheckData checkData = new CheckData();
    valid = checkData.checkStudentData(student);
    if(valid)
      assertEquals(true, valid);
    else logger.warning("incorrect student data informations!");
  }
}
