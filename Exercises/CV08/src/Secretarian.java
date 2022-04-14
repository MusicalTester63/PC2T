



public class Secretarian extends Employee {

    private int age;

    public Secretarian(String nickName, String email, char[] password, EmployeeType employeeType, int age) {
        super(nickName, email, password, employeeType);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Secretarian [age=" + age + ", nickname=" + getNickname() + ", email=" + getEmail() + ", password=" + new String(getPassword()) + ", employee="
                + getEmployeeType() + "]";
    }

}