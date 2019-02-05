#Sum of two number
def add(param1, param2):
    return param1 + param2

#Check palindrome (easyversion)
def checkPalindrome(inputString):
    return  inputString[::-1] == inputString  

#Highest product
def adjacentElementsProduct(inputArray):
    y = -1000
    for x in range (0,len(inputArray)-1):
       if inputArray[x]*inputArray[x+1] > y:
           y = inputArray[x]*inputArray[x+1]
    return y

