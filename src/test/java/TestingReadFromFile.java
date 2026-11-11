import org.example.StudentRepository.AddStudent.AddStudent;
import org.example.StudentRepository.Reader.ReadFromFile;
import org.example.StudentRepository.StudentRepository;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TestingReadFromFile {

  private List<AddStudent> list = new ArrayList<>();
  private List<StudentRepository> studentRepositoryList = new ArrayList<>();
  private boolean validate = false;
  private int count;
  private int countValidStudents = 0;
  private static final Logger log = Logger.getLogger(TestingReadFromFile.class.getName());

  @Test
  public void testReadFromFile() {
    AddStudent student1 = new AddStudent();
    list = student1.addStudent();
    ReadFromFile read = new ReadFromFile();
    studentRepositoryList = read.readFromFile();
    for (int i = 0; i < studentRepositoryList.size(); i++) {
      count = 0;
      if (String.valueOf(list.get(i).getFirstName())
          .equalsIgnoreCase(String.valueOf(studentRepositoryList.get(i).getFirstName()))) count++;
      if (String.valueOf(list.get(i).getLastName())
          .equalsIgnoreCase(String.valueOf(studentRepositoryList.get(i).getLastName()))) count++;
      if (String.valueOf(list.get(i).getDateOfBirth())
          .equalsIgnoreCase(String.valueOf(studentRepositoryList.get(i).getDateOfBirth()))) count++;
      if (String.valueOf(list.get(i).getGender())
          .equalsIgnoreCase(String.valueOf(studentRepositoryList.get(i).getGender()))) count++;
      if (String.valueOf(list.get(i).getID())
          .equalsIgnoreCase(String.valueOf(studentRepositoryList.get(i).getID()))) count++;
      if (count == 5) {
        countValidStudents++;
      }
    }

    if (countValidStudents == list.size() && (list.size() == studentRepositoryList.size())) {
      validate = true;
    }
    if (validate) {
      assertEquals(true, validate);
      System.out.println(list.size() + " students are identical in both lists!");
    } else {
      log.warning(
          "Reader doesn't work properly , students data from list are not identical with studentRepositoryList afer reading from file!");
    }
  }
}
