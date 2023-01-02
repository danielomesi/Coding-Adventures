
#receives an array of integers and a target int,
#and returns the indexes of both numbers that hold the equation a+b=target

arr=[0,3,5,6,-1,21,30]
target=29

def findSummersLocs(array,target):
    for index1, num in enumerate(array, start=0):
            numCompleter=target-num
            for index2, eternalNum in enumerate(array[index1+1:], start=0):
                if eternalNum==numCompleter:
                    return {index1,index2+index1+1}

print(findSummersLocs(arr,target))

