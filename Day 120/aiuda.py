import datetime
import random

#PARTE 1, OBETENER DATOS DE LA SEMANA
#Cambiar el dia
def dia_Siguiente(str_fecha):
    fecha = datetime.datetime.strptime(str_fecha,"%d/%m/%Y")
    siguiente = fecha + datetime.timedelta(days=1)
    return siguiente.strftime("%d/%m/%Y")


#Generar el archivo
def genera_archivo(str_fecha):
    fecha=str_fecha.replace("/","_")
    try:
        archivo=open("Datos_"+fecha+".csv","w",encoding="utf-8")
    except:
        print("Error al generar el archivo")
    else:
        archivo.write(f"Informe de líneas de producción 7 días con inicio el {str_fecha}\n")
        for day in range(7):
            for turno in range(1,4):
                for linea in range(1,4):
                    productos = random.randint(200,500)
                    detuvo = random.randint(0,10)
                    tiempo = detuvo * random.randint(1,15)
                    lista = []
                    lista.append(str(linea))
                    lista.append(str(turno))
                    lista.append(str(str_fecha))
                    lista.append(str(productos))
                    lista.append(str(detuvo))
                    lista.append(str(tiempo))
                    wea = ','.join(lista)
                    wea = wea + "\n"
                    archivo.write(wea)
            str_fecha = dia_Siguiente(str_fecha)
        archivo.close()
#PARTE 2, RESUMEN/REPORTE SEMANAL
def datos_Reporte(str_fecha):
    fecha = str_fecha.replace("/", "_")
    datos = [[0, 0, 0], [0, 0, 0], [0, 0, 0], [0, 0, 0], [0, 0, 0], [0, 0, 0], [0, 0, 0], [0, 0, 0], [0, 0, 0]]
    try:
        archivo = open("Datos_" + fecha + ".csv", "r", encoding="utf-8")
    except FileNotFoundError:
        print("Los archivos no se pueden accesar, intente más tarde.")
    else:
        archivo.readline()
        for linea in archivo:
            lineap = linea.rstrip()
            lista = lineap.split(",")
            if lista[0]=="1" and lista[1]=="1":
                datos[0][0]+= int(lista[3])
                datos[0][1]+= int(lista[4])
                datos[0][2]+= int(lista[5])
            elif lista[0]=="2" and lista[1]=="1":
                datos[1][0]+= int(lista[3])
                datos[1][1]+= int(lista[4])
                datos[1][2]+= int(lista[5])
            elif lista[0]=="3" and lista[1]=="1":
                datos[2][0]+= int(lista[3])
                datos[2][1]+= int(lista[4])
                datos[2][2]+= int(lista[5])
            elif lista[0]=="1" and lista[1]=="2":
                datos[3][0]+= int(lista[3])
                datos[3][1]+= int(lista[4])
                datos[3][2]+= int(lista[5])
            elif lista[0]=="2" and lista[1]=="2":
                datos[4][0]+= int(lista[3])
                datos[4][1]+= int(lista[4])
                datos[4][2]+= int(lista[5])
            elif lista[0]=="3" and lista[1]=="2":
                datos[5][0]+= int(lista[3])
                datos[5][1]+= int(lista[4])
                datos[5][2]+= int(lista[5])
            elif lista[0]=="1" and lista[1]=="3":
                datos[6][0]+= int(lista[3])
                datos[6][1]+= int(lista[4])
                datos[6][2]+= int(lista[5])
            elif lista[0]=="2" and lista[1]=="3":
                datos[7][0]+= int(lista[3])
                datos[7][1]+= int(lista[4])
                datos[7][2]+= int(lista[5])
            elif lista[0]=="3" and lista[1]=="3":
                datos[8][0]+= int(lista[3])
                datos[8][1]+= int(lista[4])
                datos[8][2]+= int(lista[5])
    return datos

def genera_reporte(datos, str_fecha):
    fecha = str_fecha.replace("/", "_")
    try:
        archivo = open("Reporte_" + fecha + ".txt", "w", encoding="utf-8")
    except IOError:
        print("Los archivos no se pueden accesar, intente más tarde.")
    else:
        archivo.write(f"Reporte 7 días con fecha de inicio: {str_fecha}\n\n")
        renglon = 0
        for turno in range(3):
            for linea in range(3):
                archivo.write(f"\tLínea:{linea + 1}\n")
                archivo.write(f"\tTurno:{turno + 1}\n")
                archivo.write(f"\tTotal productos: {datos[renglon][0]}\n")
                archivo.write(f"\tVeces detenida: {datos[renglon][1]}\n")
                archivo.write(f"\tTiempo total detenida: {datos[renglon][2]}\n")
                renglon+=1
        archivo.close()


def menu():
    print(""">>>>>>>>>>>>>>>>>>>>>>>MENÚ<<<<<<<<<<<<<<<<<<<<<<<<<
              1.Informe de líneas de producción
              2.Reporte semanal por linea y turno
              3.Consultas parciales
              4.Estadísticas
              5.Salir
              >>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<""")
    opcion=input("Ingrese opción deseada: ")
    return opcion







def reporteSemana(lineaU,turnoU):
    with open('Datos_23_02_2018.csv','r') as file:
        productosTotales = 0
        vecesQueSeDetuvo = 0
        tiempoTotal = 0          
        lista = []
        lista2 = [] 
        for linea in file:
            lineaA = linea.replace(","," ")
            lineaB = lineaA.split(" ")
            if lineaB[0] == lineaU and lineaB[1] == turnoU:
                productosTotales += int(lineaB[3])
                vecesQueSeDetuvo += int(lineaB[4])
                tiempoTotal += int(lineaB[5])
            if lineaB[1] == lineaU:
                lista.append(int(lineaB[4]))
        suma1 = 0
        suma2 = 0
        suma3 = 0
        suma4 = 0
        suma5 = 0
        suma6 = 0
        suma7 = 0 
        suma1 += lista[0] + lista[1] + lista[2]
        suma2 += lista[3] + lista[4] + lista[5]
        suma3 += lista[6] + lista[7] + lista[8]
        suma4 += lista[9] + lista[10] + lista[11]
        suma5 += lista[12] + lista[13] + lista[14]
        suma6 += lista[15] + lista[16] + lista[17]
        suma7 += lista[18] + lista[19] + lista[20]
        lista2.append(suma1)
        lista2.append(suma2)
        lista2.append(suma3)
        lista2.append(suma4)
        lista2.append(suma5)
        lista2.append(suma6)
        lista2.append(suma7)
        dia = lista2.index(max(lista2)) + 1 
        print(f"Línea:{lineaU}\nTurno:{turnoU}\nTotal Productos Semanales:{productosTotales}\nVeces Detenidas Por Linea:{vecesQueSeDetuvo}\nTiempo Total Detenido:{tiempoTotal}\nDía Con Más Veces Detenidas:{dia}")
        return tiempoTotal, productosTotales
        


def estadisticas(tiempoDetenido,productosFabricados):

    productividad = round(((8-(tiempoDetenido/60))/8) * (productosFabricados/500),2)
    return productividad


#Programa principal
print("BIENVENIDO AL SISTEMA DE XETUCAR")
dia=input("Ingresa fecha en formato dia/mes/año: ")
genera_archivo(dia)
genera_reporte(datos_Reporte(dia),dia)
opcion = "1"
while opcion !="3":
    print("Elige una opcion\n1:Reporte de semana\n2.)Estadisticas")
    opcion = input("Opcion: ")
    linea = input("Dame una linea: ")
    turno = input("Dame un turno: ")
    if opcion == "1":
        reporteSemana(linea,turno)
    elif opcion =="2":
        a,b = reporteSemana(linea,turno)
        print(f"La productividad es de :{estadisticas(a,b)}")
    elif opcion == "3":
        print("Adios xd")










