public class VarTest07{
	public static void main(String[] args){
		
		//�Զ�ת��������С---> ������
		int i = 10;
		long l = i;
		System.out.println("l:"+l);
		
		//ǿתת����������--->����С������Ҫǿתת��
		//�﷨:(Ҫǿת����������)ֵ
		int j = (int)l;
		int k = (int)10000L;
		System.out.println("j:" + j);
		
		//ע�⣺�������Ͳ��ܺ��������ͽ���ǿת
		boolean flag = true;
		int a = (int)flag;
		System.out.println("a:" + a);
		
		//String �� �ַ�������,���е��ַ�����ʾ�Ķ��ǳ�����
		String str = "abc";
		//String s1 = new String("abc");
		System.out.println(str);
		
		//������ֵ�ǿ��Ը��ĵģ�
		int ii = 10;
		ii = 100;
		//������ֵһ���������Ͳ������޸��ˣ�
		final int i1 = 100;
		i1 = 200; //�������޸�ֵ
		
		final PI = 3.14;
		
	}
}