import java.util.Scanner;
public class TestCircle{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in); 
		System.out.print("������뾶��");
		double r = input.nextDouble();
		double c=2*3.14*r;
		double s=3.14*r*r;
		System.out.println("��Բ�뾶Ϊ��R="+r);	
		System.out.println("��Բ�ܳ�Ϊ��C=2*3.14"+"*"+r+"="+c);
		System.out.println("��Բ���Ϊ��S=3.14"+"*"+r+"*"+r+"="+s);
	}
}