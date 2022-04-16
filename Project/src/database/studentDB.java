package database;

import studentModel.Grade;
import studentModel.Student;
import studentModel.ImplementedStudents.*;
import studentModel.eduFieldInterfaces.Zodiac;

import java.util.HashMap;


public class studentDB {


    private String dbNAME;

    private final HashMap<String, Student> studentHashMap = new HashMap<>();

    public studentDB(String dbNAME){
        this.dbNAME = dbNAME;

    }

    public void addStudentToDB(String studentId, Student student){
        this.studentHashMap.put(studentId,student);
    }

    public void printStudentDB(){

        studentHashMap.forEach((key, value) -> {

            System.out.println(value.printStudent());
            System.out.println("\n");
        });
    }

    public HashMap<String, Student> getStudentHashMap(){
        return studentHashMap;
    }

    public Student getStudent(String StudentID){
        return studentHashMap.get(StudentID);
    }

    public void printStudent(String StudentID){

        Student student = studentHashMap.get(StudentID);


        if(student instanceof techStudent) {
            System.out.println(((techStudent)student).printStudent());
        }else if(student instanceof humStudent) {
            System.out.println(((humStudent)student).printStudent());
        }else if(student instanceof combinedStudent){
            System.out.println(((combinedStudent)student).printStudent());
        }else {
            System.out.println("how did we get here?");
        }


    }

    public void removeStudent(String StudentID){
        studentHashMap.remove(StudentID);
    }

    public void addGradeToStudent(String StudentID,Grade grade){
        studentHashMap.get(StudentID).addGrade(grade);
    }

    public void calcStudentAverage(String StudentID){
        System.out.println("Average grade: " + studentHashMap.get(StudentID).gradeAVG());
    }

    public void changeStudentZodiac(String StudentID, Zodiac zodiacSign){

        Student student = studentHashMap.get(StudentID);

        if(student instanceof humStudent) {
            ((humStudent) studentHashMap.get(StudentID)).setZodiac(zodiacSign);
        }else if(student instanceof combinedStudent){
            ((combinedStudent) studentHashMap.get(StudentID)).setZodiac(zodiacSign);
        }
    }

    public void changeStudentLeapYear(String StudentID,Boolean leapYear){

        Student student = studentHashMap.get(StudentID);

        if(student instanceof techStudent) {
            ((techStudent)studentHashMap.get(StudentID)).setLeap(leapYear);
        }else if(student instanceof combinedStudent){
            ((combinedStudent) studentHashMap.get(StudentID)).setLeap(leapYear);
        }

    }

}
