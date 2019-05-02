import datetime
import random

#!Cambiar el dia 
def dia_Siguiente(str_fecha):
    fecha=datetime.datetime.strptime(str_fecha,"%d/%m/%y")
    siguiente=fecha + datetime.timedelta(days=1)
    return siguiente.strftime("%d/%m/%y")


#?Generar el archivo
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
                    lista.append(str(dia))
                    lista.append(str(productos))
                    lista.append(str(detuvo))
                    lista.append(str(tiempo))
                    wea = ','.join(lista)
                    wea = wea + "\n"
                    archivo.write(wea)
            dia_Siguiente(dia)
        archivo.close()

#!Programa principal
dia=input("Ingresa fecha en formato dia/mes/año: ")
genera_archivo(dia)













