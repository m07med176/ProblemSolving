package mohamed.arfa.problemsolving.problemSolving;

import androidx.annotation.NonNull;

public class JavaProblemSolving {

    public static int lengthOfLastWordA1(String s) {
        String[] splitS = s.trim()
                .split(" ");
        return splitS[splitS.length - 1]
                .trim()
                .length();
    }

    public static int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            for (int k = 0; k < height.length; k++) {
                if (i == k) {
                    continue;
                }
                int h = height[i];
                if (height[k] == h) {
                    int value = h * k;
                    if (value > result) {
                        result = value;
                    }
                }
            }

        }
        return result;
    }

    public static boolean isAnagramAl1(@NonNull String s, @NonNull String t) {
        boolean result = false;
        for (int i = 0; i < s.length(); i++) {
            char characterOfs = s.charAt(i);
            boolean isContain = false;
            for (int k = 0; k < t.length(); k++) {
                char characterOft = t.charAt(k);
                if (characterOft == characterOfs) {
                    isContain = true;
                    break;
                }
            }
            result = isContain;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
