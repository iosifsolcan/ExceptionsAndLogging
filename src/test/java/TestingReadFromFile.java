import lombok.Data;
import org.example.StudentRepository.AddStudent.AddStudent;
import org.example.StudentRepository.Reader.ReadFromFile;
import org.example.StudentRepository.StudentRepository;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Data
public class TestingReadFromFile {

  private List<AddStudent> list = new ArrayList<>();
  private List<StudentRepository> studentRepositoryList = new ArrayList<>();
  private List<AddStudent> testList = new ArrayList<>();
  private List<StudentRepository> testStudentRepositoryList = new ArrayList<>();
  private static final Logger log = Logger.getLogger(TestingReadFromFile.class.getName());
  private String firstName;
  private String lastName;
  private String dateOfBirth;
  private String gender;
  private String ID;
  private int count;
  private int countValidStudents = 0;
  private boolean valid = false;

  @Test
  public void testReadFromFile() {
    AddStudent student1 = new AddStudent();
    list = student1.addStudent();
    ReadFromFile read = new ReadFromFile();
    studentRepositoryList = read.readFromFile();

    for (AddStudent student : list) {
      AddStudent testing = new AddStudent();
      firstName = Arrays.toString(student.getFirstName().split(","));
      lastName = Arrays.toString(student.getLastName().split(","));
      dateOfBirth = Arrays.toString(student.getDateOfBirth().split(","));
      gender = Arrays.toString(student.getGender().split(","));
      ID = Arrays.toString(student.getID().split(","));
      testing.setFirstName("'" + firstName + "'");
      testing.setLastName("'" + lastName + "'");
      testing.setDateOfBirth("'" + dateOfBirth + "'");
      testing.setGender("'" + gender + "'");
      testing.setID("'" + ID + "'");
      testList.add(testing);
    }

    for (StudentRepository student : studentRepositoryList) {
      StudentRepository testing = new StudentRepository();
      firstName = Arrays.toString(student.getFirstName().split(","));
      lastName = Arrays.toString(student.getLastName().split(","));
      dateOfBirth = Arrays.toString(student.getDateOfBirth().split(","));
      gender = Arrays.toString(student.getGender().split(","));
      ID = Arrays.toString(student.getID().split(","));
      testing.setFirstName("'" + firstName + "'");
      testing.setLastName("'" + lastName + "'");
      testing.setDateOfBirth("'" + dateOfBirth + "'");
      testing.setGender("'" + gender + "'");
      testing.setID("'" + ID + "'");
      testStudentRepositoryList.add(testing);
    }
    for (int i = 0; i < list.size(); i++) {
      count = 0;
      if (testList
          .get(i)
          .getFirstName()
          .equalsIgnoreCase(testStudentRepositoryList.get(i).getFirstName())) count++;
      if (testList
          .get(i)
          .getLastName()
          .equalsIgnoreCase(testStudentRepositoryList.get(i).getLastName())) count++;
      if (testList
          .get(i)
          .getDateOfBirth()
          .equalsIgnoreCase(testStudentRepositoryList.get(i).getDateOfBirth())) count++;
      if (testList
          .get(i)
          .getGender()
          .equalsIgnoreCase(testStudentRepositoryList.get(i).getGender())) count++;
      if (testList.get(i).getID().equalsIgnoreCase(testStudentRepositoryList.get(i).getID()))
        count++;
      if (count == 5) countValidStudents++;
    }

    if (countValidStudents == list.size()) {
      valid = true;
      log.info("The list from AddStudent is identical to the list from ReadFromFile! ");
    } else log.warning("ReadFromFile doesn't work properly, lists data's are not same!");
    assertEquals(true, valid);
  }
}
