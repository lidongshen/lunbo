public class OperationTest02{
	public static void main(String[] args){
		//��ֵ�����:
		//1) =  : �Ⱥ��ڸ�ֵʱ����������ģ�
		int a = 10;
		int b = 20;
		int c = 30;
		a = b = c; //��ֵ�Ľ���ԣ�
		System.out.println(a+","+b+","+c);
		
		//���󣺽����������е����˿��ƣ�
		byte left = 13;
		byte right = 1;
		byte temp = 0;
		//������
		temp = left;
		left = right;
		right = temp;
		System.out.println(left+","+right);
	}
}



