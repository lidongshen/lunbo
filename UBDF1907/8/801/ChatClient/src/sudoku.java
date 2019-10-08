
import java.util.Scanner;

public class sudoku {
	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		System.out.println("�����������Ľ�����");
		
		//stairs����
		int stairs = sc.nextInt();
		int middle=stairs/2;
		int[][] sudoku1 = new int[stairs][stairs];
		int x=0;
		int y=middle;

		
		int count=0;
		for(;count<(stairs*stairs);) {
			if(x<0) {
				x=stairs-1;
			}
			if(y>stairs-1) {
				y=0;
			}
			sudoku1[x][y]=count+1;
		
			if((sudoku1[x][y])%stairs==0) {
				
				sudoku1[x++][y]=count+1;
				count++;
				continue;
			}
			x--;
			y++;
			count++;
			
			
		}	
		for(int i= 0;i<stairs;i++) {
			for(int j=0;j<stairs;j++) {
				System.out.print(sudoku1[i][j]+"\t");
			}
			System.out.println();
		}
		
	}
	
	
}
