#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>

int errors()
{

    int dividend = 20;
    int divisor = 0;
    int quotient;

    if (divisor == 0)
    {
        fprintf(stderr, "\nDivision by zero! Exiting...\n");
        exit(-1);
        // or
        // exit(EXIT_FAILURE);
    }

    quotient = dividend / divisor;
    fprintf(stderr, "Value of quotient : %d\n", quotient);

    exit(0);
    // or
    // exit(EXIT_SUCCESS);
}