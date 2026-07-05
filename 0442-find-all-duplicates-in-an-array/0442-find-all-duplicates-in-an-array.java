class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,Integer>entry : map.entrySet()){
            if(entry.getValue() > 1){
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}