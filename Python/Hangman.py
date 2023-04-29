import random
import math



def main():
    welcomeMessage()
    MAX_TRIES =6
    numOfFailures=0
    numOfSuccess=0
    old_letters_guessed =[]
    picturesDict=getDict()
    word=chooseWord()
    secret_word_list=list(word)
    show_hidden_word(secret_word_list, old_letters_guessed)
    printHangMan(numOfFailures,picturesDict)
    while ((numOfSuccess<len(dict.fromkeys(word)) and ' 'not in word) or ((numOfSuccess+1<len(dict.fromkeys(word)) and ' 'in word)) and numOfFailures<MAX_TRIES):
        c=getChar()
        if (try_update_letter_guessed(c, old_letters_guessed)):
            if (c not in word):
                numOfFailures+=1
            else:
                numOfSuccess+=1
        show_hidden_word(secret_word_list, old_letters_guessed)
        printHangMan(numOfFailures,picturesDict)

    if (numOfSuccess==len(dict.fromkeys(word)) and ' 'not in word) or ((numOfSuccess+1==len(dict.fromkeys(word)) and ' 'in word)):
        print("Good job!")
    else:
        print("You failed")


def printHangMan(numOfFailures,picturesDict):
        print(picturesDict[numOfFailures])

    
def getDict():
    picture1="""    x-------x\n"""
    picture2="""    x-------x
        |
        |
        |
        |
        |\n"""
    picture3="""    x-------x
        |       |
        |       0
        |
        |
        |\n"""
    picture4="""    x-------x
        |       |
        |       0
        |       |
        |
        |\n"""
    picture5="""    x-------x
        |       |
        |       0
        |      /|\\
        |
        |\n"""
    picture6="""    x-------x
        |       |
        |       0
        |      /|\\
        |      /
        |\n"""
    picture7="""    x-------x
        |       |
        |       0
        |      /|\\
        |      / \\
        |\n"""
    picturesDict={0:picture1, 1:picture2, 2:picture3,3:picture4,4:picture5,5:picture6,6:picture7}
    return picturesDict

def welcomeMessage(): 
    HANGMAN_ASCII_ART="""Welcome to the game HangMan!\nThe subject is Countries\n    _     _                                         
    | |  | |                                        
    | |__| | __ _ _ __   __ _ _ __ ___   __ _ _ __  
    |  __  |/ _` | '_ \ / _` | '_ ` _ \ / _` | '_ \ 
    | |  | | (_| | | | | (_| | | | | | | (_| | | | |
    |_|  |_|\__,_|_| |_|\__, |_| |_| |_|\__,_|_| |_|
                        __/ |                      
                        |___/\n"""
    print(HANGMAN_ASCII_ART)

def getWord():
    word=input("Please enter a word: ")
    res,word=isWordLegit(word)
    while (not res):
        print("Wrong input!")
        word=input("Please enter a word: ")
        res,word=isWordLegit(word)
    
    return word;

def chooseWord():
    lst=["Canada","Japan","United Staes", "Israel","Spain","Netherlands","China","Italy","Mexico","Colombia"
    ,"Argentina", "Brazil","Cyprus"]
    #with open(r"C:\Users\omesi\Desktop\Python\words.txt","r") as wordsFile:
     #   lst=wordsFile.readlines()
    num=random.randint(0,11)
    word=lst[num]
    return word.lower()

def isWordLegit(word):
# word is str type
# function returns true and the word if the word is valid,
# returns false and empty string if the word is not valid
    if (word.isalpha() and len(word)>1):
        return True, word.lower()
    else:
        return False,""

def getChar():
    guess=input("Please enter a letter to guess: ")
    res,guess=isCharLegit(guess)
    while (not res):
        print("Wrong input")
        guess=input("Please enter a letter to guess: ")
        res,guess=isCharLegit(guess)
    return guess

def isCharLegit(s):
    if (s.isalpha() and len(s)==1):
        return True,s.lower()
    else:
        return False, ""

def check_valid_input(letter_guessed, old_letters_guessed): 
    if ( (isCharLegit(letter_guessed)) and (letter_guessed.lower() not in old_letters_guessed) ):
        return True
    else:
        return False

def try_update_letter_guessed(letter_guessed, old_letters_guessed):
    if check_valid_input(letter_guessed,old_letters_guessed):
        old_letters_guessed+=letter_guessed.lower()
        return True
    else:
        print("X")
        print(*old_letters_guessed, sep="->")
        return False

def show_hidden_word(secret_word, old_letters_guessed): 
    for i in range(len(secret_word)):
        if secret_word[i] in old_letters_guessed:
            print(secret_word[i],end=" ")
        elif (secret_word[i]==' '):
            print("  ",end=" ")
        else:
             print("_",end=" ")
    print("\n")

if __name__ == "__main__":
      main() 