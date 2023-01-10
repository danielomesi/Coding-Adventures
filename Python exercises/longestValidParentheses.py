#Leetcode - Given a string containing just the characters '(' and ')',
#return the length of the longest valid (well-formed) parentheses substring
#example: for the input ")()())" - output is 4, for the input ")(" - output is 0
#Daniel Omesi

def main():
    s="(((()))()((()((())((())(()(()(())()"
    num=longestValidParentheses(s)
    print(num)

def longestValidParentheses(s):
    if (len(s)==0):
        return 0

    while (s[0]==')'):
            if(len(s)>1):
                s=s[1:]
            else:
                return 0
    
    if (s[0]=='('):
        if (len(s)>1):
            s=s[1:]
        else:
            return 0
        for i,char in enumerate(s):
            if (char==')'):
                return 2+longestValidParentheses(s[:i]+s[i+1:])
        return 0
    return longestValidParentheses(s)

if __name__ == "__main__":
       main()