package project1;
import java.util.*;

public class subsetssol1 {
	
	//Binary Numbers Map Approach
	
public static List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        long subsets = (long) Math.pow(2,nums.length);
        
        for(int subset=0;subset<subsets;subset++)
        {
            for(int j=0;j<nums.length;j++)
            {
                if((subset & (1<<j)) > 0)  //Main Logic
                    tmp.add(nums[j]);
            }
            list.add(new ArrayList<>(tmp));
            tmp.clear();
        }
        
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {1,2,3};
		System.out.print(subsets(nums));

	}

}
