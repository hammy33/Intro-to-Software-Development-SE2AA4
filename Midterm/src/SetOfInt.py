## @file SetOfInt.py
#  @author Hamrish Saravanakumar
#  @brief Set of integers
#  @date 03/04/2021

class SetOfInt:

    def __init__(self, xs):
        self.s = set(xs)

    def is_member(self, x):
        count = 0
        for i in self.s:
            if i == x:
                count += 1
        if count >= 1:
            return True
        else:
            return False

    def to_seq(self):
        return self.__set_to_seq(self.s)
            
    def union(self, t):
        return SetOfInt(self.__set_to_seq(self.s) + t.__set_to_seq(t.s))

    def diff(self, t):
        return SetOfInt(self.__set_to_seq(self.s - set(t.to_seq())))

    def size(self):
        return len(self.s)

    def empty(self):
        return len(self.s) == 0

    def equals(self, t):
        return list(self.s) == list(t.to_seq())

    def __set_to_seq(self, s):
        sequence = []
        for i in self.s:
            sequence.append(i)
        return sequence






        
