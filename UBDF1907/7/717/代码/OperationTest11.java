import java.util.Scanner;
public class OperationTest11{
	public static void main(String[] args){
		
		/*if(true){
			//�������������������У�
			System.out.println("����");	
	    }*/
		
		//����1��
		int score = 92;
		if(score > 90){
			System.out.println("��Ʒ");
		}
		
		//����2��
		int a = 10;
		int b = 20;
		if(a + b >= 50){
			System.out.println(50);
		}
		
		//����3��
		Scanner scann = new Scanner(System.in);
		System.out.println("����1��");
		double d1 = scann.nextDouble();
		System.out.println("����2��");
		double d2 = scann.nextDouble();
		//�߼����룺
		/*if(d1 > 10.0 & d2 < 20.0){
			System.out.println(d1 + d2);
		}*/
		/*if(d1 > 10.0 && d2 < 20.0){
			System.out.println(d1 + d2);
		}*/
		//Ƕ�׽ṹ��
		if(d1 > 10.0){
			if(d2 < 20.0){
				System.out.println(d1 + d2);
			}
		}
		
		
		
		
		
		//����4�� �ܱ�3������15 % 3 == 0
		short s1 = 100;
		short s2 = 30;
		if((s1+s2) % 3 == 0 && (s1+s2) % 5 == 0){
			System.out.println("��5��3������");
		}
		
		//����5��С�Ĳ�
		// static : �෽�� ����ʹ������ֱ�ӵ��õķ���
		double d = Math.random(); // d [0.0 - 1.0) 0.9999.... 
		//[0.0 - 6.0) �����
		double d3 = Math.random() * 6; 
		double d4 = Math.random() * 6; 
		double d5 = Math.random() * 6; 
		//ת��int���ͣ� 
		int num  = (int)(d3 + d4 + d5); // [0.0 - 17.9999999999...]
		System.out.println(num);
		//ҵ���߼�:
		if(num > 15){
			System.out.println("����");
		}
		if(num > 10 && num <= 15){
			System.out.println("һ��");
		}
		if(num <= 10){
			System.out.println("�ܲ");
		}
	}
}






