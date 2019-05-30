
def comparar(s1,s2):
    lista = []
    for i in s1:
        if i not in s2:
            lista.append(i)
    return len(lista)

s1 = input()
s2 = input()
n = int(input())

w = comparar(s1,s2)

if w*2 > n:
    print("No")
else
    print("Yes")







        
        