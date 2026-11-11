package org.example.StudentRepository.Delete;

import lombok.Getter;
import org.example.StudentRepository.StudentRepository;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

@Getter
public class DeleteStudent {
  private String ID;
  private boolean valid = true;
  private Scanner scanner = new Scanner(System.in);
  private boolean removed;
  private String line;
  private String[] expression;
  private static final Logger logger = Logger.getLogger(DeleteStudent.class.getName());

  public boolean deleteStudent(List<StudentRepository> list) throws IOException {
    boolean idRemoved = false;
    for (StudentRepository student : list) {
      try {
        if (student.getID().isBlank()) {
          valid = false;
          logger.severe("ID is empty!");
          throw new IOException("ID doesn't exist!");
        }
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
    }
    if (valid) {
      System.out.println("Enter the ID student u want to delete!");
      ID = scanner.nextLine().trim();
      removed = list.removeIf(studentRepository -> studentRepository.getID().trim().equals(ID));
      if (removed) {
        idRemoved = true;
        System.out.println(ID + " --> Student deleted succesfully");
      } else {
        System.out.println("Try another ID");
        ID = scanner.nextLine().trim();
        removed = list.removeIf(studentRepository -> studentRepository.getID().trim().equals(ID));
        if (removed) {
          idRemoved = true;
          System.out.println(ID + " --> Student deleted succesfully");
        } else {
          logger.info("The second id u entered doesn't match with any student id!");
        }
        logger.info("The first id u entered doesn't match with any student id!");
        System.out.println("U wanna try again?");
        String yesOrNo;
        yesOrNo = scanner.nextLine();
        if (yesOrNo.equalsIgnoreCase("yes")) {
          DeleteStudent deleteStudent = new DeleteStudent();
          deleteStudent.deleteStudent(list);
        } else if (yesOrNo.equalsIgnoreCase("no")) {
          logger.info("I'm sorry, maybe next time!");
        }
      }
      try (BufferedWriter writer =
              new BufferedWriter(
                  new FileWriter("src/main/resources/students_After_ID_Elimination.txt"));
          BufferedReader reader =
              new BufferedReader(new FileReader("src/main/resources/studentsData.txt"))) {
        writer.newLine();
        while ((line = reader.readLine()) != null) {
          if (!line.isBlank()) {
            writer.newLine();
            expression = line.split(",");
            if (!(expression[4].trim().equals(ID))) {
              writer.write(line);
              writer.newLine();
            } else {
              writer.write("<Student removed> --> ID : " + ID);
              writer.newLine();
            }
          }
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    } else System.out.println("----> Reintroduce data corectly in file!");

    return idRemoved;
  }
}
