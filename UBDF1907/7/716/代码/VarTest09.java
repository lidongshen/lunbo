
//���ࣺ
import java.util.Scanner;

public class VarTest09{
	public static void main(String[] args){
		
		//���䣺+ -
		// + ����1���Ӻţ�
		int i = 2 + 3;
		// (2) �ַ���ƴ��: ������������ߣ�ֻҪ��һ�����������ַ�����
		//                 ��ô��������ַ���ƴ�ӣ�
		String str = 2 + "3";
		//(3) + ����
		System.out.println(10); //+10
		//- ������������
		System.out.println(-10);
		
		//������13�е�3��ȡ������
		System.out.println(13 % 10); // 3
		
		// 1234 : �ֱ�ȡ��ÿһλ�ϵ����֣�4 3 2 1
		System.out.println(1234 % 10); // 4 
		//int�������㣬�������int���ͣ�
		System.out.println(1234 / 10 % 10); //int����-->123 3
		System.out.println(1234 / 100 % 10); //2
		System.out.println(1234 / 1000); //1
		
		//����������Ҫ�ı�������Բ���ܳ��������
		//�ܳ���2pi * r
		//�����pi * r * r
		//���ռ������룺
		//Java�� ɨ����:scanner��
		//(1)�������
		//(2)����һ���������ݵı�����
		//��3������ȡ�������ݴ洢�ڸñ����У�
		Scanner input = new Scanner(System.in); //System.in��������
		// println : �������Ȼ���ٻ���
		// print �� ֻ�����
		System.out.print("������뾶��");
		//ʹ��scanner�ķ�����next()�������������ݣ�
		double r = input.nextDouble();
		//�ܳ���2pi
		double l=2*3.14*r;
		double s=3.14*r*r;
		System.out.println("�ܳ���"+ l +"���:" + s);
		
	
	}
}


