'''
Lila
'''

def balanced(s):
    stack = []
    
    for letter in s:
        if letter == "(":
            stack.append(letter)
        elif letter == ")":
            if stack:
                stack.pop()
            else:
                return False
    
    return len(stack) == 0

if __name__ == '__main__':
    s = input("Enter a string containing parentheses: ")

    if balanced(s):
        print("Parentheses are balanced!")
    
    else:
        print("Parentheses are not balanced!")