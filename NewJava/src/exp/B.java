package exp;

public class B implements A {
    @Override
    public void eat() {
        System.out.println("B eat");
    }

    @Override
    public void sleep() {
        System.out.println("B sleep");
    }
}
