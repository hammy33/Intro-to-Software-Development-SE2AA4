## @file SeqServicesLibrary.py
#  @author Hamrish Saravanakumar
#  @brief Library module that provides functions for working with sequences
#  @details This library assumes that all functions will be provided with arguments of the expected types
#  @date 03/04/2021


def max_val(s):
    if len(s) == 0:
        raise ValueError
    maximum = 0
    for i in s:
        if abs(i) >= abs(maximum):
            maximum = i
    return abs(maximum)

def count(t, s):
    if len(s) == 0:
        raise ValueError
    count = 0
    for i in s:
        if i == t:
            count = count + 1
    return count

def spices(s):
    if len(s) == 0:
        raise ValueError
    sequence = []
    for i in s:
        if i <= 0:
            sequence.append("nutmeg")
        else:
            sequence.append("ginger")
    return sequence

def new_max_val(s,f):
    if len(s) == 0:
        raise ValueError
    new = []
    for i in s:
        if f(i):
            new.append(i) 
    return max_val(new)

    
        
            
