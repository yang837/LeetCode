package exp9;

import java.text.DecimalFormat;

public class work {
    public static int getEvenNum(double num1, double num2) {
        int s = (int)num1 + (int)(Math.random() * (num2 - num1));
        if (s % 2 == 0) {
            return s;
        } else {
            return s + 1;
        }
    }

    public static double area(double r) {
        return Math.PI * Math.pow(r, 2);
    }

    public static void main(String[] args) {
        double area = area(3);
        System.out.println(new DecimalFormat("###.#####").format(area));
//        int sum = 0;
//        for (int i = 0; i < 6; i++) {
//            int num = getEvenNum(2, 32);
//            System.out.println(num);
//            sum += num;
//        }
//        System.out.println(sum);
    }
}
