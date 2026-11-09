package org.example.StudentRepository.CheckStudentData;

import org.example.StudentRepository.AddStudent.AddStudent;

import java.util.logging.Logger;

public class CheckData {
  private static final Logger logger = Logger.getLogger(CheckData.class.getName());

  public boolean checkStudentData(AddStudent student) {
    boolean valid = false;
    if (!(student.getFirstName().isEmpty()) && !(student.getLastName().isEmpty())) {
      String[] yearExtract = student.getDateOfBirth().split("-");
      if (Integer.parseInt(yearExtract[0]) >= 1900) {
        if ((student.getGender().equalsIgnoreCase("male,")
                || student.getGender().equalsIgnoreCase("female,"))
            || student.getGender().equalsIgnoreCase("m,")
            || student.getGender().equalsIgnoreCase("f,")) {
          valid = true;
        } else logger.warning("student gender is incorrect!");
      } else logger.warning("student year is below 1900 (not accepted!)");
    } else logger.warning("Student [firstName < - > lastName] are incorrect!");
    return valid;
  }
}
