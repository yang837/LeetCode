package exp;

public class Animals {
    private String name;
    private int id;

    Animals(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void eat() {
        System.out.println("eat");
    }

    public void sleep() {
        System.out.println("sleep");
    }
}