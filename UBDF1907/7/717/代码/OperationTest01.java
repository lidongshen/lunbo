/*
����ʹ�ü������룬���ռ�����������ݣ�
      ��ɶ�Բ���ܳ�������ļ��㣻
	 ɨ����:Scanner;
	 ��java�У����е��඼���Բ�ͬ�İ���������֯�ģ�
	 ���õ���һЩ���ĵ��࣬��String,system�ȣ���Щ��
	 ����java.lang�������й����ð��µ����е��࣬��
	 ʹ��ʱ����Ҫ���⵼�룬�������µ���Ҫ����ʹ��ʱ������
	 �ȵ��������ʹ�����Դ�룻
*/
//��scanner��Ĵ��뵼�뵽��ǰ.java�ļ��У�
import java.util.Scanner;
//��java.util�������е���Ĵ��뵼�뵽��ǰ�ļ��У�
import java.util.*;

public class OperationTest01{
	public static void main(String[] args){
		
		/**
		* scanner���ʹ�ò��裺
		  1�������Ӧ�İ���
		  2������scanner����
		     new ���췽��();
		  3�����ռ�����������ݣ�Ȼ��ֵ��һ�������洢��
		*/
		Scanner input = new Scanner(System.in);
		System.out.print("����뾶��");
		// input.next() �� ���÷������﷨��
		double r = input.nextDouble();
		//������һ��������ֵ�󣬲��ɸı䣻
		//ʹ��final�ؼ������εı��������ǳ�����
		//������Ҫ���д��
		final double PI = 3.14; 
		//���ܳ���
		double zhouChang;
		zhouChang = 2 * PI * r;
		//�����
		double area = PI * r * r;
		System.out.println("�ܳ���" + zhouChang +",�����"+area);
	}
}






