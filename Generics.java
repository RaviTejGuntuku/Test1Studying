interface Animal {

}

class Dog implements Animal {

    public String toString() {
        return "I'm a Dog";
    }

}

class Cat implements Animal {

    public String toString() {
        return "I'm a Cat";
    }

}

// Currently, the generic type name is set to T ... consider what would happen
// if we changed that to String?

// What if we made the class after extends a name that does not exist ... would
// we run into compile-time, or run-time error? Is this on the client side, or
// the class-side?

class Printer<T extends Animal> {

    T thingToPrint;

    public Printer(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
        System.out.println(thingToPrint.getClass());
        System.out.println(thingToPrint instanceof T);
        System.out.println(thingToPrint instanceof Animal);
    }

}

public class Generics {
    public static void main(String[] args) {

        // Printer<String> p = new Printer<>("hi");

        // p.print();

        // Printer<Integer> p1 = new Printer<>(1);

        // p1.print();

        Printer<Dog> p = new Printer<>(new Dog());

        p.print();

        Printer<Cat> p1 = new Printer<>(new Cat());

        p1.print();

        hello("String");
        hello(1);

    }

    private static <T> void hello(T argument) {
        System.out.println("Hello from generic method");
    }

    private static void hello(Integer argument) {
        System.out.println("Hello from integer method");
    }

}
