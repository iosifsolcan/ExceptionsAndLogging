package org.example.StudentRepository.Reader;

import org.example.StudentRepository.StudentRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ReadFromFile {
  BufferedReader reader;
  String line;
  private static final Logger logger = Logger.getLogger(ReadFromFile.class.getName());
  private String[] expression;
  List<StudentRepository> list = new ArrayList<>();

  public List<StudentRepository> readFromFile() {
    try {
      reader = new BufferedReader(new FileReader("src/main/resources/studentsData.txt"));
      reader.readLine();
      while ((line = reader.readLine()) != null) {
        StudentRepository student = new StudentRepository();
        if (!line.isBlank()) {
          expression = line.split(",");
          student.setFirstName(expression[0]);
          student.setLastName(expression[1]);
          student.setDateOfBirth(expression[2]);
          student.setGender(expression[3]);
          student.setID(expression[4]);
          list.add(student);
        }
      }

    } catch (IOException e) {
      logger.warning("something went wrong!");
      throw new RuntimeException(e);
    }
    return list;
  }
}
