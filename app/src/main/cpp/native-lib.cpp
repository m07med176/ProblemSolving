#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_mohamed_arfa_problemsolving_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jboolean JNICALL
Java_mohamed_arfa_problemsolving_problemSolving_CppProblemSolving_isAnagramAl1(JNIEnv *env,
                                                                               jobject thiz,
                                                                               jstring s,
                                                                               jstring t) {
//    // Convert jstring to std::string
//    const char *s_chars = env->GetStringUTFChars(s, nullptr);
//    const char *t_chars = env->GetStringUTFChars(t, nullptr);
//
//    std::string str_s(s_chars);
//    std::string str_t(t_chars);
//
//    // Release the jstring after use
//    env->ReleaseStringUTFChars(s, s_chars);
//    env->ReleaseStringUTFChars(t, t_chars);
//
//    // Logic for checking if anagram-like
//    bool result = false;
//    for (size_t i = 0; i < str_s.length(); ++i) {
//        char characterOfs = str_s[i];
//        bool isContain = false;
//        for (size_t k = 0; k < str_t.length(); ++k) {
//            char characterOft = str_t[k];
//            if (characterOft == characterOfs) {
//                isContain = true;
//                break;
//            }
//        }
//        result = isContain;
//    }
//
//    // Return result as JNI jboolean
//    return result ? JNI_TRUE : JNI_FALSE;
    return JNI_TRUE;
}
extern "C"
JNIEXPORT jstring JNICALL
Java_mohamed_arfa_problemsolving_problemSolving_CppProblemSolving_getName(JNIEnv *env,
                                                                          jobject thiz) {
    return env->NewStringUTF("this is test");
}