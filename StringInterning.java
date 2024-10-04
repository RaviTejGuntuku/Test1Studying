class StringStorage {

    String s1;
    String s2;

    public StringStorage(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

}

public class StringInterning {

    static String firstPart = "hel";
    static String secondPart = "lo";

    public static void main(String[] args) {

        // Obvious cases
        String s1 = "hello";
        String s2 = "hello";

        String s3 = new String("hello");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        String s4 = "hel" + "lo";

        System.out.println(s1 == s4);

        System.out.println();

        // What do these comparisons below output?
        String n1 = "hel";
        String n2 = "lo";

        String n3 = n1 + n2;

        System.out.println(n3 == s1);

        String int1 = Integer.toString(5);
        String int2 = Integer.toString(5);
        System.out.println(int1 == int2);

        StringBuilder sb = new StringBuilder();

        sb.append("h");
        sb.append("e");
        sb.append("l");
        sb.append("l");
        sb.append("o");

        System.out.println(sb.toString() == s1);

        String newHello = firstPart + secondPart;
        System.out.println(newHello == s1);

        newHello = returnPart1() + returnPart2();
        System.out.println(newHello == s1);

        StringStorage s = new StringStorage("h", "ello");
        newHello = s.s1 + s.s2;

        System.out.println(newHello == s1);

    }

    public static String returnPart1() {
        return "hel";
    }

    public static String returnPart2() {
        return "lo";
    }
}
