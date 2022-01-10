## @file Shape.py
#  @author Hamrish Saravanakumar
#  @brief Provides the Shape Interface Module
#  @date February 16 2021

from abc import ABC, abstractmethod

## @brief Shape contains 4 generic functions to define the properties of the shape.


class Shape(ABC):

    @abstractmethod
    ## @brief A generic method to determine the center of mass of the x coordinate.
    #  @return A real value representing the center of mass of the x coordinate.
    def cm_x(self):
        pass

    @abstractmethod
    ## @brief A generic method to determine the center of mass of the y coordinate.
    #  @return A real value representing the center of mass of the y coordinate.
    def cm_y(self):
        pass

    @abstractmethod
    ## @brief A generic method to determine the of mass.
    #  @return A real value representing the mass.
    def mass(self):
        pass

    @abstractmethod
    ## @brief A generic method to determine the moment of inertia.
    #  @return A real value representing the moment of inertia.
    def m_inert(self):
        pass
