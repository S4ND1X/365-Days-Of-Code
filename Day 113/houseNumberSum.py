



def houseNumbersSum(inputArray):
        resultado = 0
        for i in range(len(inputArray)):
                if inputArray[i] == 0:
                        break
                else:
                        resultado += inputArray[i]
                        
        return resultado 


print(houseNumbersSum([5, 1, 2, 3, 0, 1, 5, 0, 2]))