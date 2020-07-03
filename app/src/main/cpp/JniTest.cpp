#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_me_opengldemo_JniTest_test(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello froddmddd C++";

    std::string d = "";
    return env->NewStringUTF(hello.c_str());
}

