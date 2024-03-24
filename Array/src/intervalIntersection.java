import java.util.ArrayList;

/*986. Interval List Intersections

You are given two lists of closed intervals, firstList and secondList,
 where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. 
 Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or
represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].

Input: firstList = [[0,2],[5,10],[13,23],[24,25]], 
	   secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 */
public class intervalIntersection {
	public static void main(String[] args) {

	}
	public int[][] intervalIntersection(int[][] l1, int[][] l2) {
		ArrayList<int []> ans = new ArrayList<>();
		
		int n=l1.length, m=l2.length, i=0, j=0;
		if(n==0 || m==0) {  
			return ans.toArray(new int[ans.size()][]);
		}
		while(i<n && j<m) {
			
			int l = Math.max(l1[i][0],l2[j][0]);
			int r = Math.min(l1[i][1],l2[j][1]);
			
			if(l<=r)    
				ans.add(new int[]{l,r});
			if(l1[i][1]<l2[j][1])  
				i++;
			else   
				j++;
		}
		return ans.toArray(new int[ans.size()][]);
	}
}