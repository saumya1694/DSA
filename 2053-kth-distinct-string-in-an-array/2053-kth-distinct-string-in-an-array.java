class Solution {

    public String kthDistinct(String[] arr, int k) {
        Set<String> distinctStrings = new HashSet<>();
        Set<String> duplicateStrings = new HashSet<>();
        for (String str : arr) { 
            if (duplicateStrings.contains(str)) {
                continue;
            }
            if (distinctStrings.contains(str)) {
                distinctStrings.remove(str);
                duplicateStrings.add(str);
            } else {
                distinctStrings.add(str);
            }
        }
        for (String str : arr) {
            if (!duplicateStrings.contains(str)) {
                k--;
            }
            if (k == 0) {
                return str;
            }
        }
        return "";
    }
}