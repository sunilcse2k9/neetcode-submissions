class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i=0; i<strs.length; i++) {
            String str = strs[i];
            Integer[] key = count(str);
            String keyStr = Arrays.toString(key);
            ArrayList<String> value = map.getOrDefault(keyStr, new ArrayList<>());
            value.add(str);
            map.put(keyStr, value);
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }

    private Integer[] count(String str) {
        Integer[] count = new Integer[26];
        Arrays.fill(count, 0);

        for (int i=0; i<str.length(); i++) {
            int index = str.charAt(i) - 'a';
            count[index]++;
        }
        return count;
    }
}
