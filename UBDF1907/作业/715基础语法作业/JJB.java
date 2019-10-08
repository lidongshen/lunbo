public class JJB{
	public static void main(String[]args){
		for(int i=1;i<=4;i++){
			for(int j=1;j<=i;j++){
				int a = i*j;
				System.out.print(j + "*" + i + "=" + a + "\t" );
			}
			System.out.println();
		}
	}
}