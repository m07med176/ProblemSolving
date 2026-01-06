package easy.solved.SmallerNumbersThanCurrent;

public class  SmallerNumbersThanCurrentJava {
    public static SmallerNumbersThanCurrent.Solution solution0 = nums -> {
        int[] newArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int counter = 0;
            for (int num : nums) {
                int item = nums[i];
                if (num < item) {
                    counter++;
                }
            }
            newArray[i] = counter;
        }

        return newArray;
    };
}
