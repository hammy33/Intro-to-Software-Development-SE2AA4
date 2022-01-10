## @file BodyT.py
#  @author Hamrish Saravanakumar
#  @brief Provides the BodyT ADT class that represents a sequence of masses in space
#  @date February 16 2021

from Shape import *

## @brief An abstract data type that represents a sequences of masses in space.
#  @details It is assumed that the arguments provided to the access programs will
#           be of the correct type.


class BodyT(Shape):
    ## @brief BodyT constructor.
    #  @details Initializes a BodyT object described by a center of mass and mass.
    #  @param Xs The x coordinate of the center of mass.
    #  @param Ys The y coordinate of the center of mass.
    #  @param Ms The mass of the circle.
    #  @throws A value error is thrown if the length of the three argument lists
    #          are not equal.
    #  @throws A value error is thrown if any value in the list of masses is less
    #          than or equal to zero.
    def __init__(self, Xs, Ys, Ms):
        if not (len(Xs) == len(Ys) == len(Ms)):
            raise ValueError
        for i in Ms:
            if i < 0:
                raise ValueError
        self.cmx = BodyT.__cm(Xs, Ms)
        self.cmy = BodyT.__cm(Ys, Ms)
        self.m = sum(Ms)
        value = self.cmx**2 + self.cmy**2
        self.moment = BodyT.__mmom(Xs, Ys, Ms) - (sum(Ms) * value)

    ## @brief Obtain value of x coordinate of center of mass.
    #  @return Value of x coordinate of center of mass.
    def cm_x(self):
        return self.cmx

    ## @brief Obtain value of y coordinate of center of mass.
    #  @return Value of y coordinate of center of mass.
    def cm_y(self):
        return self.cmy

    ## @brief Obtain value of mass.
    #  @return Value of mass.
    def mass(self):
        return self.m

    ## @brief Obtain value of moment of mass.
    #  @return Value of moment of mass.
    def m_inert(self):
        return self.moment

    @staticmethod
    def __cm(z, m):
        return sum([z[i] * m[i] for i in range(len(m))]) / sum(m)

    @staticmethod
    def __mmom(x, y, m):
        return sum([m[i] * (x[i]**2 + y[i]**2) for i in range(len(m))])
