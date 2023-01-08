#leet code -  Add two numbers
#You are given two non-empty linked lists representing two non-negative integers.
#The digits are stored in reverse order, and each of their nodes contains a single digit.
#Add the two numbers and return the sum as a linked list.
#You may assume the two numbers do not contain any leading zero, except the number 0 itself.

def main():
    numList1=[2,4,3]
    numList2=[5,6,4]
    sumList=sumNumlists(numList1,numList2)
    print(sumList)

def sumNumlists(numList1,numList2):
    #this function receives 2 lists of, each list contains the digits of a number in a reversed order,
    #function return value is a list of the reverse number which is the result of summing the 2 numbers
    multiplier=1
    num1=0
    num2=0

    for element in numList1:
        num1+= (element*multiplier)
        multiplier*=10

    multiplier=1
    for element in numList2:
        num2+= (element*multiplier)
        multiplier*=10
    
    res=num1+num2
    resList=[]
    while (res>0):
        resList.append(int(res%10))
        res=int(res/10)
    return resList



if __name__ == "__main__":
       main()