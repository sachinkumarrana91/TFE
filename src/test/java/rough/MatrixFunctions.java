package rough;

public class MatrixFunctions {
	
	public static void MatrixMultiplication(int a[][], int b[][]){
		int mul[][] = new int[3][3];

		for(int i=0;i<=2;i++){
			for(int j=0;j<=2;j++){
				mul[i][j] = 0;
				for(int k=0;k<=2;k++){
					mul[i][j] = mul[i][j] + (a[i][k]*b[k][j]); 
				}
				System.out.print(mul[i][j]+"     ");
			}
			System.out.println();
		}
	}
	
	public static void MatrixTranspose(int a[][]){
		int transpose[][] = new int[3][3];

		for(int i=0;i<=2;i++){
			for(int j=0;j<=2;j++){
				transpose[j][i]=a[i][j];
			}
		}
		for(int i=0;i<=2;i++){
			for(int j=0;j<=2;j++){
				System.out.print(transpose[i][j]+"     ");
			}
			System.out.println();
		}

	}
	
	

	public static void main(String... ijvcdsivdsbviudsv){
		//MatrixMultiplication(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, new int[][]{{1,2,3},{4,5,6},{7,8,9}});
		MatrixTranspose(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
		
	}
	
	

}
