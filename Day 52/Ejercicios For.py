#Ejercicios for
#Hecho por Jorge Sanchez
def piramideDoble(number):
    """Primero imprime un espacio y despues va imprimiendo los numeros de 1 a num y despues de num a 1"""
    for i in range (0,number+1):
        for j in range (number - i):
            print(" ", end = " ")
        for j in range (1, i):
            print(j, end=" ")
        for i in range(i, 0, -1):
            print(i, end=" ")
        print("\n")
piramideDoble(7)
def piramideEsquina(number):
    """ Recibe numero e imprime pegado a la izquierda """
    for i in range(1,number):        
        for j in range(number - i):
            print(" ", end= " ")
        for j in range(1, i):
            print(j, end=" ")
        print("\n")
piramideEsquina(7)
def piramideAsteriscos(number):
    """ Se imprime el string hasta el numbero y cuando llegue ya no """
    for i in range (1, number+1):
        print("*"*i)
        if i == number:
            for j in range (number-1 ,0, -1):
                print("*"*j)
piramideAsteriscos(7)
def piramideAsteriscos2(number):
    """ En el rango de number imprimira un espacio y le concatena el asterisco"""
    for i in range(number):
        print (' '*(number-i-1) + '*'*(2*i+1))
piramideAsteriscos2(7)