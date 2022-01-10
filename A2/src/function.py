def remove_uppercase(a):
    new = ""
    for i in a:
        if i.islower():
            new += i
    return new
a = "abCd"
print(remove_uppercase(a))
