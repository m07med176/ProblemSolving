#include "../../problems.h"


std::vector<int> smallerNumbersThanCurrent(std::vector<int>& nums){
    std::vector<int> newArray(nums.size());

    for (size_t i = 0; i < nums.size(); ++i) {
        int counter = 0;
        int item = nums[i];

        for (int num : nums) {
            if (num < item) {
                counter++;
            }
        }

        newArray[i] = counter;
    }

    return newArray;
}


/*

extern "C"
JNIEXPORT jintArray JNICALL
Java_mohamed_arfa_problemsolving_easy_solved_SmallerNumbersThanCurrent_SmallerNumbersThanCurrentCpp_smallerNumbersThanCurrent(
        JNIEnv *env, jobject thiz, jintArray nums) {
    std::vector<int> input = JniArrayUtils::jintArrayToVector(env, nums);

    std::vector<int> output = smallerNumbersThanCurrent(input);

    return JniArrayUtils::vectorToJIntArray(env, output);
}
*/
