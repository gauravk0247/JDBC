package practice;

import java.util.Arrays;

public class Practice{
	public static void main(String[] args){
		String str = "Hii How are you";
		int count = 0;
		
		for(char ch : str.toCharArray()) {
			if(ch=='i') {
				count++;
			}
		}
		System.out.println(count);
	}
//	public static void getCountOccurance() {
//		for(int i=0;i<str.length();i++) {
//			if(str.charAt(i)== val) {
//				count++;
//			}
//			System.out.println(val + " "+ count);
//		}
//	}
}