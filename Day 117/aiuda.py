# import datetime
# import random

# #!Cambiar el dia 
# def dia_Siguiente(str_fecha):
#     fecha=datetime.datetime.strptime(str_fecha,"%d/%m/%y")
#     siguiente=fecha + datetime.timedelta(days=1)
#     return siguiente.strftime("%d/%m/%y")


# #?Generar el archivo
# def genera_archivo(str_fecha):
#     fecha=str_fecha.replace("/","_")
#     try:
#         archivo=open("Datos_"+fecha+".csv","w",encoding="utf-8")
#     except:
#         print("Error al generar el archivo")
#     else:
#         archivo.write(f"Informe de líneas de producción 7 días con inicio el {str_fecha}\n")
#         for day in range(7):
#             for turno in range(1,4):
#                 for linea in range(1,4):
#                     productos = random.randint(200,500)
#                     detuvo = random.randint(0,10)
#                     tiempo = detuvo * random.randint(1,15)
#                     lista = []
#                     lista.append(str(linea))
#                     lista.append(str(turno))
#                     lista.append(str(str_fecha))
#                     lista.append(str(productos))
#                     lista.append(str(detuvo))
#                     lista.append(str(tiempo))
#                     wea = ','.join(lista)
#                     wea = wea + "\n"
#                     archivo.write(wea)
#             str_fecha = dia_Siguiente(str_fecha)           
#         archivo.close()
# def datos_Reporte(str_fecha):
#     fecha = str_fecha.replace("/", "_")
#     datos = [[0, 0, 0], [0, 0, 0], [0, 0, 0], 
#              [0, 0, 0],  [0, 0, 0], [0, 0, 0], 
#              [0, 0, 0],  [0, 0, 0], [0, 0, 0]]
#     try:
#         archivo = open("Datos_" + fecha + ".csv", "r", encoding="utf-8")
#     except FileNotFoundError:
#         print("Los archivos no se pueden accesar, intente más tarde.")
#     else:
       
#         for linea in archivo:
#             lineap = linea.rstrip()
#             lista = lineap.split(",")
#             cont = 0
#             for wea1 in range(3):
#                 for wea in range(3):                
#                         datos[cont][wea1] += int(lista[3])
#                         datos[cont][wea1] += int(lista[4])
#                         datos[cont][wea1] += int(lista[5])
#                         cont += 1
                
#         return datos


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
                renglon +=1
        archivo.close()

# #!Programa principal
# dia=input("Ingresa fecha en formato dia/mes/año: ")
# genera_archivo(dia)
# datos_Reporte(dia)
# print(datos_Reporte(dia))
# genera_reporte(datos_Reporte(dia),dia)







# x = list(filter(lambda x : x % 3 == 0, [1,2,3,4,5,6,7,8,9]))

# print(x)

import os


mainpath = "datasets/"
filename = "titanic/titanic3.csv"
fullpath = os.path.join(mainpath, filename)

print(fullpath)