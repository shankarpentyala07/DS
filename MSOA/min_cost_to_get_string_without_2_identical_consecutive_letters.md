a
![image_1586171699](https://user-images.githubusercontent.com/25217700/109448668-18d8f500-7a0c-11eb-9f4e-f9544bb9e0c5.png)


Solution:
public int minCostToDeleteIdenticalConsecutiveLetters(String str, int[] cost){
 int res = 0, s_len = str.length();
    int sum = nums[0], max_value = nums[0];
    char[] s = str.toCharArray();
    for (int i = 1; i < s_len; ++i) {
        if (s[i] != s[i - 1]) {
            res += sum - max_value;
            sum = nums[i];
            max_value = nums[i];
        }
        else {
            sum += nums[i];
            max_value = Math.max(max_value, nums[i]);
        }
    }
    res += sum - max_value;
    return res;
}
