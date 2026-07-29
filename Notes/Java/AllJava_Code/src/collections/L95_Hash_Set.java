package collections;
import java.util.*;
public class L95_Hash_Set {
public static void main(String[] args) {
	HashSet<Integer>st=new HashSet<>(22,0.5f);
	st.add(4);
	st.add(52);
	st.add(1);
	
	System.out.println(st);
	for(Integer it:st) {
		System.out.println(it);
	}
}
}
