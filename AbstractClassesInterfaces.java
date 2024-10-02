interface Life {
    void breath();

    int id = 1;

    static void cells() {
        System.out.println("I have cells, the building blocks of life");
    }

    default void processNutrients() {
        System.out.println("Life");
    };
}

interface Animal {
    void breath();

    int dichotomous_level = 6;

    static void cells() {
        System.out.println("I have cells, the building blocks of life");
    }

    default void processNutrients() {
        System.out.println("I use my cells");
    };
}

// Causes issues if I uncomment Integer breath(); why?
interface Mammal {

    int dichotomous_level = 3;

    // Integer breath();
}

abstract class Animal2 {
    abstract void breath();

    int dichotomous_level = 7;

    int id = 1;

    static void cells() {
        System.out.println("I have cells, the building blocks of life");
    }

    public void processNutrients() {
        System.out.println("I use my cells");
    };
}

// implementing conflicting default interface methods is NOT allowed UNLESS
// there is already a method that overrides the default methods in execution

// Think: what is the output here, though? (hint: subclasses automatically
// inherit, and thus, implement, superclass methods)
class Person extends Animal2 implements Life, Mammal, Animal {

    int id = 2;

    public void breath() {
        System.out.println("I breathe through my mouth");
    }

}

interface O {

}

interface P {

}

interface A extends O, P {
    public void eat();
}

interface B {
    // public Integer eat();
}

class C implements A, B {

    // Get into compile-time error when we have conflicting interface methods ..
    // a way to solve this is by making the return type subclass-superclass of each
    // other
    public void eat() {
        System.out.println("Eating");
    }

    public void move() {
        System.out.println("Moving");
    }

}

public class AbstractClassesInterfaces {
    public static void main(String[] args) {

        // As shown in the commented code below, you can actually supply methods to
        // construct an abstract class

        // Life l = new Person() {
        // public void breath() {
        // System.out.println("Breathing");
        // }

        // public void cells() {
        // System.out.println("Has a lot of cells");
        // }
        // };

        Life l = new Person();

        C a = new C();

        a.eat();

        Life.cells();

        l.processNutrients();

        System.out.println(Life.id);

        foo(l);

        l.processNutrients();

        Person p = new Person();
        p.breath();

        System.out.println();
        p.processNutrients();

        // foo(a);

    }

    static void foo(Object l) {
        System.out.println("In foo");
    }

    // static void foo(A o) {

    // }

    static void foo(B o) {

    }

    static void foo(O o) {

    }

    static void foo(P o) {

    }
}
