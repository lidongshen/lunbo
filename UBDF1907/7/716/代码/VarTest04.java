public class VarTest04{
	public static void main(String[] args){
		
		//�������ͣ�
		// ʮ���Ʊ�ʾ��ʽ����ѧ��������
		// 5.12  5.12f
		// 5.12e2  5.12E2  e:С������ǰ�Ƽ�λ��E��С���������Ƽ�λ��
		//1)float : ռ��4���ֽڣ������ȣ�����С������7λ��
		//2)double : ռ��8���ֽڣ�˫���ȣ�15λ��
		// ���ڸ������ͣ�Ĭ�ϱ�ʾ��double���ͣ�
		//float f1 = 3.14; //3.14 --> double���ͣ�
		//�����ʾfloat������ֵʱ����ֵ�����Ҫ�ӡ�F������f��
		float f2 = 3.14F; 
		double d1 = 3.1415; 
		
		float f3 = 3.123456789F;
		System.out.println("f3 :" + f3);
		double d2 = 3.123456789123456789;
		System.out.println("d2 :" + d2);
		
	}
}