public class BPC1 implements Predmet{

    private int pointsExercises;
    private int pointsFinalExam;
    public boolean problem;

    public BPC1(){}

    public String getName(){return "BPC1";}

    public int getPoints(){return this.pointsExercises + this.pointsFinalExam;}

    public void evaluation() {

        if (this.pointsExercises >= pointsneeded) {

            System.out.println(this.getName() + ": You have been evaluated!");

        } else {

            System.out.println(this.getName() + ": You don't have enough points for evaluation.");

        }
    }

    public void setExercises(int points) {
        if (this.pointsExercises + points < 21) {
            this.pointsExercises += points;
            this.problem = false;
        } else {
            System.out.println(": Maximum number of points from exercises is 20");
            this.problem = true;
        }

    }

    public void setFinalExam(int points) {
        if (points < 81) {
            this.pointsFinalExam = points;
            this.problem = false;
        } else {
            System.out.println(": Maximum number of points from final exam is 80.");
            this.problem = true;
        }

    }





}
