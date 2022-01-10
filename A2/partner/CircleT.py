## @file CircleT.py
#  @author Laura Southwood (MacId: southwol)
#  @brief implements an ADT for circles
#  @date February 16, 2021

from Shape import Shape


## @brief CircleT is used to represent a circle shape
## @details circles have an (x,y) coordinate, radius, and mass.
# This module assumes that arguments provided to access programs are correct type
class CircleT(Shape):

    ## @brief constructor for CircleT class
    # @details a circle's x,y coordinates refer to its center.
    # this method raises a ValueError if rs <= 0 or if ms <= 0
    # @param xs a real number (int or float) representing the x location
    # @param ys a real number (int or float) representing the y location
    # @param rs a real number (int or float) representing the radius
    # @param ms a real number (int or float) representing the mass
    def __init__(self, xs, ys, rs, ms):
        if not(rs > 0 and ms > 0):
            raise ValueError
        self.x = xs
        self.y = ys
        self.r = rs
        self.m = ms

    ## @brief a method for getting the center of mass x location
    # @return a real number (int or float), the x coordinate of the center of mass
    def cm_x(self):
        return self.x

    ## @brief a method for getting the center of mass y location
    # @return a real number (int or float), the y coordinate of the center of mass
    def cm_y(self):
        return self.y

    ## @brief a method for getting the mass of the circle
    # @return a real number (int or float), the mass of the circle
    def mass(self):
        return self.m

    ## @brief a method for getting moment of inertia of the circle
    # @return a real number (int or float), the moment of inertia of the circle
    def m_inert(self):
        return (self.m * (self.r**2)) / 2
