lista = [-1,150,190,170,-1,-1,160,180]

listaNumeros = []
listaArboles = []
#?Guarda los numeros y si es -1 guarda su index
for i in range(len(lista)):
    if lista[i] != -1:
        listaNumeros.append(lista[i])
    else:
        listaArboles.append(i)
listaNumeros.sort()
#?Inserta un -1 en todos los indices guardados donde había un -1
for i in range (len(listaArboles)):
    listaNumeros.insert(listaArboles[i],-1)

print(listaNumeros)