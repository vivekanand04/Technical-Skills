package OopPackage;

interface SampleInterface {

    void meth1();

    void meth2();
}


// here extend so written the interface, for class we should prefer implements
interface ChildSampleInterface extends SampleInterface {

    void meth3();

    void meth4();
}


// here implements so written the class, for interface we should prefer extends
class MySampleClass implements ChildSampleInterface {

	
	//if we dont write the meth1 and meth2 we will get error
    public void meth1() {
        System.out.println("meth1");
    }

    public void meth2() {
        System.out.println("meth2");
    }

    public void meth3() {
        System.out.println("meth3");
    }

    public void meth4() {
        System.out.println("meth4");
    }
}

public class L058_inheritence_in_interface  {

    public static void main(String[] args) {

        MySampleClass obj = new MySampleClass();

        obj.meth1();
        obj.meth2();
        obj.meth3();
        obj.meth4();
    }
}