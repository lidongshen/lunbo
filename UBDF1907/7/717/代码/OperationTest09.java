
import java.util.*;
public class OperationTest09{
	public static void main(String[] args){
		
		//��Ԫ�������
		//�﷨�����ʽ �����ʽ �����ʽ
		//�����ҳ����������нϴ��һ����
		//int a = 10;
		//int b = 20;
		/*if(a > b){
			System.out.println('��');
		}else{
			System.out.println('��');
		}*/
		
		//���a > b���ʽ��������ִ�� ���ǡ� ������ִ�С��� 
		//System.out.println(a > b ? '��' : '��'); 
		
		//���󣺼�����������int�������֣�Ȼ��ѡ������ֵ��
		Scanner input = new Scanner(System.in);
		System.out.print("��һ������");
		int a = input.nextInt();
		System.out.print("�ڶ�������");
		int b = input.nextInt();
		System.out.print("����������");
		int c = input.nextInt();
		
		//if else:
		int max; //�м�������洢ֵ��
		if(a > b){
			max = a;
		}else{
			max = b;
		}
		
		if(max > c){
			System.out.print("���ֵ��"+max);
		}else{
			System.out.print("���ֵ��"+c);
		}
		System.out.print("===================");
		//��Ԫ��
		//int max = a > b ? a : b;
		//max = max > c ? max : c;
		//System.out.print("���ֵ��"+max);
		
		//��ԪǶ�ף�
		System.out.println((a > b ? a : b) > c ? (a > b ? a : b) : c);
	}
}






