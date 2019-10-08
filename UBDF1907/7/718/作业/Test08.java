package homework;
public class Test08 {
	public static void main(String[] args) {
		int sum=0;
		for(int i=1;i<=100;i++) {
			for(int j=0;j<i;j++) {
				sum+=j;
			}
		}
		System.out.println(sum);
	}
}
