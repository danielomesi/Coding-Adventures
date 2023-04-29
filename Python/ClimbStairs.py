#You have n steps to make, and your moves are either 1 step at a time or 2 at a time
#This function returns the number of different combinations of moves to reach n steps
#Example: if you need to make 3 steps, then you have 3 options:
#Option 1: 1-1-1, Option 2: 2-1, Option 3: 1-2
#The function prints every combination in a seperate line
#Because the function is recursive every line presents only the 'new' moves based on running time,
#Whenever you don't see certain moves in a line ('missing'), you need to take these moves from their last appearnce in the previous lines
#Example: The below lines are the output of the function with n=3:
#Move #1=2 steps | Move #2=1 step | <<Option 1
#Move #1=1 step | Move #2=2 steps |  <<Option 2
#Move #2=1 step | Move #3=1 step | <<Option 3 
#In option 3, Move #1 is missing, so we take his last appearance, which is in the previous line, it is "Move #1=1 step", so this means that the combination is 1-1-1



def ClimbStairs(n,k):
    global option
    numOfSteps=1
    if (n==0):
        print(" <<Option "+str(option)+"\n")
        option+=1
        return 1
    if (n==1):
         print("Move #"+str(k)+"=1 step | <<Option "+str(option)+"\n")
         option+=1
         return 1
    else:
        print("Move #"+str(k)+"=2 steps | ",end="")
        b=ClimbStairs(n-2,k+1)
        print("Move #"+str(k)+"=1 step | ",end="")
        a=ClimbStairs(n-1,k+1)
        return a+b

option=1
n=int(input("Please enter the number of steps you want to make: "))
res=ClimbStairs(n,1)
print("The amount of different combinations to is "+str(res)) 
