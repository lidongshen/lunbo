import java.util.Scanner; 
public class OperationTest{
	public static void main(String[] args){
	    Scanner sc=new Scanner(System.in);
		/*
		System.out.print("������һ�����֣�");
		
		System.out.print("������һ�����֣�");
		int b=sc.nextInt();
		System.out.print("������һ�����֣�");
		int c=sc.nextInt();
		if(a>b&&a>c)
		System.out.println(a);
		else if(b>c)
		System.out.println(b);
		else
		System.out.println(c);
		System.out.println((a>b?a:b)>c?(a>b?a:b):c);
		*/
		//���󣺵��ɼ�����90������н�Ʒ��
		System.out.print("������ɼ���");
		double score=sc.nextDouble();
		if(score>90)
			System.out.println("�н�Ʒ");
		//��������2��int���ͱ�������ֵ���ж�����֮�ͣ�������ڵ���50����ӡ��50����
		System.out.print("������a��");
		int a=sc.nextInt();
		System.out.print("������b��");
		int b=sc.nextInt();
		if(a+b>=50)
			System.out.println("50");
		//��������2��double���ͱ�������ֵ���жϵ�һ��������10.0 �� �ҵ�2����С��20.0 ����ӡ����֮�ͣ�
		System.out.print("������c��");
		double c=sc.nextDouble();
		System.out.print("������d��");
		double d=sc.nextDouble();
		if(c>10.0&&d<20.0)
			System.out.println(c+d);
		//���󣺶��������������ж϶��ߵĺͣ��Ƿ�ȿ��Ա�3���ܱ�5����(ȡ����Ϊ0)����ӡ��ʾ��Ϣ��
		System.out.print("������e��");
		double e=sc.nextDouble();
		System.out.print("������g��");
		double g=sc.nextDouble();
		if((e+g)%3==0&&(e+g)%5==0)
			System.out.println(e+","+g);
	}
}