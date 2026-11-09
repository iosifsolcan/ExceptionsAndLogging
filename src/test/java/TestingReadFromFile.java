import org.example.StudentRepository.AddStudent.AddStudent;
import org.example.StudentRepository.Reader.ReadFromFile;
import org.example.StudentRepository.StudentRepository;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class TestingReadFromFile {

  private List<AddStudent> list = new ArrayList<>();
  private List<StudentRepository> studentRepositoryList = new ArrayList<>();
  private boolean validate = false;
  private int count = 0;

  @Test
  public void testReadFromFile() {
    AddStudent student1 = new AddStudent();
    list = student1.addStudent();
    ReadFromFile read = new ReadFromFile();
    studentRepositoryList = read.readFromFile();
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getFirstName().equalsIgnoreCase(studentRepositoryList.get(i).getFirstName()))
        count++;
      if (list.get(i).getLastName().equalsIgnoreCase(studentRepositoryList.get(i).getLastName()))
        count++;
      if (list.get(i)
          .getDateOfBirth()
          .equalsIgnoreCase(studentRepositoryList.get(i).getDateOfBirth())) count++;
      if (list.get(i).getGender().equalsIgnoreCase(studentRepositoryList.get(i).getGender()))
        count++;
      if (list.get(i).getID().equalsIgnoreCase(studentRepositoryList.get(i).getID())) count++;
    }
    int validator = (list.size() * count) / list.size();
    if (validator % 2 != 0) {
      validate = true;
    }
    assertEquals(true, validate);
    System.out.println(count + " students are identical in both lists!");
  }
}
