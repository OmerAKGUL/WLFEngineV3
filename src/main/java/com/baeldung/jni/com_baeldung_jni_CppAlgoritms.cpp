// com_example_jni_JNIJava.cpp

#include <iostream>
#include <cstring>
#include <cassert>
#include "com_baeldung_jni_CppAlgoritms.h"

namespace std {   };
using namespace std;

 size_t levenshtein_distance(const char* s, size_t n, const char* t, size_t m);



 JNIEXPORT  jint  JNICALL Java_com_baeldung_jni_CppAlgoritms_levenshtein
  (JNIEnv* env, jobject thisObject,jstring str1,jstring str2) {

    const char* str1Pointer = env->GetStringUTFChars(str1, NULL);
    const char* str2Pointer = env->GetStringUTFChars(str2, NULL);
    //size_t ld =0;

    return(int) levenshtein_distance(str1Pointer, strlen(str1Pointer), str2Pointer, strlen(str2Pointer));




}



size_t levenshtein_distance(const char* s, size_t n, const char* t, size_t m)
{
   ++n; ++m;
   size_t* d = new size_t[n * m];

   memset(d, 0, sizeof(size_t) * n * m);

   for (size_t i = 1, im = 0; i < m; ++i, ++im)
   {
      for (size_t j = 1, jn = 0; j < n; ++j, ++jn)
      {
         if (s[jn] == t[im])
         {
            d[(i * n) + j] = d[((i - 1) * n) + (j - 1)];
         }
         else
         {
            d[(i * n) + j] = min(d[(i - 1) * n + j] + 1, /* A deletion. */
                                 min(d[i * n + (j - 1)] + 1, /* An insertion. */
                                     d[(i - 1) * n + (j - 1)] + 1)); /* A substitution. */
         }
      }
   }



   size_t r = d[n * m - 1];

   delete [] d;

   return r;
}
