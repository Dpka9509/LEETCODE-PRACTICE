class one_rotate_array {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = rotated[i];
        }
    }
}