package mohamed.arfa.problemsolving.easy.solved.ConcatenationOfArray;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Contract;

public class ConcatenationOfArrayJava {
    @NonNull
    @Contract(pure = true)
    public static int[] getConcatenationJavaV1(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            ans[nums.length + i] = nums[i];
        }
        return ans;
    }
}
