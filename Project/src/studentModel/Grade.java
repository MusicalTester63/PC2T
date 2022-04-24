package studentModel;

import java.io.Serializable;

public class Grade implements Serializable {

    private int grade;

    // miesto pre pripadne rozsirenia, cas oznamkovania, predmet, atd..

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


}
