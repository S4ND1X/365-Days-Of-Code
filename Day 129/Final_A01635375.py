import time
def lee_archivo():
    with open('calificaciones.csv','r') as file:
        datos = []
        for linea in file:
            listaLinea = linea.rstrip()
            listaLinea = listaLinea.split(",")
            datos.append(listaLinea)
    return datos



def calif_semestre(datos):
    """ Para cada linea en el archivo comenzando de la 1, le agregamos al final el promedio"""
    for linea in range(len(datos)):
        prom = int(datos[linea][1])*0.3 + int(datos[linea][2])*0.25  + int(datos[linea][3])*0.45
        datos[linea].append(round(prom,2))
    return datos




def promedio_modulo(datos,numero):
    """ Suma todos los valores de las filas y los divide entre el numero de alumnos"""
    prom = 0
    for linea in range(len(datos)):
        prom += int(datos[linea][numero])
    return round(prom/43,2)




def diplomas(datos):
    """ Busca alumnos con mas de 90 """
    for linea in range(len(datos)):
        if datos[linea][4] > 90:
            print("Alumno con curp ", datos[linea][0], " obtuvo ", datos[linea][4])


def estado(datos):
    try:
        reporte_estado = open("Reporte_JorgeSanchez.txt","w")
    except:
        print("No se pudo hacer")
    else:
        """ Generar acumuladores de estado y si es de ese estado sumarlo"""
        aprobados , ch, nl, sl, sr, ts = 0, 0, 0, 0, 0, 0
        reporte_estado.write("Reporte de Estados\n")
        for linea in range(len(datos)):
            if datos[linea][4] >= 70:
                aprobados +=1
                estado = datos[linea][0][11:13]
                if estado == "CH":
                    ch += 1
                elif estado == "NL":
                    nl += 1
                elif estado == "SL":
                    sl +=1 
                elif estado == "SR":
                    sr += 1
                elif estado == "TS":
                    ts += 1
    reporte_estado.write(f"De los {aprobados}: \n")
    reporte_estado.write(f"1. {(ch*100)//aprobados}% es de Chihuahua\n2. {(nl*100)//aprobados}% es de Nuevo Leon\n3. {(sl*100)//aprobados}% es de San Luis Potosi\n4. {(sr*100)//aprobados}% es de Sonora\n5. {(ts*100)//aprobados}% es de tamapulipas\n")
estado(calif_semestre(lee_archivo()))

#Generar archivo
datos = calif_semestre(lee_archivo()) 

opcion = "1"
while opcion !="4":
    print("Aquí podras verificas las calificaciones y estadisticas de los alumnos\n1.Promedio Grupal por modulo\n2.Diplomas\n3.Generar Reporte\n4.Salir\n")
    try:
        opcion = input("Selecciona tu opcion: ")
    except:
        opcion = input("Opcion invalida, vuelve a ingresarla: ")
    else:
        if opcion == "1":
            try:
                modulo = int(input("Elige un modulo de 1 a 4: "))
            except:
                modulo = int(input("Vuelva a ingresar un dato valido y rango (0,4)"))
            else:
                print(promedio_modulo(datos,modulo))
        elif opcion == "2":
            print("Los diplomas son: \n")
            diplomas(datos)
        elif opcion == "3":
            estado(datos)
            print("Se ha generado el reporte, consultalo en tu carpeta\n")
        elif opcion =="4":
            print("Saliendo...\n")
        else:
            print("Entrada Invalida\n")
    time.sleep(2)
