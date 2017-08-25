import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		char[][] arr=new char[n][n];
		int j=0;
		for(int i=0;i<n;i++) {
			for(char x:scan.next().toCharArray()){
				arr[i][j]=x;
				j++;
			}
			j=0;
		}
		scan.close();
		int num=countIceLand(arr,n);
		System.out.println(num);
	}

	private static int countIceLand(char[][] arr, int n) {
		// TODO Auto-generated method stub
		boolean visited[][]=new boolean[n][n];
		int sum=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visited[i][j])
					continue;
				if(arr[i][j]=='*')
				{
					sum++;
					visited[i][j]=true;
					visited=search(visited,arr, i, j,true);
				}
			}
		}
		return sum;
	}
	private static boolean[][] search(boolean[][] visited,char[][] arr,int i,int j,boolean isleft){
			if(isleft&&j-1>=0&&arr[i][j-1]=='*') {
				visited[i][j-1]=true;
				visited=search(visited, arr, i, j-1,true);
			}else
				isleft=false;
			if(i+1<arr.length&&arr[i+1][j]=='*') {
				visited[i+1][j]=true;
				visited=search(visited, arr, i+1, j, true);
			}
			if(i+1<arr.length&&j+1<arr.length&&arr[i+1][j+1]=='*')
			{
				visited[i+1][j+1]=true;
				visited=search(visited, arr, i+1, j+1, true);
			}
			if(i+1<arr.length&&j-1>=0&&arr[i+1][j-1]=='*')
			{
				visited[i+1][j-1]=true;
				visited=search(visited, arr, i+1, j-1, true);
			}
			if(!isleft&&j+1<arr.length&&arr[i][j+1]=='*') {
				visited[i][j+1]=true;
				visited=search(visited, arr, i, j+1,false);
			}
		return visited;
	}
	
}
