


def pagesNumberingWithInk(current, numberOfDigits):
    i = len(str(current))
    while i < numberOfDigits:
        numeroActual = current+1
        i += len(str(numeroActual))
    return numeroActual




print(pagesNumberingWithInk(1,5))