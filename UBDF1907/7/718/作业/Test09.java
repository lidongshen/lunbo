package homework;
public class Test09 {
	public static void main(String[] args) {
		int j=2,i;
		for( i=101;i<=150;i++) {
		for( j=2;j<i;j++) {
			if(i%j==0)
				break;
			}
		if(i==j)
		System.out.println(i);
		}
	}
}
