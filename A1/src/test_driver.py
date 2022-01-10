## @file test_driver.py
#  @author Hamrish Saravanakumar
#  @brief Test driver for python modules triangle_adt.py and complex_adt.py
#  @date 1/21/2021

from complex_adt import ComplexT
from triangle_adt import TriangleT, TriType
import math
import cmath

print("Test cases for ComplexT Module:".center(50, '-'))
print(" ")

## Complex numbers of type ComplexT used in test cases for every method in
#  complex_adt.py module
complex1 = ComplexT(1.0, 2.0)
complex2 = ComplexT(-4.5, -5.5) #4
complex3 = ComplexT(1.33, 0.0)
complex4 = ComplexT(0.0, 0.0) #7
complex5 = ComplexT(1.0, 2.0)

# Test cases for real method
realTest1 = complex1.real() == 1.0
realTest2 = complex4.real() == 0.0
realTest3 = complex2.real() == -4.5
  
realTests = [realTest1, realTest2, realTest3]
passed, numTests = 0, 0
for i in realTests:
   if i == True:
      passed = passed + 1
      numTests = numTests + 1
      print("Passes real Test", numTests)
   else:
      print("Fails real Test", numTests)
      numTests = numTests + 1
print("Passed", passed, "real tests out of", numTests, "\n")

#Test cases for imag method
imagTest1 = complex1.imag() == 2.0
imagTest2 = complex3.imag() == 0.0
imagTest3 = complex2.imag() == -5.5
  
imagTests = [imagTest1, imagTest2, imagTest3]
passed, numTests = 0, 0
for i in imagTests:
   if i == True:
      passed = passed + 1
      numTests = numTests + 1
      print("Passes imag Test", numTests)
   else:
      print("Fails imag Test", numTests)
      numTests = numTests + 1
print("Passed", passed, "imag tests out of", numTests, "\n")

#Test cases for get_r method
get_rTest1 = complex1.get_r() == math.sqrt(5)
get_rTest2 = complex2.get_r() == math.sqrt(4.5**2+5.5**2)
get_rTest3 = complex3.get_r() == math.sqrt(1.33**2)
get_rTest4 = complex4.get_r() == math.sqrt(0)
  
get_rTests = [get_rTest1, get_rTest2, get_rTest3, get_rTest4]
passed, numTests = 0, 0
for i in get_rTests:
   if i == True:
      passed = passed + 1
      numTests = numTests + 1
      print("Passes get_r Test", numTests)
   else:
      print("Fails get_r Test", numTests)
      numTests = numTests + 1
print("Passed", passed, "get_r tests out of", numTests, "\n")

#Test cases for get_phi method
#The value of the phase is rounded to 5 decimal places 
get_phiTest1 = round(complex1.get_phi(),5) == round(cmath.phase(1 + 2j),5)
get_phiTest2 = round(complex2.get_phi(),5) == round(cmath.phase(-4.5 - 5.5j),5)
get_phiTest3 = complex3.get_phi() == None
get_phiTest4 = complex4.get_phi() == None
                  
get_phiTests = [get_phiTest1, get_phiTest2, get_phiTest3, get_phiTest4]
passed, numTests = 0, 0
for i in get_phiTests:
   if i == True:
      passed = passed + 1
      numTests = numTests + 1
      print("Passes get_phi Test", numTests)
   else:
      print("Fails get_phi Test", numTests)
      numTests = numTests + 1
print("Passed", passed, "get_phi tests out of", numTests, "\n")

#Test cases for equal method
equalTest1 = complex1.equal(complex2) == False
equalTest2 = complex1.equal(complex5) == True
equalTest3 = complex1.equal(complex1) == True
  
equalTests = [equalTest1, equalTest2, equalTest3]
passed, numTests = 0, 0
for i in equalTests:
   if i == True:
      passed = passed + 1
      numTests = numTests + 1
      print("Passes equal Test", numTests)
   else:
      print("Fails equal Test", numTests)
      numTests = numTests + 1
print("Passed", passed, "equal tests out of", numTests, "\n")

#Test cases for conj method
conjTest1 = complex1.conj() == ComplexT(1.0, -2.0)
conjTest2 = complex3.conj() == ComplexT(1.33, 0.0)
conjTest3 = complex2.conj() == ComplexT(-4.5, 5.5)
  
conjTests = [conjTest1, conjTest2, conjTest3]
passed, numTests = 0, 0
for i in conjTests:
   if i == True:
      passed = passed + 1
      numTests = numTests + 1
      print("Passes conj Test", numTests)
   else:
      print("Fails conj Test", numTests)
      numTests = numTests + 1
print("Passed", passed, "conj tests out of", numTests, "\n")

#Test cases for add method
addTest1 = (complex1.add(complex2)) == ComplexT(-3.5, -3.5)
addTest2 = (complex3.add(complex4)) == ComplexT(1.33, 0.0)

addTests = [addTest1, addTest2]
passed, numTests = 0, 0
for i in addTests:
   if i == True:
      passed = passed + 1
      numTests = numTests + 1
      print("Passes add Test", numTests)
   else:
      print("Fails add Test", numTests)
      numTests = numTests + 1
print("Passed", passed, "add tests out of", numTests, "\n")

#Test cases for sub method
subTest1 = (complex1.sub(complex2)) == ComplexT(5.5, 7.5)
subTest2 = (complex2.sub(complex1)) == ComplexT(-5.5, -7.5)
subTest3 = (complex3.sub(complex4)) == ComplexT(1.33, 0.0)

subTests = [subTest1, subTest2, subTest3]
passed, numTests = 0, 0
for i in subTests:
   if i == True:
      passed = passed + 1
      numTests = numTests + 1
      print("Passes sub Test", numTests)
   else:
      print("Fails sub Test", numTests)
      numTests = numTests + 1
print("Passed", passed, "sub tests out of", numTests, "\n")

#Test cases for mult method
multTest1 = (complex1.mult(complex2)) == ComplexT(6.5, -14.5)
multTest2 = (complex1.mult(complex4)) == ComplexT(0, 0)

multTests = [multTest1, multTest2]
passed, numTests = 0, 0
for i in multTests:
   if i == True:
      passed = passed + 1
      numTests = numTests + 1
      print("Passes mult Test", numTests)
   else:
      print("Fails mult Test", numTests)
      numTests = numTests + 1
print("Passed", passed, "mult tests out of", numTests, "\n")

# Test cases for recip method
# Verification of test cases calculated using symbolab math calculator:
# https://www.symbolab.com/solver/complex-numbers-calculator
recipTest1 = complex1.recip() == ComplexT(0.2, -0.4)
recipTest2 = complex3.recip() == ComplexT(float(100/133), 0.0)
recipTest3 = complex4.recip() == None
  
recipTests = [recipTest1, recipTest2, recipTest3]
passed, numTests = 0, 0
for i in recipTests:
   if i == True:
      passed = passed + 1
      numTests = numTests + 1
      print("Passes recip Test", numTests)
   else:
      print("Fails recip Test", numTests)
      numTests = numTests + 1
print("Passed", passed, "recip tests out of", numTests, "\n")

#Test cases for div method
# Verification of test cases calculated using symbolab math calculator:
# https://www.symbolab.com/solver/complex-numbers-calculator
divTest1 = (complex1.div(complex2)) == ComplexT(-0.3069306930693069, -0.06930693069306931)
divTest2 = (complex1.div(complex4)) == None

divTests = [divTest1, divTest2]
passed, numTests = 0, 0
for i in divTests:
   if i == True:
      passed = passed + 1
      numTests = numTests + 1
      print("Passes div Test", numTests)
   else:
      print("Fails div Test", numTests)
      numTests = numTests + 1
print("Passed", passed, "div tests out of", numTests, "\n")

#Test cases for sqrt method
# Verification of test cases calculated using symbolab math calculator:
# https://www.symbolab.com/solver/complex-numbers-calculator
sqrtTest1 = complex1.sqrt() == ComplexT(1.272019649514069, 0.7861513777574233)
sqrtTest2 = complex2.sqrt() == ComplexT(1.1415636648422083, -2.408976463332088)
sqrtTest3 = complex3.sqrt() == ComplexT(1.1532562594670797, 0.0)
sqrtTest4 = complex4.sqrt() == ComplexT(0.0, 0.0)

sqrtTests = [sqrtTest1, sqrtTest2, sqrtTest3, sqrtTest4]
passed, numTests = 0, 0
for i in sqrtTests:
   if i == True:
      passed = passed + 1
      numTests = numTests + 1
      print("Passes sqrt Test", numTests)
   else:
      print("Fails sqrt Test", numTests)
      numTests = numTests + 1
print("Passed", passed, "sqrt tests out of", numTests, "\n")


print("Test cases for TriangleT Module:".center(50, '-'))
print(" ")

## Triangles of type TriangleT used in test cases for every method in
#  triangle_adt.py module

triangle1 = TriangleT(4, 5, 3)
triangle2 = TriangleT(4.5, 5.5, 3.5)
triangle3 = TriangleT(3, 4, 5)
triangle4 = TriangleT(1, 2, 9)
triangle5 = TriangleT(0, 0, 0)
triangle6 = TriangleT(-4, -5, -3)
triangle7 = TriangleT(4, 3, 6)
triangle8 = TriangleT(3, 6, 6)
triangle9 = TriangleT(6, 6, 6)

# Test cases for get_sides method
# Any triangle of type TriangleT that is not valid will return None
get_sidesTest1 = triangle1.get_sides() == (4, 5, 3)
get_sidesTest2 = triangle2.get_sides() == None
get_sidesTest3 = triangle5.get_sides() == None
  
get_sidesTests = [get_sidesTest1, get_sidesTest2, get_sidesTest3]
passed, numTests = 0, 0
for i in get_sidesTests:
   if i == True:
      passed = passed + 1
      numTests = numTests + 1
      print("Passes get_sides Test", numTests)
   else:
      print("Fails get_sides Test", numTests)
      numTests = numTests + 1
print("Passed", passed, "get_sides tests out of", numTests, "\n")

# Test cases for equal method
# If either triangle of type TriangleT that is not valid, None is returned
equalTest1 = triangle1.equal(triangle7) == False
equalTest2 = triangle1.equal(triangle1) == True
equalTest3 = triangle1.equal(triangle3) == True
equalTest4 = triangle1.equal(triangle6) == None
  
equalTests = [equalTest1, equalTest2, equalTest3, equalTest4]
passed, numTests = 0, 0
for i in equalTests:
   if i == True:
      passed = passed + 1
      numTests = numTests + 1
      print("Passes equal Test", numTests)
   else:
      print("Fails equal Test", numTests)
      numTests = numTests + 1
print("Passed", passed, "equal tests out of", numTests, "\n")


# Test cases for perim method
# Any triangle of type TriangleT that is not valid will return None
perimTest1 = triangle1.perim() == 12
perimTest2 = triangle4.perim() == None
perimTest3 = triangle6.perim() == None
  
perimTests = [perimTest1, perimTest2, perimTest3]
passed, numTests = 0, 0
for i in perimTests:
   if i == True:
      passed = passed + 1
      numTests = numTests + 1
      print("Passes perim Test", numTests)
   else:
      print("Fails perim Test", numTests)
      numTests = numTests + 1
print("Passed", passed, "perim tests out of", numTests, "\n")

#Test cases for area method
# Any triangle of type TriangleT that is not valid will return None
areaTest1 = triangle1.area() == 6
areaTest2 = triangle2.area() == None
areaTest3 = triangle4.area() == None
  
areaTests = [areaTest1, areaTest2, areaTest3]
passed, numTests = 0, 0
for i in areaTests:
   if i == True:
      passed = passed + 1
      numTests = numTests + 1
      print("Passes area Test", numTests)
   else:
      print("Fails area Test", numTests)
      numTests = numTests + 1
print("Passed", passed, "area tests out of", numTests, "\n")

#Test cases for is_valid method
is_validTest1 = triangle1.is_valid() == True
is_validTest2 = triangle2.is_valid() == False
is_validTest3 = triangle4.is_valid() == False
is_validTest4 = triangle5.is_valid() == False
is_validTest5 = triangle6.is_valid() == False
  
is_validTests = [is_validTest1, is_validTest2, is_validTest3, is_validTest4, is_validTest5]
passed, numTests = 0, 0
for i in is_validTests:
   if i == True:
      passed = passed + 1
      numTests = numTests + 1
      print("Passes is_valid Test", numTests)
   else:
      print("Fails is_valid Test", numTests)
      numTests = numTests + 1
print("Passed", passed, "is_valid tests out of", numTests, "\n")

#Test cases for tri_type method
# Any triangle of type TriangleT that is not valid will return None
tri_typeTest1 = triangle1.tri_type() == TriType.right
tri_typeTest2 = triangle2.tri_type() == None
tri_typeTest3 = triangle7.tri_type() == TriType.scalene
tri_typeTest4 = triangle8.tri_type() == TriType.isosceles
tri_typeTest5 = triangle9.tri_type() == TriType.equilat
  
tri_typeTests = [tri_typeTest1, tri_typeTest2, tri_typeTest3, tri_typeTest4, tri_typeTest5]
passed, numTests = 0, 0
for i in tri_typeTests:
   if i == True:
      passed = passed + 1
      numTests = numTests + 1
      print("Passes tri_type Test", numTests)
   else:
      print("Fails tri_type Test", numTests)
      numTests = numTests + 1
print("Passed", passed, "tri_type tests out of", numTests)





