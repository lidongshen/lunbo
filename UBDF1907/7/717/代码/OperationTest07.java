public class OperationTest07{
	public static void main(String[] args){
		
		//����������ȼ���
		//С���� > �������Լ� > �������� > �Ƚ����� > �߼����� > ��ֵ����
		long a = 10L;
		long b = 20L;
		long c = 30L;
		//System.out.println(a + b > c);  // false
		//
		//System.out.println(a + b++ > c);// false
		//System.out.println(--a + b == c & true); //true
		//System.out.println(!(a + b > c | a - b < c)); //false
		
		//�߼������ : 
		// ��·�룺 &&  �ص㣺����һ��������Ϊfalseʱ�����жϵڶ���������
		//                     �����һ��������Ϊtrueʱ�������жϵڶ�����������
		// �ڿ��������У�һ�����ö�·�룬Ч�ʸߣ�
		System.out.println(a + b++ > c && true); // false
		System.out.println(false && false); // false
		
		//��·��||   �ص㣺����һ��������Ϊtrueʱ�����жϵڶ���������
		//                   �����һ��������Ϊfalseʱ�������жϵڶ�����������
		System.out.println(false || false); // false
		System.out.println(true || false); // true
		
		boolean flag1 = false;
		int i = 10;
		if(flag1 & (i++ > 0)){
			System.out.println("��");
		}else{
			System.out.println("��");
		}
		
		boolean flag2 = false;
		int i1 = 10;
		if(flag1 && (i++ > 0)){
			System.out.println("��");
		}else{
			System.out.println("��");
		}
		
		
		
		
		
		
	}
}













