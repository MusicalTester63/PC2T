package Animals;

public abstract class AbstractAnimal {

    protected byte age;
    public AbstractAnimal() {}
    public AbstractAnimal(byte age) {
        super();
        this.age = age;
    }

    public abstract String sound();

    public int getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

}