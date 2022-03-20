#define _CRT_SECURE_NO_WARNINGS
#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>


#define MAX_INT 2147483647
#define MIN_INT -2147483648


int reverse(int x);

void main()
{
    int num =1534236469;

    printf("The num is : %d", reverse(num));

}

int reverse(int x) {


    double newNum = 0;
    int copy = x;
    bool isNatural;

    if (x == 0)
        return x;

    if (x > 0)
    {
        isNatural = true;
    }

    else
    {
        if (x == MIN_INT)
            return 0;
        isNatural = false;
        copy *= -1;
    }

    while (copy > 0)
    {
        if (!((newNum * 10 >= MIN_INT) && (newNum * 10 <= MAX_INT)))
            return 0;

        newNum *= 10;
        newNum += (copy % 10);
        copy /= 10;
    }

    if (!isNatural)
        newNum *= -1;

    return (int)newNum;
}