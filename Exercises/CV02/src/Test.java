
import java.util.Scanner;


public class Test {

    public Test(){}


    private static int getInt(Scanner input) {

        try {
            input.hasNextInt();
            int x = input.nextInt();
            input.nextLine();
            return x;

        } catch (Exception var2) {

            System.out.println("Please input numbers: ");
            input.nextLine();
            return getInt(input);

        }

    }

    public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    BPC1 bpc1 = new BPC1();
    BPC2 bpc2 = new BPC2();
    BPIS bpis = new BPIS();


        System.out.println("Subject:\n1.BPC1\n2.BPC2\n3.BPIS\nChoose subject(1,2,3):");

        switch (getInt(input)) {
            case 1 -> {
                System.out.println(bpc1.getName() + ": Please input points from exercises(Max:20):");
                do {
                    bpc1.setExercises(getInt(input));
                } while (bpc1.problem);
                System.out.println(bpc1.getName() + ": Please input your points from final exam(Max:80):");
                do {
                    bpc1.setFinalExam(getInt(input));
                } while (bpc1.problem);
                bpc1.evaluation();
                input.close();
            }
            case 2 -> {
                System.out.println(bpc2.getName() + ": Please input your points from project(Max.30):");
                do {
                    bpc2.setProjectPoints(getInt(input));
                } while (bpc2.problem);
                System.out.println(bpc2.getName() + ": Please input your points from half-semester exam(max.20):");
                do {
                    bpc2.setHalfExamPoints(getInt(input));
                } while (bpc2.problem);
                System.out.println(bpc2.getName() + ": Please input your points from final exam(max.50):");
                do {
                    bpc2.setFinalExamPoints(getInt(input));
                } while (bpc2.problem);
                bpc2.evaluation();
                input.close();
            }
            case 3 -> {
                System.out.println(bpis.getName() + ": Please input your points(max.100):");
                do {
                    bpis.setPoints(getInt(input));
                } while (bpis.problem);
                bpis.evaluation();
                input.close();
            }
            default -> {
                System.out.println("Error: Wrong input!");
                input.close();
            }
        }

    }

}
