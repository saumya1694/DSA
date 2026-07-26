class Solution {
    public int maximumProduct(int[] nums) {
                Arrays.sort(nums);
        int r=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int l=nums[0]*nums[1]*nums[nums.length-1];
        if(r>l || -(r)>l){
            return r;
        }
        return l;

    }
}