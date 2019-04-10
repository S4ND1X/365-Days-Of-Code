
def listOfDoom(lista):
    lista2 = lista.replace("->",".")
    lista2 = lista2.replace(".",",")
    lista2 = lista2.split(",")

    aux = []
    for i  in lista2:
        i = int(i)
        if i not in aux:        
            aux.append(i)
    aux.sort()
    return '->'.join(str(x) for x in aux)


# print(listOfDoom("1->1->1->1,1->2->2->2,3->3->4->4"))


# s = input()
# s = s.replace("[", "")
# s = s.replace("]", "")

# a = s.split(",")

# nuevo = []


# for i in a:
#     nuevo.append(i.split("->"))


# nuevo_int = []

# for i in nuevo:
#     nuevo_int.append(list(map(int, i)))


# nuevo_sorted = []

# for i in range(len(nuevo)):
#     nuevo_sorted.append(sorted(nuevo_int[i]))

# x=0

# for i in range(len(nuevo_sorted)):
#     if(nuevo_int[i] != nuevo_sorted[i]):
#         x = i

# salida = f"{x}"

# for i in range(len(nuevo[x])):
#         if nuevo_int[x][i] != nuevo_sorted[x][i]:
#                 salida+=f" {nuevo_int[x][i]}"
        
# print(salida)

# lista = [3,1,2]
# lenghtLista = int(input())
# lista = input().split()
# for i in range(len(lista)):
#     lista[i] = int(lista[i]) 
# sortedList = lista[:]
# sortedList.sort()
# cont = 0
# if lista == sortedList:
#     print("yes")
# else:
#     for i in range(len(lista)-1):
#         if lista[i+1] < lista[i]:
#             lista[i+1],lista[i] = lista[i],lista[i+1]
#             n1, n2 = lista[i], lista[i+1]
#             cont +=1 
#     if cont == 1:
#         print(f"yes\nswap {n1} {n2}")
#     elif cont > 1:

#     else:
#         print("no")
    


# import sys

# def checkSorted(arr):
#     return all(arr[i] <= arr[i+1] for i in range(len(arr)-1))

# def almostSorted(arr):
#     if len(arr) == 1 or checkSorted(arr):
#         print("yes")
#         return

#     # Find first item out of order from the left
#     i = 0
#     while i < len(arr) - 1 and arr[i] < arr[i+1]:
#         i+=1
#     first_ooo_left = i

#     # Find first item out of order from the right
#     i = len(arr) - 1
#     while i > 0 and arr[i-1] < arr[i]:
#         i-=1
#     first_ooo_right = i

#     # Same item?
#     if (first_ooo_left == first_ooo_right):
#         print("no")
#         return

#     l = first_ooo_left
#     r = first_ooo_right
#     swaps = 0
#     while r-l > 0:
#         if arr[l] > arr[r]: 
#             arr[r], arr[l] = arr[l], arr[r]
#             swaps += 1
#         r-=1
#         l+=1

#     sorted = checkSorted(arr)

#     if sorted:
#         if swaps == 1:
#             print("yes")
#             print("swap " + str(first_ooo_left+1) + " " + str(first_ooo_right+1))
#         elif swaps == (first_ooo_right-first_ooo_left+1)//2:
#             print("yes")
#             print("reverse " + str(first_ooo_left+1) + " " + str(first_ooo_right+1))
#     else:
#         print("no")





lenghtLista = int(input())
lista = input().split()
for i in range(len(lista)):
    lista[i] = int(lista[i]) 
sortedList = lista[:]
sortedList.sort()
cont = 0
notOrderLeft = 0
notOrderRight = 0
if lista == sortedList:
    print("yes")
else:
    for i in range(len(lista)-1):
        if lista[i+1] < lista[i]:
            lista[i+1],lista[i] = lista[i],lista[i+1]
            n1, n2 = i+1, i+2
            cont +=1 
if cont == 1:
    print(f"yes\nswap {n1} {n2}")
elif cont > 1:
    conta = 0
    for i in range(len(lista)-2,0,-1):
        if lista[i] < lista[i-1] and lista[i] < lista[i+1] and conta <1:
            notOderRight = i+1
            conta += 1      
                
    for j in range (1,len(lista)-2):
        if lista[j] > lista[j-1] and lista[j] > lista[i+1]:
            notOrderLeft = j           
    if notOderRight == 0 and notOrderLeft == 0:
        print("no")     
    lista[notOrderLeft:notOderRight] = lista[notOrderLeft:notOderRight][::-1]
    if lista == sortedList:
        print(f"yes\nreverse {notOrderLeft+1} {notOderRight+1}")

else:
    print("no")
    
