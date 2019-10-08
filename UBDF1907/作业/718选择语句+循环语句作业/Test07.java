package homework;
public class Test07 {
	public static void main(String[] args) {
		int i=1,count=0;
		while(i<=1000) {
			if(i%5==0) {
				System.out.print(i+"\t");
				count++;
				if(count%3==0)
					System.out.print("\n");
			}
			i++;
		}		
	}
}
