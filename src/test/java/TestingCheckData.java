import org.example.StudentRepository.AddStudent.AddStudent;
import org.example.StudentRepository.CheckStudentData.CheckData;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class TestingCheckData {
  private boolean valid;
  @Test
  public void testingCheckData() {
    AddStudent student = new AddStudent();
    student.setFirstName("Ioan,");
    student.setLastName("Mihalca,");
    student.setDateOfBirth("2000-05-11,");
    student.setGender("m,");
    student.setID("6344475235");
    CheckData checkData = new CheckData();
    valid = checkData.checkStudentData(student);
    assertTrue(String.valueOf(true), valid);
  }
}
