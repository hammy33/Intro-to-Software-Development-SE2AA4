## @file BodyT.py
#  @author Laura Southwood (MacId: southwol)
#  @brief implements an ADT for other shapes (bodies)
#  @date February 16, 2021

from Shape import Shape


## @brief BodyT is used to represent a shape made up of point masses
## @details it will have a calculated (x,y) coordinate for center of mass,
# as well as an overall mass and a moment of inertia.
# This module assumes that arguments provided to access programs are correct type
class BodyT(Shape):

    ## @brief constructor for BodyT class
    # @details State variables are calcualted from sequences of point masses.
    # This method raises a ValueError if the sequences differ in length,
    # or if any mass values in the sequence are <= 0. This ensures the state invariant
    # @param xs a sequence of real numbers (int or float) representing x locations
    # @param ys a sequence of real numbers (int or float) representing y locations
    # @param ms a sequence of real numbers (int or float) representing masses of points
    def __init__(self, xs, ys, ms):
        if not(len(xs) == len(ys) and len(ys) == len(ms)):
            raise ValueError
        for miu in ms:
            if not miu > 0:
                raise ValueError
        self.cmx = self.cm(xs, ms)
        self.cmy = self.cm(ys, ms)
        self.m = self.sum(ms)
        mmom = self.mmom(xs, ys, ms)
        self.moment = mmom - self.sum(ms) * (self.cm(xs, ms)**2 + self.cm(ys, ms)**2)
        if not self.moment >= 0:
            raise ValueError

    ## @brief a method for getting the center of mass x location
    # @return a real number (int or float), the x coordinate of the center of mass
    def cm_x(self):
        return self.cmx

    ## @brief a method for getting the center of mass y location
    # @return a real number (int or float), the y coordinate of the center of mass
    def cm_y(self):
        return self.cmy

    ## @brief a method for getting the mass of the body
    # @return a real number (int or float), the mass of the body
    def mass(self):
        return self.m

    ## @brief a method for getting moment of inertia of the body
    # @return a real number (int or float), the moment of inertia of the body
    def m_inert(self):
        return self.moment

    ## @brief a method for calculating the sum of all elements in a given list
    # @param ms a sequence of real numbers (int or float) to be added together
    # @return a real number (int or float), the sum of all elements in list
    def sum(self, ms):
        total = 0
        for miu in ms:
            total += miu
        return total

    ## @brief a method for calculating the center of mass in 1 dimension
    # @param z a sequence of real numbers (int or float) of locations
    # @param m a sequence of real numbers (int or float) of masses
    # @return a real number (int or float), the center of mass in the z dimension
    def cm(self, z, m):
        total = 0
        for i in range(len(m)):
            total += z[i] * m[i]
        return total / self.sum(m)

    ## @brief a method for calculating the sum of all point mass moment of inertia
    # @param x a sequence of real numbers (int or float) of x locations
    # @param y a sequence of real numbers (int or float) of y locations
    # @param m a sequence of real numbers (int or float) of masses
    # @return a real number (int or float), the sum of all point mass moments of inertia
    def mmom(self, x, y, m):
        total = 0
        for i in range(len(m)):
            total += m[i] * (x[i]**2 + y[i]**2)
        return total
