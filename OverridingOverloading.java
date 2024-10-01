class Bar {

}

class Foo extends Bar {

}

class Parent {

    protected int x = 4;

    Bar testAction(Foo o) {
        System.out.println("In Parent's testAction() method");
        return new Bar();
    }
}

class Child extends Parent {

    String x;

    Foo testAction(Foo o) {
        x = "";
        System.out.println("In Child's testAction() method");
        return new Foo();
    }
}

public class OverridingOverloading {

    public static void main(String[] args) {

        Object k = new Bar();
        Object l = new Foo();

        Bar m = new Bar();
        Bar n = new Foo();

        Foo o = new Foo();

        bar1(k);
        bar1(l);
        bar1(m);
        bar1(n);
        bar1(o);

        Parent p = new Child();
        p.testAction(new Foo());

        System.out.println(p.x);

    }

    static void bar1(Object o) {
        System.out.println("In Object's bar1");
    }

    static void bar1(Foo o) {
        System.out.println("In Foo's bar1");
    }

    static void bar1(Bar o) {
        System.out.println("In Bar's bar1");
    }

}
