array = [50, 60, 60, 45, 70]
sumas  = [0,0]
for index ,item in enumerate(array):
    if index % 2 == 0:
        sumas[0] += item
    else:
        sumas[1] += item
print (sumas)