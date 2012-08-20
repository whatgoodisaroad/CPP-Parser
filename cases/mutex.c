
// Should be identified as mutually exclusive.

#include <stdio.h>

int main() {
    
    #ifdef WINDOWS
        printf("Hello Redmond.");
    #elif defined UNIX
        #ifdef MAC
            printf("Hello Cupertino.");
        #elif defined LINUX
            printf("Hello Helsinki.");
        #endif
    #endif
    
}
