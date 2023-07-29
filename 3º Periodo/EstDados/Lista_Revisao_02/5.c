#include <stdio.h>

void decimalParaBinarioRecursivo(int decimal) {
    if (decimal > 0) {
        decimalParaBinarioRecursivo(decimal / 2);
        printf("%d", decimal % 2);
    }
}