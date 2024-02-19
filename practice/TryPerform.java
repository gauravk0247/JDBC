package practice;

public class TryPerform {
	public static void main(String[] args) {
	int[] arr = {100,180,260,310,40,535,695};
	int largest = arr[0];
	int smallest = arr[0];
	
	for(int i=0;i<arr.length;i++) {
		if(arr[i]>largest) {
			largest = arr[i];
		}
		else if(arr[i]<smallest)
		{
			smallest = arr[i];
		}
	}
	System.out.println(largest);
	System.out.println(smallest);
	System.out.println((largest-smallest));
}
}