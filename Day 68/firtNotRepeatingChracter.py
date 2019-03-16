def fn(s):
    order = []
    counts = {}
    for x in s:
        if x in counts:
            counts[x] += 1
        else:
            counts[x] = 1 
            order.append(x)
    for x in order:
        if counts[x] == 1:
            return x
    return "_"






