public class VarTest08{
	public static void main(String[] args){
		
		//�����������
		// ���ڶ�Ԫ����----> ����������
		System.out.println(2 + 3); //2 3 �ֱ��������������
		
		//���������������
		// ��Ϊ�ǻ���int�����ڼ��㣬���Խ������int���ͣ������С��λ�ضϣ�������������
		System.out.println(10 / 3); // 3
		System.out.println(10 * 3); // 30
		System.out.println(10 % 3); // 1
		//ֻҪ��һ���������Ǹ�����������Ǹ���
		System.out.println(-10 / 3); // -3 
		System.out.println(10 / -3); // -3
		//����ת����
		//���������������Σ����ȡ����
		//ֻҪ��һ��������Ϊ�����ͣ���ô���Ȼ���������Զ�ת��
		//Ȼ���ٽ��м��㣻
		System.out.println(18.06 / 2); // 9.03
		
		//���������ǰ++ �� ��++ �� ǰ-- �� ��--��
		//�����Ǻ�++ �����Ǻ�--��
		//�����������һ�֣�����������㣬ֱ���������Լ���
		//			�ڶ��֣�������������������㣬�Ȳ������㣬���������Լ���
		//������ǰ++ �� ����ǰ--��ֻ��һ����������������Լ���Ȼ���ٲ������㣻
		int i = 1;
		i++;   // �������ڣ��������� ��2
		System.out.println(1 + i); // 3
		
		int j = 1;
		int k = j++; //�ȸ�ֵ��������
		System.out.println("�������㣺"+(1 + k));
		System.out.println(j); // 2
		System.out.println("�������㣺"+(1 +(j++))); // 3
		
		int i1 = 10;
		i1--; //����
		System.out.println(i1); // 9
		System.out.println(1 + (i1--)); // 10
		System.out.println(i1); // 8
		
		int i2 = 1;
		++i2; // == i2++��
		System.out.println(i2); // 2
		System.out.println(10 + (i2++) + (++i2)); //16
		                   //      2   +    4
	}
}



