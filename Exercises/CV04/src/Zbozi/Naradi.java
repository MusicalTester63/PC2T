package Zbozi;

public class Naradi extends Zbozi {

    private int zaruka;

    public Naradi(String jmeno, double cena, int warranty) {
        super(jmeno, cena);
        this.zaruka = warranty;
    }

    public int getZaruka() {
        return this.zaruka;
    }

    public void setZaruka(int warranty) {
        this.zaruka = warranty;
    }

    public String getJednotka() {
        return "mesiacov";
    }
}
