#include <jni.h>
#include "dmike16_javaprogramming_celestialBody.h"
#include <stdio.h>

JNIEXPORT jint JNICALL Java_dmike16_javaprogramming_celestialBody_helloBody
  (JNIEnv *env, jobject obj){
	printf("Callde from java CODE\n");
	return 0;
}
