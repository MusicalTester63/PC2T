public class BPC2 implements Predmet{

    private int pointsProject;
    private int pointsHalfExam;
    private int pointsFinalExam;
    public boolean problem;

    @Override
    public String getName() {
        return "BPC2";
    }

    @Override
    public int getPoints() {
        return pointsProject + pointsHalfExam + pointsFinalExam;
    }

    @Override
    public void evaluation() {
        if ((pointsProject + pointsHalfExam) >= pointsneeded){
            System.out.println(getName() + ": You have been evaluated.\nPoints:" + getPoints() +".");
            problem = false;
        } else {
            System.out.println(getName() + ": You don't have enough points for evaluation.");
            problem = true;
        }
    }

    public void setProjectPoints(int points){
        if (points < 31){
            pointsProject = points;
            problem = false;
        } else {
            System.out.println(": Maximum number of points from project is 30.");
            problem = true;
        }
    }

    public void setHalfExamPoints(int points){
        if (points < 21){
            pointsHalfExam = points;
            problem = false;
        } else {
            System.out.println(": Maximum number of points from half-semester exam is 20.");
            problem = true;
        }
    }

    public void setFinalExamPoints(int points){
        if (points < 51){
            pointsFinalExam = points;
            problem = false;
        } else {
            System.out.println(": Maximum number of points from final exam is 50.");
            problem = true;
        }
    }



}
