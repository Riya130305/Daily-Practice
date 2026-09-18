class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        long sum = 0;
        long max = 0;

        int i = 0, j = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        while (j < nums.length) {

            // 1. Add incoming element
            sum += nums[j];
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // 2. If window exceeds k, remove from left
            if (j - i + 1 > k) {

                sum -= nums[i];

                map.put(nums[i], map.get(nums[i]) - 1);

                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }

            // 3. Window is exactly k
            if (j - i + 1 == k) {

                // only valid if all elements are distinct
                if (map.size() == k) {
                    max = Math.max(max, sum);
                }
            }

            j++;
        }

        return max;
    }
}