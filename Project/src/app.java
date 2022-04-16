import database.studentDB;
import studentModel.*;
import studentModel.ImplementedStudents.*;
import studentModel.eduFieldInterfaces.*;


import java.util.*;
import java.util.concurrent.TimeUnit;


@SuppressWarnings("FieldMayBeFinal")
public class app {





    //Vytvorenie scannera a instancie databázy s menom studentDatabase
    private Scanner sc = new Scanner(System.in);
    private studentDB db = new studentDB("studentDatabse");






    //METÓDY KTORÉ SA STARAJÚ O INPUT OD UŽÍVATEĽA
    private String input(){return sc.next();}

    private String stringInput(String prompt) {
        do {
            try {
                System.out.print(prompt);
                return input().trim();
            } catch (Exception e) {
                System.out.println("Error: Wrong input");
            }
        } while (true);
    }

    @SuppressWarnings("unused")
    private int numberInput(String prompt) {
        do {
            try {
                System.out.println(prompt);
                return Integer.parseInt(input().trim());
            } catch (Exception e) {
                System.out.println("Error: Wrong Input");
            }
        } while (true);
    }

    private List<Grade> gradeInput(){
        boolean run = true;

        List<Grade> gradeList = new ArrayList<>();
        System.out.println("(To end input:0)\nInput Grades:");
        while(run){

            Grade grade = new Grade();
            grade.setGrade(sc.nextInt());

            if(grade.getGrade() == 0){run=false;}
            else {
                gradeList.add(grade);
            }
        }

        return  gradeList;
    }






    //METÓDY KTORÉ SA STARAJÚ O HLAVNÉ MENU
    private int getAction() {
        try {
            return Integer.parseInt(input().trim());
        } catch (Exception e) {
            System.out.println("Error");
            return 0;
        }
    }

    private action getActionMenu(){

        int input;
        input = getAction();

        if (input == 1) {
            return action.ADD_STUDENT;
        } else if (input == 2) {
            return action.REMOVE_STUDENT;
        }else if (input == 3) {
            return action.SEARCH_STUDENT;
        } else if (input == 4) {
            return action.ADD_GRADE;
        } else if (input == 5) {
            return action.CALC_AVERAGE;
        }else if (input == 6) {
            return action.AC_ZODIAC;
        }else if (input == 7) {
            return action.AC_LEAPYEAR;
        }else if (input == 8) {
            return action.PRINTABC;
        }else if (input == 9) {
            return action.CALC_FAVERAGE;
        }else if (input == 10) {
            return action.COUNTALL;
        } else if (input == 11){
            return action.TESTING;
        } else if (input == 0) {
            return action.END;
        }else{
            System.out.println("Error, you'll be returned to main menu.");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return action.MAIN_MENU;
        }
    }

    private void printMenu() {
        System.out.println("STUDENT DATABASE APPLICAITION");
        System.out.println("-------------------------------------");
        System.out.println("1 - Add Student");
        System.out.println("2 - Remove Student");
        System.out.println("3 - Search student");
        System.out.println("4 - Add grades to student");
        System.out.println("5 - Calculate average");
        System.out.println("6 - Change zodiac of a student");
        System.out.println("7 - Change leap year of a student");
        System.out.println("8 - Print students sorted alphabetically");
        System.out.println("9 - Calculate grade average of each field");
        System.out.println("10 - Counts all students in each field");
        System.out.println("11 - CREATE INSTANCE OF STUDENT, ONE FROM EACH EDUCATION FIELD");
        System.out.println("0 - EXIT\n");
    }

    private void mainMenu(){
        action Action;
        printMenu();
        do
        {
            try {
                Action = getActionMenu();
            } catch (Exception e) {
                System.out.println("Error:Wrong input");
                continue;
            }


            switch (Action) {
                case ADD_STUDENT -> addStudent();
                case REMOVE_STUDENT -> removeStudent();
                case SEARCH_STUDENT -> searchStudent();
                case ADD_GRADE -> addGrades();
                case CALC_AVERAGE -> calcAverage();
                case AC_ZODIAC -> changeZodiac();
                case AC_LEAPYEAR -> changeLeapYear();
                case PRINTABC -> printAbcDB();
                case CALC_FAVERAGE -> calcFieldAverage();
                case COUNTALL -> countStudents();
                case TESTING -> test();
                case END -> {
                    System.out.println("Goodbye");
                    System.exit(0);
                }
            }
            printMenu();
        } while (true);
    }





    //MAIN METÓDA KTORÁ LEN SPUSTÍ INSTANCIU APLIKÁCIE
    public static void main(String[] args) {

        app Application = new app();
        Application.mainMenu();

    }







    //VÝPIS NAČÍTANEJ DATABÁZY
    @SuppressWarnings("unused")
    public void printDB(){db.printStudentDB();}

    //VYYTVORÍ INSTANCIU JEDNÉHO ŠTUDENTA Z KAŽDÉHO OBORU
    private void test(){

        Student student;
        List<Grade> grades = new ArrayList<>();

        for (int j =0;j<3;j++) {

            Random rand = new Random();
            int gradeCount = rand.nextInt(10);

            for (int i = 0; i < gradeCount; i++) {

                Grade grade = new Grade();
                Random randomGrade = new Random();
                int gradeValue = randomGrade.nextInt(6);
                if(gradeValue <= 0){gradeValue+=1;}

                grade.setGrade(gradeValue);
                grades.add(grade);

            }

            switch (j) {
                case 0 -> {
                    student = new techStudent(1, eduField.TECHNICAL, grades);
                    ((techStudent)student).setLeap(true);
                    student.setFirstName("David");
                    student.setLastName("Hamran");
                    db.addStudentToDB("1", student);
                }
                case 1 -> {
                    student = new humStudent(2, eduField.HUMAN, grades);
                    ((humStudent)student).setZodiac(Zodiac.AQUARIUS);
                    student.setFirstName("Michal");
                    student.setLastName("Vida");
                    db.addStudentToDB("2", student);
                }
                case 2 -> {
                    student = new combinedStudent(3, eduField.COMBINED, grades);
                    ((combinedStudent) student).setLeap(true);
                    ((combinedStudent)student).setZodiac(Zodiac.AQUARIUS);
                    student.setFirstName("Nemam");
                    student.setLastName("Kamaratov");
                    db.addStudentToDB("3", student);
                }
            }
        }

    }

    private void addStudent() {

        Student student;

        String firstName = stringInput("First name:");
        String lastName = stringInput("Last Name:");
        eduField educationField;

        do {
            String educationFieldString = stringInput("Education field(Technical/Human/Combined): ");

            //VYTVORENIE ŠTUDENTA TECHNICÉHO OBORU
            if (educationFieldString.equalsIgnoreCase("technical")) {
                educationField = eduField.TECHNICAL;
                var gradeL = gradeInput();


                student = new techStudent(230250, educationField,gradeL);
                db.addStudentToDB("230250",student);


            //VYTVORENIE ŠTUDENTA HUMANITNÉHO OBORU
            } else if (educationFieldString.equalsIgnoreCase("human")) {
                educationField = eduField.HUMAN;
                var gradeL = gradeInput();

                student = new humStudent(230251, educationField,gradeL);
                db.addStudentToDB("230251",student);



            //VYTVORENIE ŠTUDENTA KOMBINOVANÉHO OBORU
            } else if (educationFieldString.equalsIgnoreCase("combined")) {
                educationField = eduField.COMBINED;
                var gradeL = gradeInput();


                student = new combinedStudent(230522, educationField, gradeL);
                db.addStudentToDB("230252",student);

            } else {
                System.out.println("Error:Wrong input!");
                continue;
            }
            break;
        }while (true);



        //PRIDANIE PRECHODNEHO ROKU KU ŠTUDENOVI TECHNICKÉHO ALEBO KOMBINOVANÉHO OBORU
        if (educationField == eduField.TECHNICAL || educationField == eduField.COMBINED) {

            do {
                Boolean leapYear;
                try
                {
                    leapYear= Boolean.valueOf(stringInput("Leap year?(true/false)"));
                }
                catch (Exception e)
                {
                    System.out.println("Error:Wrong input!");
                    continue;
                }

                if(student instanceof techStudent){

                    ((techStudent)student).setLeap(leapYear);

                }
                else
                {

                    ((combinedStudent) student).setLeap(leapYear);

                }




                break;

            } while (true);
        }

        //PRIDANIE ZNAMENIA KU ŠTUDENOVI HUMANITNÉHO ALEBO KOMBINOVANÉHO OBORU
        if (educationField == eduField.HUMAN || educationField == eduField.COMBINED) {
            do {
                Zodiac zodiacSign;

                try {
                    zodiacSign = Zodiac.valueOf(stringInput("Zodiac sign: ").toUpperCase());
                }
                catch (Exception e) {
                System.out.println("Error:Wrong input!");
                continue;
                }


                if(student instanceof humStudent){

                    ((humStudent)student).setZodiac(zodiacSign);

                }
                else
                {

                    ((combinedStudent) student).setZodiac(zodiacSign);

                }


                break;

            } while (true);
        }

        //NA KONIEC NASTAVENIE MENA A PRIEZVISKA
        student.setFirstName(firstName);
        student.setLastName(lastName);
        System.out.println("\n\n");

    }

    //VYHĽADÁVANIE ŠTUDENTOV
    private void searchStudent() {

        System.out.println("SEARCHING\n-----------------------------------------");
        boolean searching=true;

        do {
            try {
                db.printStudent(stringInput("(To exit searching input:0)\nStudnet ID: "));
                if(stringInput("\nWould you like to search for another?(yes/no): ").equalsIgnoreCase("yes")){
                    continue;
                }
                searching = false;
            } catch (Exception e) {
                System.out.println("Student not found.\n");
                if(stringInput("Would you like to search for another?(yes/no): ").equalsIgnoreCase("no")){
                    searching=false;
                }
            }
        }while(searching);
    }

    //MAZANIE ŠTUDENTOV
    private void removeStudent(){

        System.out.println("REMOVING\n-----------------------------------------");
        boolean removing=true;

        do {
            try {
                db.removeStudent(stringInput("(To exit removing, input:0)\nStudnet ID: "));
                if(stringInput("\nWould you like to remove another?(yes/no): ").equalsIgnoreCase("yes")){
                    continue;
                }
                removing = false;
            } catch (Exception e) { //Nikdy nenastane - OPRAVIT
                System.out.println("Student not found.\n");
                if(stringInput("Would you like to remove another?(yes/no): ").equalsIgnoreCase("no")){
                    removing=false;
                }
            }
        }while(removing);
    }

    //PRIDANIE ZNÁMOK ŠTUDENTOVI
    private void addGrades(){

        System.out.println("ADDING GRADES\n-----------------------------------------");
        boolean adding=true;

        do {
            try {
                String studentID = stringInput("(To exit input:0)\nStudnet ID: ");
                db.printStudent(studentID);
                System.out.println("\n");

                var gradeList = gradeInput();

                for (var val : gradeList) {
                    db.addGradeToStudent(studentID, val);
                }

                if(stringInput("\nWould you like to add grades to another student?(yes/no): ").equalsIgnoreCase("yes")){
                    continue;
                }
                adding = false;
            } catch (Exception e) {
                System.out.println("\nStudent not found.\n");
                if(stringInput("Would you like to add grades to other student?(yes/no): ").equalsIgnoreCase("no")){
                    adding=false;
                }

            }
        }while(adding);
    }

    //SPOČÍTA PRIEMER VYBRANÉHO ŠTUDENTA
    private void calcAverage(){

        System.out.println("CALCULATE AVERAGE\n-----------------------------------------");
        boolean calc=true;

        do {
            try {
                String studentID = stringInput("(To exit input:0)\nStudnet ID: ");
                db.printStudent(studentID);
                db.calcStudentAverage(studentID);

                if(stringInput("\nWould you like to calculate average grade for another student?(yes/no): ").equalsIgnoreCase("yes")){
                    continue;
                }
                calc = false;
            } catch (Exception e) {
                System.out.println("\nStudent not found.\n");
                if(stringInput("Would you like to calculate grade average for other student?(yes/no): ").equalsIgnoreCase("no")){
                    calc=false;
                }

            }
        }while(calc);
    }

    //ZMENA ZNAMENIA PRE VYBRANÉHO ŠTUDENTA
    private void changeZodiac(){

        System.out.println("CHANGE/ADD ZODIAC\n-----------------------------------------");
        boolean zodiac=true;

        do {
            try {
                String studentID = stringInput("(To exit input:0)\nStudnet ID: ");
                Zodiac zodiacSign;


                if(db.getStudent(studentID) instanceof humStudent || db.getStudent(studentID) instanceof combinedStudent){
                    db.printStudent(studentID);
                    zodiacSign = Zodiac.valueOf(stringInput("Zodiac sign: ").toUpperCase());
                    db.changeStudentZodiac(studentID, zodiacSign);

                }else{
                    System.out.println("Student's education field isn't human or combined.");
                }

                if(stringInput("\nWould you like to change zodiac for another student?(yes/no): ").equalsIgnoreCase("yes")){
                    continue;
                }
                zodiac = false;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("\nStudent not found.\n");
                if(stringInput("Would you like to change zodiac for other student?(yes/no): ").equalsIgnoreCase("no")){
                    zodiac=false;
                }

            }
        }while(zodiac);


    }

    //ZMENA STAVU PRECHODNÉHO ROKU PRE VYBRANÉHO ŠTUDENTA
    @SuppressWarnings("WrapperTypeMayBePrimitive")
    private void changeLeapYear(){

        System.out.println("CHANGE/ADD LEAP YEAR\n-----------------------------------------");
        boolean leap=true;

        do {
            try {
                String studentID = stringInput("(To exit input:0)\nStudnet ID: ");
                Boolean leapYear;

                if(db.getStudent(studentID) instanceof techStudent || db.getStudent(studentID) instanceof combinedStudent){
                    db.printStudent(studentID);
                    leapYear = Boolean.valueOf(stringInput("Leap year?(true/false): ").toUpperCase());
                    db.changeStudentLeapYear(studentID, leapYear);

                }else{
                    System.out.println("Student's education field isn't technical or combined.");
                }

                if(stringInput("\nWould you like to change zodiac for another student?(yes/no): ").equalsIgnoreCase("yes")){
                    continue;
                }
                leap = false;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("\nStudent not found.\n");
                if(stringInput("Would you like to change zodiac for other student?(yes/no): ").equalsIgnoreCase("no")){
                    leap=false;
                }

            }
        }while(leap);
    }

    //VYPÍŠE ABECEDNE ZORADENÝCH ŠTUDENTOV
    private void printAbcDB(){

        System.out.println("PRINTABC not impemented yet");
    }

    //VYPÍŠE CELKOVÝ PRIEMER ŠTUDENTOV JEDNOTLIVÝCH OBOROV
    private void calcFieldAverage(){


        System.out.println("CALCFIELDAVERAGE not impemented yet");
    }

    //VYPÍŠE KOĽKO ŠTUDENTOV SA NACHÁDZA V OBOROCH
    private void countStudents(){

        final int[] tech = {0};
        final int[] hum = {0};
        final int[] comb = {0};

        HashMap<String, Student> studentHashMap = db.getStudentHashMap();

        studentHashMap.forEach((key, value) -> {

                    if(value instanceof techStudent){
                        tech[0]++;
                    }
                    else if(value instanceof humStudent){
                        hum[0]++;
                    }
                    else if(value instanceof combinedStudent){
                        comb[0]++;
                    }
                    else {System.out.println("How did we get here?");}

                }
        );

        System.out.println
                (
                        "Students studying technical educational field: "+ tech[0] +
                                "\nStudents studying human sciences: "+ hum[0] +
                                "\nStudents studying studying both: "+ comb[0]+"\n"
                );

    }



}
