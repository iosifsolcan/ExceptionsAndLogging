package org.example.RunApp;

import org.example.StudentRepository.StudentRepository;

import java.io.IOException;

public class RunApp {
  public void runAplication() throws IOException {
    StudentRepository student = new StudentRepository();
    // *1
    student.addStudent();
    student.readFromFile();
    student.printList();
    System.out.println();
    // *2
    student.deleteStudent();
    System.out.println();
    // *3
    student.retrieveAllStudentsAgeX();
    System.out.println();
    // *4
    student.listStudents();
    System.out.println();
    // *5
    student.printReachedFinal();
  }
}
