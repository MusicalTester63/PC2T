public class BPIS implements Predmet {

    private int points;
    public boolean problem;

    public BPIS() {}

    public String getName() {
        return "BPPIS";
    }

    public int getPoints() {
        return this.points;
    }

    public void evaluation() {

        if (this.points > 14) {

            System.out.println(this.getName() + ": You have been evaluated!");

        } else {

            System.out.println(this.getName() + ": You don't have enough points for evaluation.");

        }
    }

    public void setPoints(int points) {
        if (points < 101) {
            this.points = points;
            this.problem = false;
        } else {
            System.out.println(": Maximum number of points if 100 per subject!");
            this.problem = true;
        }

    }
}






