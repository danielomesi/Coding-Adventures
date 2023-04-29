#define _CRT_SECURE_NO_WARNINGS
#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

char* longestCommonPrefix(char** strs, int strsSize) {

    int minLen, i, isFit = 0, phySize = 1, logSize = 0, j;
    int check = strlen(strs[0]);
    bool isStop = false;
    minLen = check;
    char c, * str;

    str = (char*)malloc(sizeof(char));


    for (i = 0; i < strsSize; i++)
    {
        check = strlen(strs[i]);
        if (check < minLen)
            minLen = check;
    }

    for (i = 0; i < minLen; i++)
    {
        c = strs[0][i];
        isFit = 0;
        for (j = 0; j < strsSize; j++)
        {
            if (c == strs[j][i])
                isFit++;
            else
            {
                isStop = true;
                break;
            }
        }
        if (isStop)
            break;
        if (isFit == strsSize)
        {
            if (logSize == phySize)
            {
                phySize *= 2;
                str = (char*)realloc(str, sizeof(char) * phySize);
            }
            str[logSize] = c;
            logSize++;
        }
    }

    if (logSize == 0)
        str[logSize] = '\0';
    else
    {
        str = (char*)realloc(str, sizeof(char) * (logSize + 1));
        str[logSize] = '\0';
    }

    return str;
}