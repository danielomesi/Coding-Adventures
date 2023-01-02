#You have n steps to make, and your moves are either 1 step at a time or 2 at a time
#This function returns the number of different combinations of moves to reach n steps
#Example, if you need to make 3 steps, then you have 3 options:
#Option 1: 1-1-1, Option 2: 2-1, Option 3: 1-2
#In addition, the function prints the combination,
#The print is recursive so every line is represnts a combination and instructs the number of steps in every move,
#If you don't see a certain move in a line so take it as the last appearnce of this move
#for example, if you are looking at a combination and move #1 is not showing in the combination line,
#then find the last appearnce of move #1 in the previous lines and this is the move you should make



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
