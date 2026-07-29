package OopPackage;



abstract class Parent2{
    public Parent2(){
        System.out.println("Mai base2 ka constructor hoon");
    }
    public void sayHello(){
        System.out.println("Hello");
    }
    abstract public void greet();
    abstract public void greet2();
}


//here we are not writting abstract keyword before the child2 class because its 
//implementing each ans every abstract class of its parent class(parent2)
class Child2 extends Parent2{
    @Override
    public void greet(){
        System.out.println("Good morning");
    }
    @Override
    public void greet2(){
        System.out.println("Good afternoon");
    }
}


//here we are  writting abstract keyword before the child2 class because its not
//implementing each ans every abstract class of its parent class(parent2)
abstract class Child3 extends Parent2{
    public void th(){
        System.out.println("I am good");
    }
}
public class L53_abstract_class  {
    public static void main(String[] args) {
        //Parent2 p = new Parent2(); -- error because parent2 is an abstract class
        Child2 c = new Child2();
        //Child3 c3 = new Child3(); -- error because child3 is abstract class
    }
}
