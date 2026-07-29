package collections;

import java.util.*;

public class L92_LinkedList {

	public static void main(String[] args) {
	

		
		//read docs of ArrayList java oracle
		
		LinkedList<Integer>l1=new LinkedList<>();
		LinkedList<Integer>l2=new LinkedList<>();
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
//			l1.set(1,556);
			System.out.println(l1.contains(27));
			System.out.println(l1.indexOf(27));
			System.out.println(l1.lastIndexOf(27));
			for(int i=0;i<l1.size();i++) {
				System.out.println(l1.get(i));
			}

	}

}
