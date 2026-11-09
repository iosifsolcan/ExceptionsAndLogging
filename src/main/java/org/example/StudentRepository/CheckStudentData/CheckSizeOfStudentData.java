package org.example.StudentRepository.CheckStudentData;

import org.example.StudentRepository.AddStudent.AddStudent;

import java.util.logging.Logger;

public class CheckSizeOfStudentData {
  private static final Logger logger = Logger.getLogger(CheckSizeOfStudentData.class.getName());
  private final int size = 5;
  private int currentSize;

  public int checkSize(AddStudent student) {
    int count = 0;
    if (!student.getFirstName().isBlank()) count++;
    if (!student.getLastName().isBlank()) count++;
    if (!student.getDateOfBirth().isBlank()) count++;
    if (!student.getGender().isBlank()) count++;
    if (!student.getID().isBlank()) count++;
    if (count == size) {
      currentSize = size;
    } else logger.severe("Check student data again! --> some atributes are missing!");
    return currentSize;
  }
}
