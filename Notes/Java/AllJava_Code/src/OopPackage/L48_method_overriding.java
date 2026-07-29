package OopPackage;




class Animal {

    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class L48_method_overriding {

    public static void main(String[] args) {

        Dog d = new Dog();

        d.sound();
    }
}