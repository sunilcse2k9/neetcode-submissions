class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        ArrayList[] count = new ArrayList[nums.length];

        for (int i=0; i<count.length; i++) {
            count[i] = new ArrayList<>();
        }

        for (Integer num : map.keySet()) {
            count[map.get(num)-1].add(num);
        }

        int[] result = new int[k];
        int i=0;
        int c=0;

        while (i < k) {
            ArrayList<Integer> list = count[nums.length-c-1];

            for (int j=0; j< list.size(); j++) {
                result[i] = list.get(j);
                i++;
            }
            c++;
        }

        return result;
    }
}
