package org.example.StudentRepository.AgeX;

import lombok.Data;
import org.example.StudentRepository.StudentRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

@Data
public class RetrieveAgeX {
  private int age;
  private int currentYear = LocalDate.now().getYear();
  private int currentAge;
  private Scanner scanner = new Scanner(System.in);
  private final List<String> retrieveAgeXList = new ArrayList<>();
  private static final Logger logger = Logger.getLogger(RetrieveAgeX.class.getName());
  private boolean passMethod = false;

  public List<String> retrieveAgeX(List<StudentRepository> list) {
    System.out.println("Enter the age u want to retrieve -> ");
    age = scanner.nextInt();
    for (int i = 0; i < list.size(); i++) {
      String[] expression = list.get(i).getDateOfBirth().split("-");
      if (Integer.parseInt(expression[0]) > 1900) {
        currentAge = currentYear - Integer.parseInt(expression[0]);
        if (age == currentAge) {
          retrieveAgeXList.add(String.valueOf(list.get(i)));
        }
      }
    }
    if (!(retrieveAgeXList.isEmpty())) {
      System.out.println("[All students with age " + age + "] |");
      System.out.println("                     *     |     *");
      System.out.println("                       *   |   *");
      System.out.println("                           *   ");
      passMethod = true;
    } else {
      System.out.println("None of the students have this age!");
      logger.info("RetrieveAgeXList is empty!");
    }
    return retrieveAgeXList;
  }

  public boolean getPassMethod() {
    return passMethod;
  }
}
