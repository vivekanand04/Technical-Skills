package OopPackage;



class MyMainEmployee{
    private int id;
    private String name;

    public MyMainEmployee(){
        id = 0;
        name = "Your-Name-Here";
    }
    public MyMainEmployee(String myName, int myId){
        id = myId;
        name = myName;
    }
    public MyMainEmployee(String myName){
        id = 1;
        name = myName;
    }
    public String getName(){
        return name;
    }
    public void setName(String n){
        this.name = n;
    }
    public void setId(int i){
        this.id = i;
    }
    public int getId(){
        return id;
    }
}

public class Lec42_Constructors {
    public static void main(String[] args) {
    	 MyMainEmployee harry = new MyMainEmployee();
        //MyMainEmployee harry = new MyMainEmployee("ProgrammingWithHarry", 12);
       
    	   //harry.setName("CodeWithHarry");
         //harry.setId(34);
        System.out.println(harry.getId());
        System.out.println(harry.getName());
    }
}
