package exp14;

import java.util.Iterator;
import java.util.TreeSet;

public class UpdateStu implements Comparable<Object> {

    String name;
    long id;

    public UpdateStu(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        UpdateStu updateStu = (UpdateStu) o;
        return id > updateStu.id ? 1 : (id == updateStu.id ? 0 : -1);
    }

    public static void main(String[] args) {
        UpdateStu stu1 = new UpdateStu("a", 10);
        UpdateStu stu2 = new UpdateStu("b", 20);
        UpdateStu stu3 = new UpdateStu("c", 30);
        UpdateStu stu4 = new UpdateStu("d", 40);

//        System.out.println(stu1.compareTo(stu2));

        TreeSet<UpdateStu> tree = new TreeSet<>();
        tree.add(stu1);
        tree.add(stu2);
        tree.add(stu3);
        tree.add(stu4);

        Iterator<UpdateStu> iterator = tree.iterator();
        while (iterator.hasNext()) {
            UpdateStu temp = iterator.next();
            System.out.println(temp.name + " " + temp.id);
        }
        System.out.println();

        iterator = tree.headSet(stu2).iterator();
        while (iterator.hasNext()) {
            UpdateStu temp = iterator.next();
            System.out.println(temp.name + " " + temp.id);
        }
        System.out.println();

        iterator = tree.subSet(stu1, stu2).iterator(); // [stu1, stu3)
        while (iterator.hasNext()) {
            UpdateStu temp = iterator.next();
            System.out.println(temp.name + " " + temp.id);
        }
    }
}
