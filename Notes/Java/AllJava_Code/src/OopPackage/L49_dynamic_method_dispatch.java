package OopPackage;
class Animal1 {

    void sound() {
        System.out.println("Animal makes sound");
    }

    void eat() {
        System.out.println("Animal eats food");
    }
}

class Dog1 extends Animal1 {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }

    void run() {
        System.out.println("Dog runs");
    }
}

public class L49_dynamic_method_dispatch {

    public static void main(String[] args) {

        Animal1 a = new Dog1();//new Dog1() → creates a Dog1 object in memory. Animal1 a → creates a reference variable of type Animal1.
                                     // The Dog1 object is stored in an Animal1 reference.

        a.sound();

        a.eat();
         //d.run();//error
        Dog1 d = (Dog1)a;

        d.run();
    }
}


/*

//Animal1 a = new Dog1();

//Compile Time:
//Reference type (Animal1) is checked.
//Method must exist in Animal1, otherwise compile-time error.

//Runtime:
//Actual object type (Dog1) is checked.
//If Dog1 overrides the method, Dog1's version runs.

//Example 1: Overridden method
//a.sound();    // Allowed (exists in Animal1)
           // Executes Dog1.sound()

//Example 2: Inherited method
a.eat();      // Allowed (exists in Animal1)
           // Dog1 doesn't override it
           // Executes Animal1.eat()

//Example 3: Method not in Animal1
a.run();      // Compile-time Error
           // Animal1 has no run() method


Rule:
1. Reference Type (Animal1) -> decides whether method call is allowed.
2. Actual Object Type (Dog1) -> decides which implementation executes.

Animal1 a = new Dog1();
*/  
