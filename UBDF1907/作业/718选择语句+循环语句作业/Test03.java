package homework;
import java.util.Scanner;
public class Test03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入月份：");
		int month = sc.nextInt();
		switch (month) {
		case 3:
		case 4:
		case 5:
			System.out.println("春天-春暖花开  春意盎然-植树 踏青");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("夏-夏日炎炎 夏雨雨人-游泳 吃雪糕");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("秋天-秋风瑟瑟  五谷丰登-摘苹果 吃苹果");
			break;
		default:
			System.out.println("冬天-皑皑雪山 鹅毛大雪-玩雪打雪仗");
			break;
		}
	}
}
