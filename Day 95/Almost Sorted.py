def inOrder(lista):
    """ Comprueba si esta ordenada """
    for i in range(len(lista)-1):
        if lista[i+1] < lista[i]:
                return False        
    return True
def firstWrong(lista):
    """ Obtiene el primer numero erroneo por la izquierda """
    for i in range(len(lista)-1):
        if lista[i+1] < lista[i]:
            return i
def secondWrong(lista):
    """ Obtiene el segundo numero erroneo por la derecha """
    i = len(lista)-1
    while lista[i] >= lista[i-1] and  i > -1:
        i -= 1
    return i
def doSwap(a,b, lista):
    """ Hace un swap de los valores """
    lista[a], lista[b] = lista[b], lista[a]
def doReverse(a,b,lista):
    """ Hace un reverse del subarray """
    lista[a:b+1] = lista[a:b+1][::-1]
     
wea = input()
lista = input().split()
for i in range(len(lista)):
    lista[i] = int(lista[i])

#?Comprueba si esta ordenada
if inOrder(lista):
    print("yes")
#? Si no, primero hace un swap 
elif inOrder(lista) == False:
    a = firstWrong(lista)
    b = secondWrong(lista)
    doSwap(a,b,lista)
    #?Si con un swap fue suficiente regresa los valores
    if inOrder(lista) == True:
        print(f"yes\nswap {a+1} {b+1}")
    elif inOrder(lista) == False:
        #?Si no, deshace el swap e intenta un reverse
        doSwap(b,a,lista)        
        doReverse(a,b,lista)
        #?Comprueba una ultima vez, si ya esta en orden, se logro con un reverse si no, de plano ya no se puede.
        if inOrder(lista):
            print(f"yes\nreverse {a+1} {b+1}")
        else:
            print("no")