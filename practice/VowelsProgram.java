package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class VowelsProgram{
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(10);
		a.add(20);
		a.add(30);
		Integer[] ii = a.toArray(new Integer[(a.size())]);
		for(int i=0;i<ii.length;i++) {
			System.out.println(ii[i]);
		}
	}
}