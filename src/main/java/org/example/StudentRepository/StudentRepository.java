package org.example.StudentRepository;

import lombok.Data;
import org.example.PrintList.PrintList;
import org.example.StudentRepository.AddStudent.AddStudent;
import org.example.StudentRepository.AgeX.RetrieveAgeX;
import org.example.StudentRepository.Delete.DeleteStudent;
import org.example.StudentRepository.Interface.ImplementMethods;
import org.example.StudentRepository.ListStudents.ListStudents;
import org.example.StudentRepository.Reader.ReadFromFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
public class StudentRepository implements ImplementMethods {
  private String firstName;
  private String lastName;
  private String dateOfBirth;
  private String gender;
  private String ID;
  private List<StudentRepository> list = new ArrayList<>();
  private List<String> retrieveAgeXList = new ArrayList<>();
  private boolean reachedFinal = false;
  private int countThePassedMethods = 0;
  private boolean removed = false;

  // Adding students to list and file!
  public void addStudent() {
    AddStudent addStudent = new AddStudent();
    addStudent.addStudent();
    countThePassedMethods++;
  }

  // Read students from file and create another list for implementation of methods!
  public void readFromFile() {
    ReadFromFile reader = new ReadFromFile();
    list = reader.readFromFile();
    countThePassedMethods++;
  }

  // Delete students by id from list and file!
  public void deleteStudent() throws IOException {
    DeleteStudent delete = new DeleteStudent();
    removed = delete.deleteStudent(list);
    if (removed) countThePassedMethods++;
  }

  // Retrieve students with ageX from list and create another list with retrieved ones!
  public void retrieveAllStudentsAgeX() {
    RetrieveAgeX ageX = new RetrieveAgeX();
    retrieveAgeXList = ageX.retrieveAgeX(list);
    PrintList printListAgeX = new PrintList();
    if (retrieveAgeXList != null) {
      printListAgeX.printList(retrieveAgeXList);
      if (ageX.getPassMethod()) {
        countThePassedMethods++;
      }
    }
  }

  // List students only if every student information is valid and then compare by LastName and
  // BirthDate!
  public void listStudents() {
    ListStudents listStudents = new ListStudents();
    listStudents.listStudents(list);
    countThePassedMethods++;
  }

  // Print students list!
  public void printList() {
    System.out.println("                                    Students<->Informations");
    for (StudentRepository student : list) {
      System.out.println(student);
    }
  }

  // Print a message to inform user of passing methods!
  public void printReachedFinal() {
    if (countThePassedMethods == 5) {
      reachedFinal = true;
    }
    if (reachedFinal) {
      System.out.println(" U successfully reached the final with 5/5 methods passed!");
    } else
      System.out.println(
          " You've reached the final, but not all 5/5 methods were passed successfully!");
  }

  @Override
  public String toString() {
    return "| "
        + "firstName='"
        + firstName
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        + ", dateOfBirth='"
        + dateOfBirth
        + '\''
        + ", gender='"
        + gender
        + '\''
        + ", ID='"
        + ID
        + '\''
        + " |";
  }
}
