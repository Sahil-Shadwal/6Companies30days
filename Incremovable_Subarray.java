import java.util.Arrays;

// You are given a 0-indexed array of positive integers nums.
// A subarray of nums is called incremovable if nums becomes strictly increasing on removing the subarray. For example, the subarray [3, 4] is an incremovable subarray of [5, 3, 4, 6, 7] because removing this subarray changes the array [5, 3, 4, 6, 7] to [5, 6, 7] which is strictly increasing.
// Return the total number of incremovable subarrays of nums.
// Note that an empty array is considered strictly increasing.
// A subarray is a contiguous non-empty sequence of elements within an array.

class Incremovable_Subarray {
    public int incremovableSubarrayCount(int[] nums) {
        final int n = nums.length;
        final int startIndex = getStartIndexOfSuffix(nums);
        if (startIndex == 0)
            return n * (n + 1) / 2;

        int ans = n - startIndex + 1;

        for (int i = 0; i < startIndex; ++i) {
            if (i > 0 && nums[i] <= nums[i - 1])
                break;
            ans += n - firstGreater(nums, startIndex, nums[i]) + 1;
        }

        return ans;
    }

    private int getStartIndexOfSuffix(int[] nums) {
        for (int i = nums.length - 2; i >= 0; --i)
            if (nums[i] >= nums[i + 1])
                return i + 1;
        return 0;
    }

    private int firstGreater(int[] A, int startIndex, int target) {
        final int i = Arrays.binarySearch(A, startIndex, A.length, target + 1);
        return i < 0 ? -i - 1 : i;
    }

    public static void main(String[] args) {
        Incremovable_Subarray solution = new Incremovable_Subarray();
        int[] nums1 = { 5, 3, 4, 6, 7 };
        int[] nums2 = { 1, 2, 3, 4, 5 };
        int[] nums3 = { 5, 4, 3, 2, 1 };
        int[] nums4 = { 1, 3, 2, 4, 5 };

        System.out.println(solution.incremovableSubarrayCount(nums1));
        System.out.println(solution.incremovableSubarrayCount(nums2));
        System.out.println(solution.incremovableSubarrayCount(nums3));
        System.out.println(solution.incremovableSubarrayCount(nums4));
    }
}