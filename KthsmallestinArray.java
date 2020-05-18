package project1;

public class KthsmallestinArray {
	//Modified Binary Search Solution

	public  static int findKthSmallest(int[] nums, int k) {
        long min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        int ans = 0;
        while (min <= max) {
            long mid = (max+min)/2;
            int c = count(nums, (int)mid);
            if (c < k) {
                min = mid+1;
            }else{
                ans = (int)mid;
                max = mid-1;
            }
        }
        return ans;
    }
    public static  int  count(int[] nums, int num) {
        int c = 0;
        for(int i: nums) {
            if (i <= num)
                c++;
        }
        return c;
    }
    
    public static void main(String[] args)
    {
    	int[] nums = {3,2,1,5,6,4};
    	int k = 3;
    	System.out.print(findKthSmallest(nums,k));
    }
}
