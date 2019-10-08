import java.util.Scanner;
public class TestPerson{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Plesae input your name here£º");
		String r = input.next();
		System.out.print("Plesae input your age here£º");
		int age=input.nextInt();
		System.out.print("Plesae input your gender here£º");
		String gender=input.next();
		System.out.println(" your name is :"+r);
		System.out.println(" your age is :"+age);
		System.out.println(" your gender is :"+gender);
	}
}
