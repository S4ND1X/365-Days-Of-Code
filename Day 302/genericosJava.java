public <ArrayType> void printAnyArray(ArrayType [] array) {
    StringBuilder arrayPrintString = new StringBuilder("Array: ");
    if (array != null && array.length != 0) {
        for (ArrayType printObject : array) {
            arrayPrintString
                .append(printObject)
                .append("|");
        }
    } else {
        arrayPrintString.append("Empty Array");
    }
    System.out.println(arrayPrintString);
}