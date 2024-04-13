'''
Lila
'''

def next_recaman(lst):
    if (not lst) or (len(lst) == 1):
        return 0
    if (lst[-1] - len(lst) > 0) and (lst[-1] - len(lst) not in lst):
        return lst[-1] - len(lst)    
    return lst[-1] + len(lst)