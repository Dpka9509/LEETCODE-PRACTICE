public class Two_Majority_element {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int result = majorityElement(nums);
        System.out.println(result);
    }

    public static int majorityElement(int[] nums) {
        int cnt = 0;
        int el = 0;

        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                cnt = 1;
                el = nums[i];
            } else if (nums[i] == el) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return el;

         //     //moore's voting algo
    //     int candidate=0;
    //     int count=0;
    //     for(int num: nums){
    //         if(count==0){
    //             candidate=num;
    //             count=1;
    //         }
    //         else if(candidate==num){
    //             count++;
    //         }else{
    //             count--;
    //         }
    //    }return candidate;


       
        //optimised approach
        // Arrays.sort(nums);
        // return nums[nums.length/2];

        //brute force
    //    for (int i = 0; i < nums.length; i++) {
    //         int val = nums[i];
    //         int freq = 0;

    //         for (int j = 0; j < nums.length; j++) {
    //             if (nums[j] == val) {
    //                 freq++;
    //             }
    //         }

    //         if (freq > nums.length / 2) {
    //             return val;
    //         }
    //     }
    //     return -1;
    }
}


   