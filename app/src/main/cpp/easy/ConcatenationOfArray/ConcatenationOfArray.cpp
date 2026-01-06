#include "../../problems.h"


std::vector<int> getConcatenation(const std::vector<int>& nums) {
    std::vector<int> ans;
    ans.reserve(nums.size() * 2);

    for (int num : nums) {
        ans.push_back(num); // first copy
    }
    for (int num : nums) {
        ans.push_back(num); // second copy
    }

    return ans;
}

extern "C"
JNIEXPORT jintArray JNICALL
Java_mohamed_arfa_problemsolving_easy_solved_ConcatenationOfArray_ConcatenationOfArrayCpp_getConcatenation(
        JNIEnv *env, jobject thiz, jintArray nums) {

    std::vector<int> input = JniArrayUtils::jintArrayToVector(env, nums);

    std::vector<int> output = getConcatenation(input);

    return JniArrayUtils::vectorToJIntArray(env, output);
}