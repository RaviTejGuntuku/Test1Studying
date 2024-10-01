
class Grandparent {

    final static public int r = 7;

    void makeMoney() {
        System.out.println("From grandparent class: " + this.getClass() + " is making money");
    }

    protected void testAction() {
        System.out.println("From grandparent class");
        makeMoney();
    }
}

class Parent extends Grandparent {

    void makeMoney() {
        System.out.println("From parent class: " + this.getClass() + " is making money");
        super.makeMoney();
    }

    protected void testAction() {
        System.out.println("From parent class");
        super.testAction();
        makeMoney();

    }
}

class Child extends Parent {

    void makeMoney() {
        System.out.println("From child class: " + this.getClass() + " is making money");
        super.makeMoney();
    }

    protected void testAction() {
        System.out.println("From child class");
        super.testAction();
        // this.makeMoney();
    }
}

class Snow {
    public void method2() {
        System.out.println("Snow 2");
    }

    public void method3() {
        System.out.println("Snow 3");
    }
}

class Sleet extends Snow {
    public void method2() {
        System.out.println("Sleet 2");
        super.method2();
        this.method3();
    }

    public void method3() {
        System.out.println("Sleet 3");
    }
}

class Rain extends Snow {
    public void method1() {
        System.out.println("Rain 1");
    }

    public void method2() {
        System.out.println("Rain 2");
    }
}

public class Polymorphism {

    static public void main(String[] args) {

        Grandparent parent = new Parent();
        Parent child = new Child();
        Grandparent grandparent = new Child();

        System.out.println(child.getClass()); // class Child (ACTUAL RUNTIME CLASS)
        System.out.println(parent.getClass()); // class Parent (ACTUAL RUNTIME CLASS)

        System.out.println(parent instanceof Grandparent); // true
        System.out.println(parent instanceof Parent); // true (looks at ACTUAL INSTANCE TYPE)
        System.out.println(parent instanceof Child); // false

        System.out.println(child instanceof Grandparent); // true
        System.out.println(child instanceof Parent); // true
        System.out.println(child instanceof Child); // true (looks at ACTUAL INSTANCE TYPE)

        System.out.println();
        System.out.println();

        // Think about "this" v. "super" keyword behavior in polymorphism ... why does
        // this happen?
        // Hint: Think about VERSIONING (later v. earlier version)
        child.testAction();
        System.out.println();
        parent.testAction();
        System.out.println();
        grandparent.testAction();
        System.out.println();

        Snow var5 = new Rain();
        ((Sleet) var5).method2();

    }

}