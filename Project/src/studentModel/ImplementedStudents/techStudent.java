package studentModel.ImplementedStudents;

import studentModel.AbstractStudent;
import studentModel.eduField;
import studentModel.eduFieldInterfaces.*;

import java.awt.*;
import java.util.List;

public class techStudent extends AbstractStudent implements TECH {

    private boolean leapYear;

    public techStudent(Integer id, eduField education_field, List gradeL){
        super(id,education_field,gradeL);
    }

    public Boolean isLeap() {
        return leapYear;
    }

    public void setLeap(Boolean leapYear) {
        this.leapYear=leapYear;
    }

    @Override
    public String printStudent(){

        return "Student ID: "+getId()+
                "\nFirst Name: "+getFirstName()+
                "\nLast name: "+getLastName()+
                "\nEducation field: "+getEduField().toString()+
                "\nGrades: "+getGrades()+
                "\nLeap year: "+isLeap();
    }


}
