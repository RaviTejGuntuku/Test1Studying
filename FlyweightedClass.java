import java.util.*;

// Replace the Trees and MyTrees class for String, and you start to understand how String and StringPool works.
class Trees {

    // Can't
    public static final class MyTree {
        private final int x;
        private final int y;

        public MyTree(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {

            if (o.getClass() == getClass()) {
                MyTree m = (MyTree) o;
                return m.x == x && m.y == y;
            }
            return false;
        }
    }

    private static Map<String, MyTree> map = new HashMap<>();

    public static MyTree makeNewTree(int x, int y) {
        String point = x + ", " + y;

        if (!map.containsKey(point)) {
            map.put(point, new MyTree(x, y));
        }

        return map.get(point);
    }

}

// This code doesn't even use a nested class structure and still implements
// Flyweighting, much like the String class (it's a great analogy)
final class StandaloneTree {

    private int x;
    private int y;

    private static Map<String, StandaloneTree> map = new HashMap<>();

    private StandaloneTree(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static StandaloneTree makeNewTree(int x, int y) {

        String point = x + ", " + y;

        if (!map.containsKey(point)) {
            map.put(point, new StandaloneTree(x, y));
        }

        return map.get(point);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public StandaloneTree intern() {
        return makeNewTree(x, y);
    }

    @Override
    public boolean equals(Object o) {

        if (o.getClass() == getClass()) {
            StandaloneTree m = (StandaloneTree) o;
            return m.x == x && m.y == y;
        }
        return false;
    }

}

public class FlyweightedClass {
    public static void main(String[] args) {

        Trees.MyTree n = Trees.makeNewTree(1, 5);

        Trees.MyTree m = new Trees.MyTree(1, 5);

        Trees.MyTree o = Trees.makeNewTree(1, 5);

        System.out.println(n == m);
        System.out.println(n == o);
        System.out.println(m == o);

        System.out.println();

        System.out.println(n.equals(m));
        System.out.println(n.equals(o));
        System.out.println(m.equals(o));

        System.out.println(n.getClass());

    }
}
