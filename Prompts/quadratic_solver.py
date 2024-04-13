'''
Lila
'''

import math


def calc_discriminant(a, b, c):
    first = b ** 2
    second = 4 * a * c
    return first - second

if __name__ == '__main__':
    a = float(input("Enter a value for a: "))

    b = float(input("Enter a value for b: "))

    c = float(input("Enter a value for c: "))

    if(calc_discriminant(a, b, c) == 0):
        print("There is one real root the this equation: " +
              f"{( - b ) / (2 * a):.3f}")

    elif(calc_discriminant(a, b, c) > 0):
        answer_one = (- b) + math.sqrt(calc_discriminant(a, b, c))
    
        answer_one = answer_one / (2 * a)
    
        answer_two = (- b) - math.sqrt(calc_discriminant(a, b, c))
    
        answer_two = answer_two / (2 * a)
    
        print("The two roots of the equation are " +
              f"{answer_one:.3f} and {answer_two:.3f}")

    else:
        print("There are no real roots to this equation.")