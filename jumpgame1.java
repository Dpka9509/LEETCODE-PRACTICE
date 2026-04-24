public class jumpgame1 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4}; // test case

        int reachable = 0;
        boolean canReach = true;

        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                canReach = false;
                break;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }

        System.out.println(canReach);
    }
}
