## @file triangle_adt.py
#  @author Laura Southwood (southwol)
#  @brief implements an ADT for triangles
#  @date January 21, 2021

#Assume that all functions are passed the correct number of parameters
#Assume that all function are passed the correct data type of parameters

import math
from enum import Enum

## @brief An ADT for representing triangles
# @details A triangle is composed of 3 side lengths
class TriangleT:

	## @brief Constructor for TriangleT
	# @details Creates a triangle with 3 side lengths
	# @param x Integer first side length
	# @param y Integer second side length
	# @param z Integer third side length
	def __init__(self, x, y, z):
		self.__x = x
		self.__y = y
		self.__z = z

	## @brief Gets the side lengths of the current triangle object
	# @return tuple of 3 integers containing the side lengths of the triangle
	def get_sides(self):
		return (self.__x, self.__y, self.__z)

	## @brief Checks if tri is equal to the current TriangleT
	# @details The triangles are equal if they have the same 3 side lengths (in any order)
	# @param tri TriangleT
	# @return True if the current obj is equal to tri, False otherwise
	def equal(self, tri):
		t1 = tri.get_sides()
		if(t1 == (self.__x, self.__y, self.__z) or t1 == (self.__x, self.__z, self.__y)):
			return True
		elif(t1 == (self.__y, self.__x, self.__z) or t1 == (self.__z, self.__x, self.__y)):
			return True
		elif(t1 == (self.__z, self.__y, self.__x) or t1 == (self.__y, self.__z, self.__x)):
			return True
		return False 

	## @brief Calculates the perimeter of the triangle
	# @return Integer representing the perimeter of the current TriangleT
	def perim(self):
		return self.__x + self.__y + self.__z

	## @brief Calculates the area of the triangle using Heron's Formula
	# @return float representing the area of the current TriangleT
	def area(self):
		p = self.perim()/2
		return math.sqrt(p*(p-self.__x)*(p-self.__y)*(p-self.__z))

	## @brief Checks that the 3 sides of the current object form a valid triangle
	# @return True if the triangle is valid, False otherwise
	def is_valid(self):
		return self.__x + self.__y > self.__z and self.__x + self.__z > self.__y and self.__y + self.__z > self.__x

	## @brief Classifies the type of the current TriangleT object
	# @return A TriType representing the type of the current TriangleT object 
	def tri_type(self):
		if(self.__x == self.__y and self.__y == self.__z):
			return TriType(1)#equilat
		elif(self.__x == self.__y  or  self.__x == self.__z  or  self.__y == self.__z):
			return TriType(2)#isosceles
		elif(self.__x**2+self.__y**2==self.__z**2  or  self.__x**2+self.__z**2==self.__y**2  or  self.__y**2+self.__z**2==self.__x**2):
			return TriType(4)#right
		else:
			return TriType(3)#scalene


## @brief An enumerated set {equilat, isosceles, scalene, right}
# @details Used to classify the type of a TriangleT object
class TriType(Enum):
	equilat = 1
	isosceles = 2
	scalene = 3
	right = 4