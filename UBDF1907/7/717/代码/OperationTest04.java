public class OperationTest04{
	public static void main(String[] args){
		 //�����������
		 short a = 100;
		 short b = 200;
		 // a = a + b;
		 System.out.println(a += b); //a = 300
		 //a 100 = 300 - 200;
		 System.out.println(a -= b); //-100
		 //20000 = 100 * 200;
		 System.out.println(a *= b); // 20000
		 //100 = 20000 / 200;  ע�⣺����int���͵Ĳ��������㣬�������int
		 System.out.println(a /= b); // 100
		 
		 int d = 10;
		 //����������У����Զ�������������������С-->������
		 //d = (int)(d * 0.1); 
		 //System.out.println(d);// 1.0
		 //�ڸ���������У����Զ���������ת��
		 d *= 0.1; //d = (int)(d * 0.1); 
		 System.out.println(d); // 1.0
		 
		 long l1 = 100L;
		 l1 += 0.1; // l1 = (long)(l1 + 0.1);
		 System.out.println(l1); //100
		 
	}
}