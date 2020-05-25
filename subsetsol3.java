package project1;
import java.util.*;

public class subsetsol3 {
	
	public static List<List<Integer>> subsets(int[] nums) {
        
		Arrays.sort(nums);
		        List<List<Integer>> result = new ArrayList<>();
		        backtrack(result,new ArrayList<>(),nums,0);
		        return result;
		    }
		    
		    public static void backtrack(List<List<Integer>> result,List<Integer> tmp,int[] nums,int start)
		    {
		        result.add(new ArrayList<>(tmp));
		        for(int i=start;i<nums.length;i++)
		        {
		            tmp.add(nums[i]);
		            backtrack(result,new ArrayList<>(tmp),nums,i+1);
		            tmp.remove(tmp.size()-1);
		        }      
		    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {1,2,3};
		System.out.print(subsets(nums));

	}

}
