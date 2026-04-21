public class removeDuplicates2 {

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 2, 3, 3, 4};

        if (nums.length == 0) {
            System.out.println(0);
            return;
        }

        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[count] = nums[i];
                count++;
            }
        }

        System.out.println("New length: " + count);

        // Print modified array
        for (int i = 0; i < count; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}