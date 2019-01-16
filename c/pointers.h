#include <stdio.h>

/* 
1.* Pointers are generally MEMEORY ADDRESSES!
2.& It's a extraction operator. `&x` is a pointer to `x` value.
3.* Can be dereference operator. Gets value from memory address and can modify its
*/

void pointers()
{
    printf("\n\npointers():\n");

    /* Manual memory allocation */
    int x = 5;
    printf("x = %d\n", x);   // value (reference)
    printf("&x = %p\n", &x); // dereference

    // create new pointer to x address
    int *y = &x;             // address of x goes to y
    printf("*y = %d\n", *y); // pointer value
    printf("y = %p\n", y);   // address

    // change pointer value
    *y = 8;
    printf("\nx = %d", x);
    printf("\ny = %d", *y);

    int a = 0;
    add_one_by_value(a);
    printf("\n\nadd_one_by_value(a) => %d\n", a);

    add_one_by_value_by_reference(&a);
    printf("add_one_by_value_by_reference(a) => %d\n", a);

    int array_stack[5]; // allocate array on stack

    /* Dynamic memory allocation */
    int size = 3;
    int *array;
    array = (int *)calloc(size, sizeof(*array)); // allocate array on heap

    printf("\nAllocate array on heap: ");
    for (int i = 0; i < size; i++)
    {
        array[i] = i;
        printf("[%d]", array[i]);
    }
    // to prevent memory leak
    free(array);
}

// passing argument as a value
void add_one_by_value(int a)
{
    a += 1;
}

// passing argument as a reference
void add_one_by_value_by_reference(int *a)
{
    *a += 1;
}
