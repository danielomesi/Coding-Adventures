#Leetcode - Given an integer array arr and an integer k, modify the array by repeating it k times.
#For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].
#Return the maximum sub-array sum in the modified array.
#Note that the length of the sub-array can be 0 and its sum in that case is 0.


def main():
    lst=[-1,-2]
    k=5
    print(kConcatenationMaxSum(lst,k))


def kConcatenationMaxSum(lst,k):
    #lst - list of ints
    #k - int
    #rtype - int
    helper=lst.copy()
    max=0
    for i in range(k-1):
        list.extend(lst,helper)
    newListSize=len(lst)
    for i in range(newListSize-1):
         for j in range(newListSize-i):
              sum=getSumOfSubList(lst,i,j)
              if (sum>max):
                max=sum

    return max

def getSumOfSubList(lst,index,numOfSteps):
     #lst - list of ints
     #index,numofsteps - ints
     #rtype - int
     sum=lst[index]
     for i in range(1,numOfSteps):
        sum+=lst[index+i]
     return sum

if __name__ == "__main__":
       main()