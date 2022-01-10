## @file TriangleT.py
#  @author Laura Southwood (MacId: southwol)
#  @brief implements an ADT for triangles
#  @date February 16, 2021

from Shape import Shape


## @brief TriangleT is used to represent a triangle shape
## @details triangles have an (x,y) coordinate, side length (equilateral), and mass
# This module assumes that arguments provided to access programs are correct type
class TriangleT(Shape):

    ## @brief constructor for TriangleT class
    # @details a triangle's x,y coordinates refer to its center.
    # this method raises a ValueError if ss <= 0 or if ms <= 0
    # @param xs a real number (int or float) representing the x location
    # @param ys a real number (int or float) representing the y location
    # @param ss a real number (int or float) representing the side length (all 3 same)
    # @param ms a real number (int or float) representing the mass
    def __init__(self, xs, ys, ss, ms):
        if not(ss > 0 and ms > 0):
            raise ValueError
        self.x = xs
        self.y = ys
        self.s = ss
        self.m = ms

    ## @brief a method for getting the center of mass x location
    # @return a real number (int or float), the x coordinate of the center of mass
    def cm_x(self):
        return self.x

    ## @brief a method for getting the center of mass y location
    # @return a real number (int or float), the y coordinate of the center of mass
    def cm_y(self):
        return self.y

    ## @brief a method for getting the mass of the triangle
    # @return a real number (int or float), the mass of the triangle
    def mass(self):
        return self.m

    ## @brief a method for getting moment of inertia of the triangle
    # @return a real number (int or float), the moment of inertia of the triangle
    def m_inert(self):
        return (self.m * (self.s**2)) / 12
