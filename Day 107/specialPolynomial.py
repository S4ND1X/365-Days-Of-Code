def specialPolynomial(x, n):
    s = 0
    for k in range(1000):
        s += math.pow(x, k)
        if s > n:
            return k - 1