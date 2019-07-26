



arr1 = [2,4,6,8]
arr2 = [1,3,5,7,9,10,11,12,13]
arr3 = []
def min_arr_length(arr1, arr2):
    return (arr1,arr2) if len(arr1) < len(arr2) else (arr2,arr1)

shortestArr = min_arr_length(arr1, arr2)

for i in range(len(shortestArr[0])):
    if(arr2[i] > arr1[i]):
        arr3.append(arr1[i])
        arr3.append(arr2[i])
    else:
        arr3.append(arr2[i])
        arr3.append(arr1[i])

arr3 += shortestArr[1][i:]

print(arr3)