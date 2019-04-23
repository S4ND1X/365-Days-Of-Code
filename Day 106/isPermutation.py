def isPermutation(n, inputArray):
    aux = []
    inputArray.sort()
    if 0 in inputArray:
        return False
    for i in range(1,n+1):
        aux.append(i)
    if inputArray == aux:
        return True
    else:
        return False
    

