package collections;
import java.util.*;
public class L91_ArrayList {
public static void main(String[] args) {
	//read docs of ArrayList java oracle
	
	ArrayList<Integer>l1=new ArrayList<>();
	ArrayList<Integer>l2=new ArrayList<>();
	l2.add(40);
	l2.add(50);	
	l2.add(40);
		l1.add(5);

		l1.add(2);

		l1.add(76);
		l1.add(0,11);
		l1.add(0,22);
		l1.addAll(l2);
		//l1.clear();
//		l1.set(1,556);
		System.out.println(l1.contains(27));
		System.out.println(l1.indexOf(27));
		System.out.println(l1.lastIndexOf(27));
		for(int i=0;i<l1.size();i++) {
			System.out.println(l1.get(i));
		}

}
}
