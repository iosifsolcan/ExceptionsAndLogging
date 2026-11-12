package org.example.Comparator;

import org.example.StudentRepository.StudentRepository;

import java.util.List;

public class Comparator {
  public void compareByLastName(List<StudentRepository> list) {
    list.sort(
        java.util.Comparator.comparing(
            studentRepository -> String.valueOf(studentRepository.getLastName())));
  }

  public void compareByBirthDate(List<StudentRepository> list) {
    list.sort(
        java.util.Comparator.comparing(studentRepository -> studentRepository.getDateOfBirth()));
  }
}
