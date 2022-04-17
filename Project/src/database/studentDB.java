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
            System.out.println();

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
            System.out.println(student.printStudent());
        }else if(student instanceof humStudent) {
            System.out.println(student.printStudent());
        }else if(student instanceof combinedStudent){
            System.out.println(student.printStudent());
        }else{
            System.out.println("Student not found.");
        }

    }

    public void removeStudent(String StudentID){
        studentHashMap.remove(StudentID);
    }

    public void addGradeToStudent(String StudentID,Grade grade){
        studentHashMap.get(StudentID).addGrade(grade);
    }

    public void calcStudentAverage(String StudentID){

        HashMap<String,Float> averageComponents = studentHashMap.get(StudentID).gradeAVG();

        float avg = (averageComponents.get("gradeSUM"))/(averageComponents.get("gradeCOUNT"));
        System.out.println("Average grade: " + avg);


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

    public void calcFieldAverage(){


        float[] techAverageSUM={0};
        float[] techAverageCOUNT={0};

        float[] humAverageSUM={0};
        float[] humAverageCOUNT={0};

        float[] combinedAverageSUM={0};
        float[] combinedAverageCOUNT={0};

        studentHashMap.forEach((key, value) -> {

            HashMap<String,Float> averageComponents = value.gradeAVG();

            float gradeSUM = averageComponents.get("gradeSUM");
            float gradeCOUNT = averageComponents.get("gradeCOUNT");

            if(value instanceof techStudent){

                techAverageSUM[0]+=gradeSUM;
                techAverageCOUNT[0]+=gradeCOUNT;

            }
            else if(value instanceof humStudent){

                humAverageSUM[0]+=gradeSUM;
                humAverageCOUNT[0]+=gradeCOUNT;

            }
            else if(value instanceof combinedStudent){

                combinedAverageSUM[0]+=gradeSUM;
                combinedAverageCOUNT[0]+=gradeCOUNT;

            }
            else {System.out.println("How did we get here?");}


        });

        System.out.println("Technical field average: "+techAverageSUM[0]/techAverageCOUNT[0]);
        System.out.println("Human field average: "+humAverageSUM[0]/humAverageCOUNT[0]);
        System.out.println("Combined filed average: "+combinedAverageSUM[0]/combinedAverageCOUNT[0]);
        System.out.println("\n");



    }







}
