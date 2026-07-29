package OopPackage;




class Parent {
    void display() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {
    void show() {
        System.out.println("Child method");
    }
}

public class L45_Inheritence{
    public static void main(String[] args) {
        Child obj = new Child();

        obj.show();
        obj.display();
    }
}