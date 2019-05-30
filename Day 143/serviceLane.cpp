N, T = map(int, input().split())
widths = list(map(int, input().split()))
for _ in range(T):
    i, j = map(int, input().split())
    vehicle = 3
    for x in range(i, j+1):
        width = widths[x]
        if width == 1:
            vehicle = 1 # Only a bike can pass
            break
        elif width == 2:
            vehicle = 2 # Only a car or bike can pass
    print(vehicle)