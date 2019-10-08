public class B{
	public static void main(String[] args){
		int i=1234;
		int j=i%10*1000+(i/10)%10*100+(i/100)%10*10+(i/1000);
			System.out.println(j);
		}
}