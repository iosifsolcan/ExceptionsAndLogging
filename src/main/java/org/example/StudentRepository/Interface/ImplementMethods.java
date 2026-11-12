package org.example.StudentRepository.Interface;

import java.io.IOException;

public interface ImplementMethods {

  void addStudent();

  void readFromFile();

  void deleteStudent() throws IOException;

  void retrieveAllStudentsAgeX();

  void listStudents();

  void printList();

  void printReachedFinal();
}
