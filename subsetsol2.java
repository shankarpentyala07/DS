package project1;
import java.util.*;
public class subsetsol2 {
	
	 public static List<List<Integer>> subsets(int[] nums) {
		 
		 // Cascading Approach
	        
	        List<List<Integer>> list = new ArrayList<>();
	        list.add(new ArrayList<>());
	        int s ;
	        for(int num:nums)
	        {
	            s = list.size();
	            for(int i=0;i<s;i++)
	            {
	                List<Integer> tmp = new ArrayList<>(list.get(i));
	                tmp.add(num);
	                list.add(tmp);
	            }
	        }
	return list;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []nums = {1,2,3};
		System.out.print(subsets(nums));

	}

}
