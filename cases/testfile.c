
// Should be identified as mutually exclusive.

#include <stdio.h>

int main() {
    
    #ifdef WINDOWS
        printf("Hello Redmond.");
    #elif defined MAC
        printf("Hello Cupertino.");
    #elif defined LINUX
        printf("Hello Helsinki.");
    #endif

}
