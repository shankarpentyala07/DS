https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/211/

https://leetcode.com/problems/trapping-rain-water/solution/

Solution1:
From that particular index,find the lefmax,find the rightmax and min of them subtracted from the current index is the water trapped there:
```
class Solution {
    public int trap(int[] height) {
    
        int len = height.length;
        int leftmax,rightmax,total=0;
        for(int i=0;i<len-1;i++)
        {
            leftmax = height[i];
            for(int j=i-1;j>=0;j--)
                leftmax = Math.max(leftmax,height[j]);
            rightmax = height[i];
               for(int j=i+1;j<len;j++)
                   rightmax = Math.max(rightmax,height[j]);
            total += Math.min(leftmax,rightmax) - height[i];
            
        }
        return total;
        
    }
}
```

solution2: Dynamic programming(Calculate leftmax andd rightmax arrays) 
Time: O(n) Space: O(n)
```
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int len = height.length;
        int[] leftmax = new int[len];
        int[] rightmax = new int[len];
        leftmax[0]=height[0];
        rightmax[len-1]=height[len-1];
        int total=0;
        
        for(int i=1;i<len;i++)
            leftmax[i] = Math.max(height[i],leftmax[i-1]);
        
        for(int i=len-2;i>=0;i--)
            rightmax[i] = Math.max(rightmax[i+1],height[i]);
            
        for(int i=1;i<len-1;i++)
        {
            total += (Math.min(leftmax[i],rightmax[i]) - height[i]);
            
        }
        return total;
        
    }
}
```
Solution3: Two pointer Approach:
```
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
       int left = 0,right = height.length-1,total=0;
        int leftmax=0,rightmax=0;
        while(left < right)
        {
            if(height[left] < height[right]){
               if (height[left] >= leftmax) 
                    leftmax = height[left] ;
                else
                     total += (leftmax-height[left]);
                left++;
            }
            else
            {
                if (height[right] >= rightmax) 
                    rightmax = height[right] ;
                else 
                    total += (rightmax-height[right]);
                right--;
            }
        }
        return total;
    }
}
```
Why it works?
a little bit explanation about the 4th solution: Let's assume left,right,leftMax,rightMax are in positions shown in the graph below.

![image](https://github.com/shankarpentyala07/DS/blob/master/microsoft/Screen%20Shot%202020-08-18%20at%203.58.13%20PM.png)

we can see height[left] < height[right],then for pointerleft, he knows a taller bar exists on his right side, then if leftMax is taller than him, he can contain some water for sure(in our case). So we go ans += (left_max - height[left]). But if leftMax is shorter than him, then there isn't a left side bar can help him contain water, then he will become other bars' leftMax. so execute (left_max = height[left]).
Same idea for right part.
add some comments to the code above. 
