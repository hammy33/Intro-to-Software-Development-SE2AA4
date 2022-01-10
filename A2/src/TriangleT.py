## @file TriangleT.py
#  @author Hamrish Saravanakumar
#  @brief Provides the TriangleT ADT class that represents a triangle
#  @date February 16 2021

from Shape import *

## @brief An abstract data type that represents a triangle.
#  @details It is assumed that the arguments provided to the access programs will
#           be of the correct type.


class TriangleT(Shape):

    ## @brief TriangleT constructor.
    #  @details Initializes a TriangleT object using a center of mass,
    #           the side length, and mass.
    #  @param Xs The x coordinate of the center of mass.
    #  @param Ys The y coordinate of the center of mass.
    #  @param Ss The side length of the triangle.
    #  @param Ms The mass of the triangle.
    #  @throws A value error is thrown if the side length or mass are less
    #          than or equal to zero.
    def __init__(self, Xs, Ys, Ss, Ms):
        if Ss <= 0 or Ms <= 0:
            raise ValueError
        self.x = Xs
        self.y = Ys
        self.s = Ss
        self.m = Ms

    ## @brief Obtain value of x coordinate of center of mass.
    #  @return Value of x coordinate of center of mass.
    def cm_x(self):
        return self.x

    ## @brief Obtain value of y coordinate of center of mass.
    #  @return Value of y coordinate of center of mass.
    def cm_y(self):
        return self.y

    ## @brief Obtain value of mass.
    #  @return Value of mass.
    def mass(self):
        return self.m

    ## @brief Obtain value of moment of inertia.
    #  @return Value of moment of intertia.
    def m_inert(self):
        return (self.m * (self.s**2)) / 12
