#Input
A lot of the time, we need to ask the user for a value in order to correctly run our code. This is very easy with Python, with the funciton *input()*, which takes a string as an argument.
For example:
name = input("What is your name?")
would output:
What is your name? 
I would then write
What is your name? Vacuous Winners
and *name* would now hold the value "Vacuous Winners"

But we don't always want our input to be a string. In that case, we can cast the variable to be other types. int() turns the value to an int, float() turns the value into a float, etc. Thus, if we wanted to ask the user for how many pets they have, we could write:
int(input("How many pets do you have? "))

#Math Class
Sometimes you need to use more complicated equations, such as pi. In the last excersise, we had you made a sqrt(x) function. However, that was already possible through the *math* class.

Math Class Functions:
math.pi
- returns value of pi
math.sqrt(x)
- returns square root of x
math.pow(x, y)
- returns x to the power of y

In order to use this class, however, you need to import the *math* class. To do this, all you need to write is:
import math
so make sure to do this before any programs that use a *math* function!

#F-Strings
Occasionally, we need to format our output in a specific way, such as centering it, or rounding values, or just adding variables to out print() statements.
This is where f-strings come in, written print(f""). They are almost identical to print statements, but you write your output within the quotations.
For example:
print(f"Here's an example of a boring f-string!")

But most of the time, we use f-strings to add variables to our output. In order to do that, we put the variable of note within curly brackets. Let's say we want to print what the value of *x* is. In that case, we would code:
print(f"The value of x is: {x}")

Furthermore, we can use f-strings to format our variables and output. After our variable name, but still within the curly brackets, we can add a format specifier. You only need to know one for this excersise: rounding. Let's say we want to round x to 2 decimal places. In that case, we would code:
print(f"The value of x is: {x:.2f}")
with *.2f* being the fomat specifier (2 = number of decimal places) and *:* telling Python that a format specifier is being used.

Other Types of Format Specifiers:
< --> align left
> --> align right
% --> percentage
, --> thousand separators
E --> scientific notation

##Try it Yourself!
Create two functions, surface_area(radius), and volume(radius). surface_area(radius) should return the surface area of the sphere (4*pi*radius^2). volume(radius) should return the volume of the sphere ((4/3)*pi*radius^3). Then, outside the functions, ask the user to input the radius of the sphere. Then you should print out both the surface area and volume, using this format:
"The surface area of the sphere is 12.00"
"The volume of the sphere is 24.00"

Remember to round your values to 2 decimal places!