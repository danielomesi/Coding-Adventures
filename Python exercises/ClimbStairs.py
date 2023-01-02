#You have n steps to make, and your moves are either 1 step at a time or 2 at a time
#This function returns the number of different combinations of moves to reach n steps
#Example, if you need to make 3 steps, then you have 3 options:
#Option 1: 1-1-1, Option 2: 2-1, Option 3: 1-2
#The function prints every combination in a seperate line
#Because the function is recursive every line presents only the 'new' moves based on running time,
#Whenever you don't see certain moves (like they are 'missing') in a line you need take those move from the last appearnce they have with the same numbers
#Example, if moves from 1 to  are not showing in the combination line,
#find the last appearnce of moves 1-k in the previous lines and use them as the moves for this scenario



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
