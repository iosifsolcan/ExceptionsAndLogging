package org.example.StudentRepository.ListStudents;

import org.example.Comparator.Comparator;
import org.example.StudentRepository.StudentRepository;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class ListStudents {
  private boolean valid = true;
  private static final Logger logger = Logger.getLogger(ListStudents.class.getName());

  public boolean listStudents(List<StudentRepository> list) {
    for (StudentRepository student : list) {
      try {
        if (student.getFirstName().isBlank()
            || student.getLastName().isBlank()
            || student.getDateOfBirth().isBlank()
            || student.getGender().isBlank()
            || student.getID().isBlank()) {
          valid = false;
          logger.severe("StudentData incomplete!");
          throw new IOException("incomplete information about student!");
        }

      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
    }
    if (valid) {
      Comparator comparator = new Comparator();
      comparator.compareByLastName(list);
      System.out.println("studentsList sorted --> [byLastName]");
      for (StudentRepository studentData : list) {
        System.out.println(studentData);
      }
      System.out.println();
      Comparator comparator1 = new Comparator();
      comparator1.compareByBirthDate(list);
      System.out.println("studentsList sorted --> [byBirthDate]");
      for (StudentRepository studentData : list) {
        System.out.println(studentData);
      }
    } else {
      System.out.println("----> Reintroduce data corectly in file!");
    }

    return valid;
  }
}
