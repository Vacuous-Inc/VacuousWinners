'''
Lila
'''
import math

radius = float(input("What's the radius? "))

def surface_area(radius):
    return 4*math.pi*radius**2


def volume(radius):
    return (4/3)*math.pi*radius**3

print(f"The surface area of the sphere is {surface_area(radius):.2f}")

print(f"The volume of the sphere is {volume(radius):.2f}")