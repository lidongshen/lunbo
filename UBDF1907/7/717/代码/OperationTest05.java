public class OperationTest05{
	public static void main(String[] args){
		
		//�Ƚ���������ȽϵĽ������һ������ֵ��true false
		byte b1 = 10;
		short s1 = 20;
		int i1 = 30;
		long l1 = 40L;
		float f1 = 3.0F;
		double d1 = 4.0;
		char c1 = 'A'; 
		boolean flag = false;
		
		System.out.println(b1 > s1); //false
		System.out.println(s1 > d1); // true
		System.out.println(i1 > f1); //true
		System.out.println(l1 > s1); //true
		
		System.out.println(i1 > c1); //false
		//boolean���Ͳ��ܱȽ�
		//System.out.println(d1 > flag); 
		//�﷨û�����⣬�������Ϳ��ԱȽϣ����ǲ����鸡�����ͱȽϣ�
		//��Ϊ���ܻ���ֲ�׼ȷ�������
		System.out.println(f1 > d1); // false
		
		/*if(��ϵ������ʽ){
			������䣻
		}*/
		
		int i = 30;
		int j = 30;
		//��������������ڻ��ߵ���
		System.out.println(i >= j); // true
		System.out.println(i <= j); // true
		
		System.out.println(i != j); // false
		System.out.println(i == j); // true
	}
}








