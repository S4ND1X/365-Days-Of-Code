



def isLucky(n):
    n = str(n)
    halfNumber = int(len(n)/2)
    sumaN1 = 0
    sumaN2 = 0    
    n1 = n[halfNumber::]
    n2 =n[:halfNumber:]  
    for i in n1:
        i = int(i)
        sumaN1 += i
    for i in n2:
        i = int(i)
        sumaN2 += i
    if sumaN1 != sumaN2:
        return False
    else:
        return True