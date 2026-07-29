package OopPackage;




class Student {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
    }
}

public class L47_This_keyword {
    public static void main(String[] args) {

        Student s1 = new Student(101, "Vivek");

        s1.display();
    }
}