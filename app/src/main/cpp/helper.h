#ifndef JNI_ARRAY_UTILS_H
#define JNI_ARRAY_UTILS_H

#include <jni.h>
#include <vector>

namespace JniArrayUtils {

// ====================== Java → std::vector ======================

// jintArray → std::vector<jint>
    inline std::vector<jint> jintArrayToVector(JNIEnv* env, jintArray arr) {
        jsize length = env->GetArrayLength(arr);
        jint* elements = env->GetIntArrayElements(arr, nullptr);
        std::vector<jint> vec(elements, elements + length);
        env->ReleaseIntArrayElements(arr, elements, JNI_ABORT);
        return vec;
    }

// jlongArray → std::vector<jlong>
    inline std::vector<jlong> jlongArrayToVector(JNIEnv* env, jlongArray arr) {
        jsize length = env->GetArrayLength(arr);
        jlong* elements = env->GetLongArrayElements(arr, nullptr);
        std::vector<jlong> vec(elements, elements + length);
        env->ReleaseLongArrayElements(arr, elements, JNI_ABORT);
        return vec;
    }

// jfloatArray → std::vector<jfloat>
    inline std::vector<jfloat> jfloatArrayToVector(JNIEnv* env, jfloatArray arr) {
        jsize length = env->GetArrayLength(arr);
        jfloat* elements = env->GetFloatArrayElements(arr, nullptr);
        std::vector<jfloat> vec(elements, elements + length);
        env->ReleaseFloatArrayElements(arr, elements, JNI_ABORT);
        return vec;
    }

// jdoubleArray → std::vector<jdouble>
    inline std::vector<jdouble> jdoubleArrayToVector(JNIEnv* env, jdoubleArray arr) {
        jsize length = env->GetArrayLength(arr);
        jdouble* elements = env->GetDoubleArrayElements(arr, nullptr);
        std::vector<jdouble> vec(elements, elements + length);
        env->ReleaseDoubleArrayElements(arr, elements, JNI_ABORT);
        return vec;
    }

// ====================== std::vector → Java ======================

// std::vector<jint> → jintArray
    inline jintArray vectorToJIntArray(JNIEnv* env, const std::vector<jint>& vec) {
        jintArray arr = env->NewIntArray(vec.size());
        env->SetIntArrayRegion(arr, 0, vec.size(), vec.data());
        return arr;
    }

// std::vector<jlong> → jlongArray
    inline jlongArray vectorToJLongArray(JNIEnv* env, const std::vector<jlong>& vec) {
        jlongArray arr = env->NewLongArray(vec.size());
        env->SetLongArrayRegion(arr, 0, vec.size(), vec.data());
        return arr;
    }

// std::vector<jfloat> → jfloatArray
    inline jfloatArray vectorToJFloatArray(JNIEnv* env, const std::vector<jfloat>& vec) {
        jfloatArray arr = env->NewFloatArray(vec.size());
        env->SetFloatArrayRegion(arr, 0, vec.size(), vec.data());
        return arr;
    }

// std::vector<jdouble> → jdoubleArray
    inline jdoubleArray vectorToJDoubleArray(JNIEnv* env, const std::vector<jdouble>& vec) {
        jdoubleArray arr = env->NewDoubleArray(vec.size());
        env->SetDoubleArrayRegion(arr, 0, vec.size(), vec.data());
        return arr;
    }

} // namespace JniArrayUtils

#endif // JNI_ARRAY_UTILS_H
