package exp9;

import java.util.Random;

public class MathRandom {
    public static int getEvenNum(double num1, double num2) {
        int s = (int)num1 + (int)(Math.random() * (num2 - num1));
        return s;
    }

    public static char getRandomChar(char cha1, char cha2) {
        return (char) (cha1 + Math.random() * (cha2 - cha1 + 1));
    }

    public static void main(String[] args) {
        System.out.println(getEvenNum(1, 10));
        System.out.println(getRandomChar('a', 'b'));
        Random r = new Random();
        System.out.println(r.nextInt());
    }
}
