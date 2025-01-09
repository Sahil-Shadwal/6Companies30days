public class CountSubarray {
    public static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[n + 1];
        count[0] = 1;
        int result = 0;
        int oddCount = 0;

        for (int num : nums) {
            oddCount += num & 1;

            if (oddCount >= k) {
                result += count[oddCount - k];
            }
            count[oddCount]++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 1, 2, 1, 1 };
        System.out.println(numberOfSubarrays(nums1, 3)); // Expected: 2

        int[] nums2 = { 2, 4, 6 };
        System.out.println(numberOfSubarrays(nums2, 1)); // Expected: 0

        int[] nums3 = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
        System.out.println(numberOfSubarrays(nums3, 2)); // Expected: 16
    }
}