package OopPackage;




interface Parent3 {

    void display();

    default void show() {
        message();
        System.out.println("Default method inside interface");
    }

    private void message() {
        System.out.println("Private method inside interface");
    }
}


class Child32 implements Parent3 {

    public void display() {
        System.out.println("Abstract method implemented");
    }
}

public class L57_Default_and_private_function_in_interface{
    public static void main(String[] args) {
        Child32 c = new Child32();

        c.show();
        c.display();
    }
}