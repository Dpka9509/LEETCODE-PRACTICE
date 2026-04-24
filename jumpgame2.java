public class jumpgame2 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4}; // test case

        int n = nums.length;

        if (n <= 1) {
            System.out.println(0);
            return;
        }

        int jumps = 0;
        int currEnd = 0;
        int maxReach = 0;

        for (int i = 0; i < n - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if (i == currEnd) {
                jumps++;
                currEnd = maxReach;

                if (currEnd >= n - 1) break;
            }
        }

        System.out.println(jumps);
    }
}
