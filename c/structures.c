#include <stdio.h>
#include <string.h>

struct Book
{
    char title[50];
    int id;
};

// or
struct
{
    int size;
} size;

void structures()
{
    struct Book Book1;
    strcpy(Book1.title, "Some title");
    Book1.id = 12;

    printTitle(&Book1);

    int id = getId(&Book1);
    printf("%d\n", id);

    setId(&Book1, 9);
    printf("%d\n", Book1.id);
}

void printTitle(struct Book *book)
{
    printf("%s\n", book->title);
}

int getId(struct Book *book)
{
    return book->id;
}

void setId(struct Book *book, int new_id)
{
    book->id = new_id;
}
