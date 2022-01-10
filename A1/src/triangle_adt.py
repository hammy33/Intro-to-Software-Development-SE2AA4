## @file triangle_adt.py
#  @author Hamrish Saravanakumar
#  @brief TriangleT ADT class
#  @date 1/21/2020

import math
from enum import Enum

## @brief An enumerated classused to sort through a set of potential types of triangles.
class TriType(Enum):
    ## List of types of triangles as provided in assignment documentation.
    types = ["equilat", "isosceles", "scalene", "right"]
    ## enum value representing a triangle with 3 equivalent side lengths.
    equilat = types[0]
    ## enum value representing a triangle with 2 equivalent side lengths.
    isosceles = types[1]
    ## enum value representing a triangle with no equivalent side lengths.
    scalene = types[2]
    ## enum value representing a triangle that has a 90 degree angle.
    right = types[3]
    
## @brief An ADT class that represents a Triangle.
class TriangleT:

    ## @brief TriangleT constructor.
    #  @details Initializes a TriangleT object with three defined side lengths.
    #  @param side1 The length of the first side of the triangle.
    #  @param side2 The length of the second side of the triangle.
    #  @param side3 The length of the third side of the triangle.
    def __init__(self, side1, side2, side3):
        self.__side1 = side1
        self.__side2 = side2
        self.__side3 = side3
            
    ## @brief Gets the the lengths of all three sides
    #  @return A tuple of the 3 lengths of the sides of the triangle     
    def get_sides(self):
        if (TriangleT.is_valid(self)):
            return self.__side1, self.__side2, self.__side3
        else:
            return None
    ## @brief Determines if the current triangle is equal to the argument triangle. 
    #  @details A private method "__eq__" is used to support the "equal" method.
    #  @param other The second triangle that is compared to the current triangle.
    #  @return Returns the output of the __eq__ method.
    def equal(self, other):
        return TriangleT.__eq__(self, other)

    ## @brief A private method "__eq__" that is used to support the "equal" method. 
    #  @details Magic method used to aid in determining if the triangle is equal to the argument triangle.
    #  @param other The second triangle that is compared to the current triangle.
    #  @return Returns true if the two triangles are equal; false if the two triangles are not equal;
    #          and returns None if either of the triangles are not valid.
    def __eq__(self, other):
        if TriangleT.get_sides(self) == None or TriangleT.get_sides(other) == None:
            return None
        count = 0
        for i in TriangleT.get_sides(self):
            for j in TriangleT.get_sides(other):
                if(i == j):
                    count = count + 1
                    break
        if(count == 3):
            return True
        return False

    ## @brief Calculates the perimeter of the triangle.
    #  @return The perimeter of the triangle, and returns None if the triangle is invalid.
    def perim(self):
        if (TriangleT.is_valid(self)):
            return self.__side1 + self.__side2 + self.__side3
        else:
            return None

    ## @brief Calculates the area of the triangle.
    #  @details Heron's Formula was used to determine the area of the triangle.
    #           https://www.mathopenref.com/heronsformula.html
    #  @return The area of the triangle, and returns None if the triangle is not valid.      
    def area(self):
        p = (self.__side1 + self.__side2 + self.__side3) / 2
        a = p - self.__side1
        b = p - self.__side2
        c = p - self.__side3
        if (TriangleT.is_valid(self)):
            return math.sqrt(p * a * b * c)
        else:
            return None

    ## @brief Determines if the side lengths are able to create a valid triangle.
    #  @details Method of determining the validity of a triangle
    #           https://www.wikihow.com/Determine-if-Three-Side-Lengths-Are-a-Triangle
    #  @return Returns true if a triangle is valid, and returns false if the triangle is invalid.
    def is_valid(self):
        a = self.__side1
        b = self.__side2
        c = self.__side3
        if (a + b <= c) or (a + c <= b) or (b + c <= a) : 
            return False
        elif (isinstance(a,int) == False or isinstance(b,int) == False or isinstance(c,int) == False):
            return False
        else: 
            return True

    ## @brief Determines the type of triangle
    #  @details A triangle that fits the requirements of a right triangle and a second
    #           type is assumed to only have the type "right".
    #  @return Returns the triangle type and returns None if the triangle is not valid. 
    def tri_type(self):
        a = self.__side1
        b = self.__side2
        c = self.__side3
        if(TriangleT.is_valid(self) == False):
            return None
        elif max(a**2, b**2, c**2) == (a**2 + b**2 + c**2 - max(a**2, b**2, c**2)):
            return TriType.right
        elif a==b and b==c:
            return TriType.equilat
        elif a==b or b==c or a==c:
            return TriType.isosceles
        else:
            return TriType.scalene





    
        
