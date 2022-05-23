package exp14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Gather {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("aa");
        list.add("bb");
        list.add("cc");

//        Random random = new Random();
//        int i = random.nextInt(3);
//
//        System.out.println(list.get(i));
//        list.remove(i);
        list.clear();

        list.add("aa");
        list.add("bb");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
