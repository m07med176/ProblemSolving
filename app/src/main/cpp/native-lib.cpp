#include <jni.h>
#include <string>
#include "connection.h"

extern "C"
JNIEXPORT jintArray JNICALL
Java_mohamed_arfa_problemsolving_easy_solved_concatenationOfArray_ConcatenationOfArrayCpp_getConcatenation(
        JNIEnv *env, jobject thiz, jintArray nums) {

    // Get input array length
    jsize length = env->GetArrayLength(nums);

    // Get elements from Java array
    jint* elements = env->GetIntArrayElements(nums, nullptr);

    // Convert to std::vector<int>
    std::vector<int> input(elements, elements + length);

    // Call normal C++ function
    std::vector<int> output = getConcatenation(input);

    // Create new Java int array
    jintArray result = env->NewIntArray(output.size());
    env->SetIntArrayRegion(result, 0, output.size(), output.data());

    // Release resources
    env->ReleaseIntArrayElements(nums, elements, JNI_ABORT);

    return result;
}