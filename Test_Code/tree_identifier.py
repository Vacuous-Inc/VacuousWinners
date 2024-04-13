'''Player1'''
'''
Lila
'''

first = input("Does it have leaves or needles? l or n: ")

if(first.lower() == "n"):
    second = input("Are needles individual or clustered? i or c: ")
    
    if(second.lower() == "i"):
        print("Spruce")
        
    elif(second.lower() == "c"):
        print("Pine")
        
    else:
        print("Invalid choice for individual or clustered!")
        
elif(first.lower() == "l"):
    third = input("Are leaves simple or compound? s or c: ")
    
    if(third.lower() == "s"):
        print("Maple")
        
    elif(third.lower() == "c"):
        print("Ash")
        
    else:
        print("Invalid choice for simple or compound!")
    
else:
    print("Invalid choice for leaves!")
