#include <stdio.h>
/* generally interfaces goes to `.h` and definitions goes to `.c` files */
#include "pointers.h" // `.h is for example
#include "structures.c"
#include "errors.c"

// custom type
typedef unsigned char BYTE;
BYTE b1;

// consts
#define F_CONST = 0;
const int G_CONST = 1;

// scope global variable
int i = 0;

void data_types()
{
    char a = 'a';
    int b = 0;
    float c = 0.1;
    char *d = "String";
    printf("%d, %s", a, d);
}

void storage_classes()
{
    int e;                    // (auto) local
    auto int f;               // local
    register int g;           // stored in register instead of RAM
    static int h;             // global
    extern int extern_var;    // visible to all other files
    printf("%d", extern_var); // from `support.c`
}

// in C function must be wroten before using or declared empty
int do_stupid_thing();

void decision_making()
{
    int a = 10, b = 20;
    if (a != b)
    {
        do_stupid_thing(a, b);
    }
    else if (a < b)
    {
        do_stupid_thing(a, b);
    }
    else
    {
        do_stupid_thing(a, b);
    }
}

// filled function body after declared
int do_stupid_thing(int a, int b)
{
    return 14;
}

// passing arguments to a function by copy their values
// input: x=1, y=2 -> output: x=1, y=2
void swap_called_by_value(int x, int y)
{
    int temp = x;
    x = y;
    y = temp;
}

// passing arguments to a function by copies their address
// input: x=1, y=2 -> output: x=2, y=1
void swap_called_by_reference(int *x, int *y)
{
    int temp = *x;
    *x = *y;
    *y = temp;
}

int main()
{
    data_types();
    storage_classes();
    decision_making();
    pointers();
    structures();
    errors();
    return 0;
}