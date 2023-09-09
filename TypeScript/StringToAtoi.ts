/*
Implement the myAtoi(string s) function,
 which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
*/
function myAtoi(s: string): number
{
    let res:number=0;
    let len:number=s.length;
    let index:number=0;
    let positivity:boolean=true;
    let newDigit:number;

    while(index<len)
    {
        if (s[index]==' ')
        {
            index++;
        }
        else
        {
            break;
        }
    }
    
    if (s[index]=='+' || s[index]=='-')
    {
        if(s[index]=='-')
        {
            positivity=false;
        }
        index++;
    }

    while(index<len)
    {
        if(isDigit(s,index))
        {
            newDigit=s.charCodeAt(index)-'0'.charCodeAt(0);
            res=res*10;
            res+=newDigit;
            index++;
        }
        else
        {
            break;
        }
    }

    if (positivity==false)
    {
        res=res*-1;
    }

    return res;
};

function isDigit(s:string,index:number):boolean
{
    let res:boolean=false;
    let aritmeticRes:any=s.charCodeAt(index)-'0'.charCodeAt(0);

    if (aritmeticRes>=0 && aritmeticRes<=9)
    {
        res=true;
    }

    return res;
};

console.log(myAtoi('                     47373733'));