import java.util.Scanner;

/*Code : Has Path
Send Feedback
Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), check if there exists any path between them or not. Print true if the path exists and false otherwise.
Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex 'a' and 'b'.
The following line contain two integers, that denote the value of v1 and v2.
Output Format :
The first and only line of output contains true, if there is a path between v1 and v2 and false otherwise.
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
true
Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :
false*/
public class hasPath {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

        int[][] edges = new int[V][V];
		
		for( int i = 0; i < E; i++ ) {
			int fv = s.nextInt();
			int sv = s.nextInt();
			
			edges[fv][sv] = 1;
			edges[sv][fv] = 1;
		}
        
        int v1 = s.nextInt();
		int v2 = s.nextInt();
		boolean[] visited = new boolean[V] ;       
        System.out.println(hasPath(edges , visited , v1 , v2  ) ) ;             
	
	}
	 public static boolean hasPath(  int[][] edges , boolean[] visited ,int start , int end )
	    {       
		 	//Checking for direct path
	        if(edges[start][end]== 1){
	            return true ;
	        }
	        visited[start] = true ;
	        for( int i = 0 ; i < edges.length ; i++)
	        {
	            if(edges[start][i] == 1 && !visited[i] )
	            {
	            boolean small = hasPath(edges , visited , i ,end)  ;
	                if( small == true ) 
	                    return true ;                
	            }            
	        }        
	        return false ;        
	    }
}
