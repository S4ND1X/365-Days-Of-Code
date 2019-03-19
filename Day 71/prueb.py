def limpiarPalabra(myString):
    myString = myString.lower()
    myString = myString.replace(" ", "")
    return esPalindromo(myString)

def esPalindromo(myString):
    for i in range(0, len(myString)):
        if myString[i] == myString[-1]:
            
    

myString = "Lava La Tina"
print(limpiarPalabra(myString))