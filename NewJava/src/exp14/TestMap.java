package exp14;

import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("1", "aa");
        map.put("2", "bb");

        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Collection<String> collection = map.values();
        iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
