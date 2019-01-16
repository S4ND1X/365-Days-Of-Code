def BubbleSort (lista):
    while True:
        correction=False
        for x in range(0,len(lista)-1):
            if lista[x]>lista[x+1]:
                lista[x],lista[x+1]=lista[x+1],lista[x]
                correction = True
        if not correction:
            return lista       
            
lista1=[2,3,4,1]       
print(BubbleSort(lista1))