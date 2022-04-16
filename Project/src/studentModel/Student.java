package studentModel;

import java.util.List;

public interface Student {

    Integer getId();

    String getLastName();

    String getFirstName();

    eduField getEduField();

    List<Integer> getGrades();

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void addGrade(Grade grade);

    float gradeAVG();

    String printStudent();


}
