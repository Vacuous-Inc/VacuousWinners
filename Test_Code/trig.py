'''
Lila
'''

def sqrt(x):
    return x**(1/2)

def hypotenuse(a, b):
    legs = (a**2) + (b**2)
    return legs**(1/2)

def deg_reduce(x):
    return x % 360