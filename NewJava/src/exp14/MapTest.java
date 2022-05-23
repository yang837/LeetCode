package exp14;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<Long, String> map = new HashMap<>();

        UpdateStu emp1 = new UpdateStu("aa", 1);
        UpdateStu emp2 = new UpdateStu("bb", 5);
        UpdateStu emp3 = new UpdateStu("cc", 4);
        UpdateStu emp4 = new UpdateStu("dd", 2);
        UpdateStu emp5 = new UpdateStu("ee", 3);

        map.put(emp1.getId(), emp1.getName());
        map.put(emp2.getId(), emp2.getName());
        map.put(emp3.getId(), emp3.getName());
        map.put(emp4.getId(), emp4.getName());
        map.put(emp5.getId(), emp5.getName());

        Set<Long> set = map.keySet();
        Iterator<Long> iterator = set.iterator();
        while (iterator.hasNext()) {
            Long id = iterator.next();
            String name = map.get(id);
            System.out.println(id + " " + name);
        }
    }

}
