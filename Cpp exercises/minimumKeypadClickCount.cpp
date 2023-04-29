//There is a keypad with 9 buttons, for each button you can map 3 letters - 1st place is 1 click,
// 2nd place is 2 clicks, 3rd place is 3 clicks
// map letters to palce by your chocie so that:
//Given a string, the function will return the minimum clicks to type to get this string

using namespace std;
#include <iostream>
#include <vector>
#include <algorithm>

struct letterData
{
    int m_frequency = 1;
    int m_clickCount = 0;
    char m_ch='\0';
    letterData() = default;
    letterData(char ch) : m_ch(ch)
    {
        
    }
};

int minimumKeypadClickCount(string text);
bool compareFunction(letterData a, letterData b);

void main()
{
    string check = "aubcdddffum";
    cout << "The minimum clicks count is " << minimumKeypadClickCount(check) << endl;
}

int minimumKeypadClickCount(string text)
{
    vector<letterData> lettersData(26); //create an array for all letters, each letter "zeroed"
    int index,sum=0,keysAllocated=0;

    //for each charachter which is a letter, it updates its frequency to the array
    for (auto ch : text)
    {
        if (ch >= 'a' && ch <= 'z')
        {
            index = ch - 'a';
            if (lettersData[index].m_ch == '\0')
                lettersData[index] = letterData(ch);
            else
                lettersData[index].m_frequency++;
        }
    }

    //sort in descending order by frequency
    sort(lettersData.begin(), lettersData.end(), compareFunction);

    //assign keys for each letter, the letters with most appearnces will be assigned to the quickest keys
    for (auto letter : lettersData)
    {
        if (letter.m_ch != '\0') //if this index in the vector is indeed a letter
        {
            letter.m_clickCount = keysAllocated / 9 + 1;
            keysAllocated++;
            sum += (letter.m_clickCount * letter.m_frequency);
        }
        
    }
    return sum;
}

bool compareFunction(letterData a, letterData b)
{
    return a.m_frequency > b.m_frequency;
}