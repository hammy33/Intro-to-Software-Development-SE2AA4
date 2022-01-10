## @file complex_adt.py
#  @author Laura Southwood (southwol)
#  @brief implements an Abstract Data Type for complex numbers
#  @date January 21, 2021

#Assume that all functions are passed the correct number of parameters
#Assume that all function are passed the correct data type of parameters
#Assume that .get_phi() is only ever executed on a nonzero ComplexT (since atan2(0,0) undefined)
#Assume that .recip() is only ever executed on a nonzero ComplexT (can't divide by 0)
#Assume that .div() is only ever used to divide by a nonzero ComplexT (can't divide by 0)

import math

## @brief An ADT for representing complex numbers
# @details A complex number is composed of a real and imaginary part
class ComplexT:

	## @brief Constructor for ComplexT
	# @details Creates a complex number with real and imaginary parts
	# @param x float representing the real part of the complex number
	# @param y float representing the imaginary part of the complex number
	def __init__(self, x, y):
		self.__x = x
		self.__y = y

	## @brief Getter for the real part (x) of the complex number
	# @return float representing the real part of the complex number
	def real(self):
		return self.__x

	## @brief Getter for the imaginary part (y) of the complex number
	# @return float representing the imaginary part of the complex number
	def imag(self):
		return self.__y

	## @brief Calculates the absolute value (also called modulus or magnitude)
	# @return float representing the absolute value of the complex number
	def get_r(self):
		return math.sqrt(self.__x**2 + self.__y**2)

	## @brief Calculates the phase (also called the argument)
	# @return float representing the phase of the complex number (in radians)
	def get_phi(self):
		return math.atan2(self.__y, self.__x)
		
	## @brief Checks if the two complex numbers (z and self) are equal
	# @param z ComplexT
	# @return boolean representing if z is equal to the current ComplexT object
	def equal(self, z):
		return self.__x == z.real()  and  self.__y == z.imag()

	## @brief Calculates the complex conjugate of the current ComplexT object
	# @return ComplexT representing the conjugate of the complex number
	def conj(self):
		return ComplexT(self.__x, -self.__y)
		
	## @brief Adds a complex number to the current ComplexT
	# @param z ComplexT
	# @return ComplexT representing the result of z added to the current object
	def add(self, z):
		a = self.__x + z.real()
		b = self.__y + z.imag()
		return ComplexT(a, b)

	## @brief Subtracts a complex number from the current ComplexT
	# @param z ComplexT
	# @return ComplexT representing the result of z subtracted from the current object
	def sub(self, z):
		a = self.__x - z.real()
		b = self.__y - z.imag()
		return ComplexT(a, b)

	## @brief Multiplies a complex number with the current ComplexT
	# @param z ComplexT
	# @return ComplexT representing the result of z multiplied with the current object
	def mult(self, z):
		u = z.real()
		v = z.imag()
		a = self.__x*u - self.__y*v
		b = self.__x*v + self.__y*u
		return ComplexT(a, b)

	## @brief Calculates the reciprocal of the current ComplexT object
	# @return ComplexT representing the reciprocal of the complex number
	def recip(self):
		denom = self.__x**2 + self.__y**2
		return ComplexT(self.__x/denom, -self.__y/denom)

	## @brief divides the current ComplexT by a complex number
	# @param z ComplexT
	# @return ComplexT representing the result of the current object divided by z
	def div(self, z):
		return self.mult(z.recip())

	## @brief Calculates the positive square root of the current ComplexT object
	# @return ComplexT representing the positive square root of the complex number
	def sqrt(self):
		if(self.__y == 0):
			return ComplexT(math.sqrt(self.__x), 0)

		mod = self.get_r()
		gamma = math.sqrt((self.__x + mod)/2)
		delta = math.sqrt((-self.__x + mod)/2)

		#Multiply delta by the sgn function.
		if(self.__y < 0):
			delta = -delta
		elif(self.__y == 0):
			delta = 0

		return ComplexT(gamma, delta)