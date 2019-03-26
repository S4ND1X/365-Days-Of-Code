#Hecho por Jorge Sanchez 
import math
import time
def imprimir_menu():
    """ Imprime un menu """
    print("~~~~~ Menu De Programas ~~~~~\n1.Energia Cinetica\n2.Multiplos comunes\n3.Oferta\n4.Barra\n5.Salir \n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
def energia_cinetica():
    masa = float(input("Dame la masa en kg: "))
    velocidad = float(input("Dame la velocidad en m/s: "))
    energiaCinetica = (math.pow(velocidad,2)*masa) * 0.5
    print(f"La energia cinetica con {masa}kg y {velocidad}m/s es de {energiaCinetica}j.")    
def multiplos_comunes():
    """ Obtiene los multiplos comunes en determinado rango """
    num1  = int(input("Dame el primer numero: "))
    num2 =  int(input("Dame el segundo numero: "))
    maximo = int(input("Dame el numero maximo: "))
    multiplosComunes = []
    for i in range(1,maximo+1):
        if i % num1 == 0 and i % num2 == 0:
            multiplosComunes.append(i)
    print(multiplosComunes)
def ofertas():
    """ Dara las ofertas que necesite """
    cantidad = float(input("Cuanto vas a recargar: "))
    if cantidad >= 10 and cantidad <= 25:
        cantidad *=1.03
    if cantidad > 25    and cantidad <= 50:
        cantidad *=1.08
    if cantidad > 50:
        cantidad *=1.2
    print(f"Tu carga final es de {cantidad}")
def barra_progreso():
    """ Imprime una x cada cierto tiempo """
    tiempo = int(input("Dame un tiempo limite: "))
    for i in range(tiempo):
        time.sleep(5)
        print("x", end = ' ')        
#Programa principal
opcion = '1'
while opcion !='5':
    time.sleep(3)    
    imprimir_menu()
    opcion = input("Elige un programa: ")
    if opcion == '1':
        energia_cinetica()
    elif opcion == '2':
        multiplos_comunes()
    elif  opcion == '3':
        ofertas()
    elif opcion == '4':
        barra_progreso()
    


        
        



