/**
 * @param {string} s
 * @return {number}
 */
var isInSubString = function(substring,char) 
{
   
    for(i=0;i<substring.length;i++)
    {
        if (substring[i]==char)
        {
            return true;
        }
    }
    return false;
};

var getSubStringLen = function(string, index) 
{
    let len=string.length;
    let substring='';
    let res=0;

    while(index<len)
        {
            if (!isInSubString(substring,string[index]))
            {
                substring=substring+string[index];
                res++;
                index++;
            }
            else
            {
                break;
            }
        }

        return res;
};

var lengthOfLongestSubstring = function(s) 
{
    let substring;
    let res;
    let index=0,max=0,i;

    for(i=0;i<s.length;i++)
    {
        res=getSubStringLen(s,i);
        
        if (res>max)
        {
            max=res;
        }
    }
    return max;
};

console.log(lengthOfLongestSubstring('abcbfrwas'))