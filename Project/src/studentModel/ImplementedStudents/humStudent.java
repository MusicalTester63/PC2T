package studentModel.ImplementedStudents;

import studentModel.AbstractStudent;
import studentModel.Grade;
import studentModel.eduField;
import studentModel.eduFieldInterfaces.HUM;
import studentModel.eduFieldInterfaces.Zodiac;

import java.util.List;

public class humStudent extends AbstractStudent implements HUM {

    private Zodiac zodiacSign;

    public humStudent(Integer id, eduField education_field,List<Grade> gradeL) {
        super(id, education_field,gradeL);
    }

    public Zodiac getZodiac() {
        return zodiacSign;
    }

    public void setZodiac(Zodiac zodiacSign) {
        this.zodiacSign = zodiacSign;
    }

    @Override
    public String printStudent(){

        return "Student ID: "+getId()+
                "\nFirst Name: "+getFirstName()+
                "\nLast name: "+getLastName()+
                "\nEducation field: "+getEduField().toString()+
                "\nGrades: "+getGrades()+
                "\nZodiac: "+getZodiac();


    }
}
