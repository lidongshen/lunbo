public class VarTest05{
	public static void main(String[] args){
		
		//char : �ַ���
		// �ַ��ͣ���ʾ����Unicode���뼯��ĳһ���ַ���
		//���뼯�� 
		//1)ASCII���뼯 : 
		//     �����Ƴ���ֻ������Ӣ�Ĵ�Сд��ĸ���ͷ��ţ�         
		//2)Unicode���뼯��
		//     ������ȫ�����й��ҵ����Ե��ַ����ñ��뼯�洢�ַ�ʱ
        //  �����ǹ̶��ģ�1��Ӣ����ĸռ2���ֽڣ�1������ռ2���ֽڣ�	
		//  Unicode���뼯�а�����ASCII���뼯��
		//  unicode���뼯������16���Ƶķ�ʽ����ʾÿһ���ַ���
		//  unicode�������ַ���65536��������ǰ128������ASCII�������ַ���
		//3��UTF-8���뼯 ����Unicode���뼯֮�ϣ����и��Ż���
        //  �ɱ䳤�ȣ�1��Ӣ����ĸռ1���ֽڣ�1������ռ3���ֽڣ�
		
		//����char���ͱ�����
		char c1 = '��';
		System.out.println(c1); //
		
		//ת���ַ���\n : ����
		char c2 = '\n'; 
		System.out.println(c2);
		// \t : �Ʊ��������4���ո�
		System.out.print("������\tɽ����");
		
		System.out.print("������\"ɽ����\"");
		
		//ֱ����Unicode��ֵ��16���ƣ�����ʾchar���ͣ�
		char c3 = '\u0012';
		System.out.print("c3:" + c3);
		
		char c4 = 'b'; // unicode���뼯���ַ� b
		System.out.print(c4); // b
		//��ȡb��Unicode���뼯�е�λ�ã�
		System.out.println((int)c4); // 
		
		//��ֵ�ͺ�char���ͽ������㣺
		// char����ֵ�ڴ洢ʱ���ȴ�Unicode
		//�������ҵ���Ӧ��ʮ��������Ȼ����
		//ת�ɶ����ƴ洢��
		char c5 = '2' + '5'; // 50 + 53 = 103
		System.out.println(c5); // 103 g
		//����ת��������������У���2��ת��int����
		//          ����ʮ�������㣬������Ľ�����ֱ�
		//          ת����char���ͣ��������ձ�ʾ
		//          ����char�����е��ַ�4��
		
		char c6 = 2 + '2';
		System.out.println(c6);   // 4
		System.out.println((int)c6); // 52
		
		char c7 = '3';
		String s = "abc" + c7;
		System.out.println("s:" + s);
		int i=1;   
        int j;
        j=i++; 
		System.out.println(i + j);
	}
	
	
	
	
	
	
	
}