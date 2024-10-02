import java.util.*;
import java.awt.*;

public class HashmapsTest {
    public static void main(String[] args) {
        Set<Point> pointSet = new HashSet<>();

        Point p1 = new Point(3, 5);

        pointSet.add(p1);

        System.out.println(pointSet.contains(p1)); // true

        Point p2 = new Point(3, 5);
        System.out.println(pointSet.contains(p2)); // true

        p1.translate(2, 1);

        System.out.println(pointSet.contains(new Point(5, 6))); // false ... (5,6) is diff hash from (3, 5)

        System.out.println(pointSet.contains(p2)); // false ... although (3,5) has exists, the value no longer matches
                                                   // (i.e., (3,5) is not (5,6))

        System.out.println(pointSet.contains(new Point(3, 5))); // same as above

        System.out.println(pointSet.contains(p1)); // false ... (5,6) is diff hash from (3, 5)

        // HashTable v HashMap

        // Also, "subtype polymorphism" doesn't work when trying to mention the type for
        // Maps
        Map<String, Integer> ht = new Hashtable<>();

        Map<String, Integer> hm = new HashMap<>();

        // ht.put(null, null); doesn't work

        // ht.put("Hi", null); // doesn't work

        hm.put(null, null); // works

        hm.put("Hi", null); // works

        hm.put("Hi", 1);

        ht.put("Hi", 1);

        System.out.println();

        // Everything else (besides adding null values), behavior is
        System.out.println(hm.get("Hi"));
        System.out.println(hm.get("Hello"));

        System.out.println(ht.get("Hi"));
        System.out.println(ht.get("Hello"));
    }
}
