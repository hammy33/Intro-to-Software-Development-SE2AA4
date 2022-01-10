## @file complex_adt.py
#  @author Hamrish Saravanakumar
#  @brief ComplexT ADT Class  
#  @date 21/01/2020

import math

## @brief An ADT class that represents a complex number.
#  @details Formulas are all based on Complex Numbers Wikepedia Page
#           https://en.wikipedia.org/wiki/Complex_number
class ComplexT:

    ## @brief ComplexT constructor
    #  @details Initializes a ComplexT object that takes two floats that represents the
    #           real and imaginary part of the complex number.
    #  @param x The real part of the complex number.
    #  @param y The imaginary part of the complex number.
    def __init__(self, x, y):
        self.__x = x
        self.__y = y
        
    ## @brief Gets the real part of the complex number.
    #  @return The real part of the complex number.
    def real(self):
        return self.__x

    ## @brief Gets the imaginary part of the complex number.
    #  @return The imaginary part of the complex number.
    def imag(self):
        return self.__y

    ## @brief Calculates the absolute value of the complex number.
    #  @return The absolute value of the complex number.
    def get_r(self):
        return math.sqrt(self.__x**2 + self.__y**2)

    ## @brief Calculates the argument of the complex number.
    #  @return The argument of the complex number, and returns None if the argument is undefined.
    def get_phi(self):
        absolute = math.sqrt(self.__x**2 + self.__y**2)
        if(self.__y != 0):
            return 2*math.atan(self.__y / (absolute + self.__x))
        elif(self.__x < 0 and self.__y == 0):
            return pi
        else:
            return None

    ## @brief Determines if the current complex number is equal to the argument complex number. 
    #  @details A private method "__eq__" is used to support the "equal" method.
    #  @param other The second complex number that is compared to the current complex number.
    #  @return Returns the output of the __eq__ method.
    def equal(self, other):
        return ComplexT.__eq__(self, other)

    ## @brief A private method "__eq__" that is used to support the "equal" method.
    #  @details Magic method used to aid in determining if the current complex number is equal to the argument complex number. 
    #  @param other The second complex number that is compared to the current complex number.
    #  @return Returns true if the two complex numbers are equal; false if the two complex numbers are not equal
    def __eq__(self, other):
        return self.__x == other.__x and self.__y == other.__y

    ## @brief Calculates the complex conjugate of the complex number.
    #  @return The complex conjugate of the complex number.
    def conj(self):
        return ComplexT(self.__x, -(self.__y))

    ## @brief Calculates the sum of the current and argument complex numbers.
    #  @param other second complex number to add to current complex number.
    #  @return The sum of the two complex numbers.
    def add(self, other):
        return ComplexT(self.__x + other.__x, self.__y + other.__y)

    ## @brief Calculates the difference of the argument complex number from the current complex number.
    #  @param other second complex number to subtract from first complex number
    #  @return The difference between the two complex numbers
    def sub(self, other):
        return ComplexT(self.__x - other.__x, self.__y - other.__y)

    ## @brief Calculates the product of the argument and current complex numbers.
    #  @param other second complex number to multiply to the first complex number.
    #  @return The product of the two complex numbers.
    def mult(self, other):
        return ComplexT(self.__x*other.__x - self.__y*other.__y, self.__y*other.__x + self.__x*other.__y)

    ## @brief Calculates the reciprocal of the complex number.
    #  @details Complex number must be non-zero
    #  @return The reciprocal of the complex number, and returns None if the complex number is zero.
    def recip(self):
        absolute = self.__x**2 + self.__y**2
        if absolute == 0:
            return None
        return ComplexT(self.__x / absolute, -(self.__y / absolute))

    ## @brief Calculates the quotient of the argument complex number divided by the current complex number.
    #  @details Complex number must be non-zero.
    #  @param other second complex number that divides the first complex number.
    #  @return The quotient of two complex numbers, and returns None if the complex number is zero.
    def div(self, other):
        magnitude = float(other.__x**2 + other.__y**2)
        if magnitude == 0:
            return None
        return ComplexT((self.__x*other.__x + self.__y*other.__y) / magnitude, (self.__y*other.__x - self.__x*other.__y) / magnitude)

    ## @brief Calculates the square root of the complex number
    #  @return The square root of the complex number
    def sqrt(self):
        modulus = math.sqrt(self.__y**2 + self.__x**2)
        a = math.sqrt((self.__x + modulus)/2)
        if self.__y == 0:
            b = 0.0
        elif self.__y > 0:
            b = math.sqrt((-self.__x + modulus)/2)
        else:
            b = -(math.sqrt((-self.__x + modulus)/2))
        return ComplexT(a, b)
    
