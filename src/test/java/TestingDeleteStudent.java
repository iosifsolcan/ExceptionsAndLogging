import org.example.StudentRepository.AddStudent.AddStudent;
import org.example.StudentRepository.CheckStudentData.CheckData;
import org.example.StudentRepository.Delete.DeleteStudent;
import org.example.StudentRepository.Reader.ReadFromFile;
import org.example.StudentRepository.StudentRepository;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class TestingDeleteStudent {
  private List<AddStudent> list = new ArrayList<>();
  private boolean valid = false;
  private List<StudentRepository> studentRepositoryList;
  private boolean deleted = false;

  @Test
  public void testDeleteStudent() throws IOException {
    AddStudent student = new AddStudent();
    student.setFirstName("Ionut,");
    student.setLastName("Andrei,");
    student.setDateOfBirth("2001-05-11,");
    student.setGender("m,");
    student.setID("6242475215");
    CheckData checkData = new CheckData();
    valid = checkData.checkStudentData(student);
    if (valid) {
      list.add(student);
    }
    ReadFromFile reader = new ReadFromFile();
    studentRepositoryList = reader.readFromFile();
    DeleteStudent deleteStudent = new DeleteStudent();
    deleted = deleteStudent.deleteStudent(studentRepositoryList);
    assertEquals(true, deleted);
  }
}
