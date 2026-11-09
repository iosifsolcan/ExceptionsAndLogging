package org.example.StudentRepository.AddStudent;

import lombok.Data;
import org.example.StudentRepository.CheckStudentData.CheckData;
import org.example.StudentRepository.CheckStudentData.CheckSizeOfStudentData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Data
public class AddStudent {
  private String firstName;
  private String lastName;
  private String dateOfBirth;
  private String gender;
  private String ID;
  private List<AddStudent> list = new ArrayList<>();
  private static final Logger logger = Logger.getLogger(AddStudent.class.getName());
  private String[] validateYear;
  private boolean valid = false;
  private int count;

  public List<AddStudent> addStudent() {
    AddStudent student = new AddStudent();
    count = 0;
    student.setFirstName("Alin,");
    count++;
    student.setLastName("Petru,");
    count++;
    student.setDateOfBirth("2008-03-01,");
    count++;
    student.setGender("male,");
    count++;
    student.setID("4624975355");
    count++;
    CheckData check = new CheckData();
    CheckSizeOfStudentData checkSize = new CheckSizeOfStudentData();
    valid = check.checkStudentData(student);
    if (count == checkSize.checkSize(student) && valid) {
      list.add(student);
    } else logger.warning("Cannot create list -> size or incorrect student data information! ");

    AddStudent student2 = new AddStudent();
    count = 0;
    student2.setFirstName("Andrei,");
    count++;
    student2.setLastName("Ioachim,");
    count++;
    student2.setDateOfBirth("2005-06-04,");
    count++;
    student2.setGender("male,");
    count++;
    student2.setID("2324475655");
    count++;
    valid = check.checkStudentData(student2);
    if (count == checkSize.checkSize(student2) && valid) {
      list.add(student2);
    } else logger.warning("Cannot create list -> size or incorrect student data information! ");

    AddStudent student3 = new AddStudent();
    count = 0;
    student3.setFirstName("Andreea,");
    count++;
    student3.setLastName("Ioana,");
    count++;
    student3.setDateOfBirth("1997-02-04,");
    count++;
    student3.setGender("f,");
    count++;
    student3.setID("1324375345");
    count++;
    valid = check.checkStudentData(student3);
    if (count == checkSize.checkSize(student3) && valid) {
      list.add(student3);
    } else logger.warning("Cannot create list -> size or incorrect student data information! ");

    try (BufferedWriter writer =
        new BufferedWriter(new FileWriter("src/main/resources/studentsData.txt"))) {
      writer.write("firstName, ");
      writer.write("lastName, ");
      writer.write("dateOfBirth, ");
      writer.write("gender, ");
      writer.write("ID");
      writer.newLine();
      writer.newLine();
      for (AddStudent studentData : list) {
        writer.newLine();
        writer.write(studentData.firstName);
        writer.write(studentData.lastName);
        writer.write(studentData.dateOfBirth);
        writer.write(studentData.gender);
        writer.write(studentData.ID);
        writer.newLine();
      }
    } catch (IOException e) {
      logger.warning("something went wrong!");
      throw new RuntimeException(e);
    }

    return list;
  }
}
