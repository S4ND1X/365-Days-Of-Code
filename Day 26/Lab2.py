import math
import time
#!Se usa time para un delay entre respuestas
#Funciones
def get_area_prisma (b,h):
    """ Primero calcula el area de la base para poder usarlo en la formula del área total"""
    b = float(b)
    h = float(h)  
    area_base = (math.sqrt(3)/4)*math.pow(b,2)
    area_total = area_base*2 + 3*b*h
    area_total = round(area_total,2)
    print(f"El area total es de {area_total}")
    time.sleep(2.5)

def get_volumen_aceite (r,h):   
    """ Primero saca la altura del liquido y despues sacamos su volumen, con solo dos decimales """
    h = 200 - h
    volumen = round(math.pi*math.pow(r,2)*h,2)   
    volumen_metros = round(volumen * 0.0283168,2)
    print(f"El volumen del aceite es: {volumen}ft^3 /n y {volumen_metros}m^3")
    time.sleep(2.5)

def get_area_perimetro (a,b,c):
    """ Se calcula el perimetro y despues s para aplicar la formula de heron """
    perimetro = a + b + c
    s = perimetro / 2
    area = math.sqrt(s*((s-a)*(s-b)*(s-c)))
    print(f"El área es de {area} y el perimetro es {perimetro}")
    time.sleep(2.5)

def get_tiempo (seg):
    """ Se usa % para sacar el residuo y ver cuanto tiempo es (similar a los billetes) """
    D = seg // 86400
    R = seg % 86400
    H = R // 3600
    R = R % 3600
    M = R // 60
    R = R % 60
    S = R // 1
    print(f"{seg} segundos son: {D} días, {H} horas, {M} minutos y {S} segundos")
    time.sleep(2.5)

def get_area_angulo(a,b,A):
    """ Primero se convierte a radianes y despues se aplica la formula """
    A = (A * math.pi ) / 180
    area = ((a * b) * 0.5) * math.sin(A)
    print(f"El área del triangulo es: {area}")
    time.sleep(2.5)

def validacion_floats_2v(i, j, S,S1,O):
    """ Se validara mientras el controlador no se falso y si es falso ya son entradas valida
        las cuales de utilizaran en la funcion del problema indicado por O """
    cont = True
    while cont == True:
        try: 
            i = float(i)
            j = float(j)
            cont = False

        except:
            print("Entrada Inválida, solo numeros.")            
            i = input(S)
            j = input(S1)
    if cont == False:
        if O == 1:
            get_area_prisma(i,j)
        elif O == 2:
            get_volumen_aceite(i,j) 

def validacion_floats_3v(i, j,k, S,S1,S2,O):
    """ Se validara mientras el controlador no se falso y si es falso ya son entradas valida
        las cuales de utilizaran en la funcion del problema indicado por O """
    cont = True
    while cont == True:
        try: 
            i = float(i)
            j = float(j)
            k = float(k)
            cont = False

        except:
            print("Entrada Inválida, solo numeros.")            
            i = input(S)
            j = input(S1)
            k = input(S2)
    if cont == False:
        if O == 3:
            get_area_perimetro(i,j,k)
        elif O == 5:
            get_area_angulo(i,j,k)         
    


#! se inicia el bucle
userOption = 1
while userOption != 6:
    print("""
    =========================================
    |      1.Área de Prisma Triangular       |
    |      2.Volumen Aceite Cilindrico       |
    |      3.Área triangulo y perimetro      |
    |      4.Convertidor de Segundos         |
    |      5.Área de triangulo con angulo    |
    |      6.Salir                           |
    =========================================
    """)
    #!Se le pide la opción al usuario y se definen los casos
    userOption = input("Elige una opcion: ")
    while True:   
        try:
            userOption = int(userOption)
            break          
        except ValueError:
            print("Entrada Invalida")
            userOption = input("Elige una opcion: ")
            

    if userOption == 1: 
        print("Área de Prisma Triangular")
        b = input("Base (m): ")
        h = input("Altura (m): ")
        validacion_floats_2v(b,h,"Base (m): ","Altura (m): ",1)            
        

    elif userOption == 2:
        print("Volumen aceite")
        h = input("Distancia del aceite a la tapa (ft): ")
        r = input("radio (ft): ")
        validacion_floats_2v(h,r,"Distancia del aceite a la tapa (ft): ","radio (ft): ",2)  

    elif userOption == 3:
        print("Area de triangulo: ")
        a = input("Lado A: ")
        b = input("Lado B: ")
        c = input("Lado C: ")
        validacion_floats_3v(a,b,c,"Lado A: ","Lado B: ","Lado C: ",3)

    elif userOption == 4:
        print("Convertidor de Segundos")
        seg = input("Cuantos segundos quiere convertir: ")
        while True:   
            try:
                seg = int(seg)
                break          
            except ValueError:
                print("Entrada Invalida")
                seg = input("Cuantos segundos quieres convertir: ")
        get_tiempo(seg)

    elif userOption == 5:
        print("Área triangulo")
        a = input("Cual es el lado A: ")
        b = input("Cual es el lado B: ")
        angulo = input("Cual es angulo: ")
        validacion_floats_3v(a,b,angulo,"Cual es el lado A: ","Cual es el lado B: ","Cual es el angulo: ",5)

    #!Si la opción que puso no esta en el rango se informa al usuario
    elif userOption < 1 or userOption > 6:
        print("Entrada Inválida")
        time.sleep(1.5)

        

        

