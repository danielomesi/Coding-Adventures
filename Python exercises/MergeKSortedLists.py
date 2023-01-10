#LeetCode - You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
#Merge all the linked-lists into one sorted linked-list and return it.
#Daniel Omesi

def main():
    numList1=[2,3,4,8,45,74]
    numList2=[2,6,9,10,11,12,30,50]
    numList3=[1,5,7,12,17,31,70]
    numList4=[]
    listOfLists=[numList1,numList2,numList3,numList4]
    mergedList=mergeKlists(listOfLists)
    print(mergedList)

def mergeKlists(listOfLists):
    #"""
    # type listOfLists: a list containing lists of integers, every list is sorted in ascending order
    # rtype: list of integers, which is the unition of all lists sorted in ascending order
    # """
    listSizes=[] #To contain the size of each list by same index
    listIndexes=[] #I am running on every list with its own index, this is the place to save the index (every running index sits in the same index as the list in the container)
    resList=[]
    for item in listOfLists:
        listSizes.append(len(item)) #fill the sizes list with the correct sizes
        listIndexes.append(0) #reset the running indexes
    mainIndex=0
    while (areAllListsDone(listSizes,listIndexes)==False):  #while there are still integers that we didn't add to the final list
        while (isSmallThanAll(listOfLists,mainIndex,listIndexes[mainIndex],listIndexes,listSizes)==False): #checking if the item in curr list is smaller than all the rest
            mainIndex+=1
        resList.append(listOfLists[mainIndex][listIndexes[mainIndex]])
        listIndexes[mainIndex]+=1 ##updating the running indexes on the list that we added the item from
        mainIndex=0
    return resList



def isSmallThanAll(listOfLists, listInd,itemIndInList, listIndexes,listSizes):
    #"""
    # type listOfLists: a list containing lists of integers, every list is sorted in ascending order
    # listInd - the index of the list which the item i want to check that is the smallest is in
    #itemIndInList - the index of the item in the same list in the line above
    #listIndexes - a list that contains the current indexes on the sorting in everylist, in same order as the lists are ordered in the original lists container
    #listSizes - the logic size of each list
    # rtype: boolean - to determinte if this integer (only if exists) is smaller/equalr from all other integers with their curr indexes in the different lists
    # """
    isExist=False
    for i,item in enumerate(listOfLists):
        if ((listIndexes[i]!=listSizes[i]) and (listIndexes[listInd]!=listSizes[listInd])):
            isExist=True
            if listOfLists[listInd][itemIndInList]>item[listIndexes[i]]:
                 return False
    if (isExist):
        return True
    return False

def areAllListsDone(listSizes,listIndexes):
    for i,item in enumerate(listSizes):
        if (item!=listIndexes[i]):
            return False
    return True

        

if __name__ == "__main__":
       main()
