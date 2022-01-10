## @file Scene.py
#  @author Hamrish Saravanakumar
#  @brief Scene Module for a Shape moving through 2D Space
#  @date February 16 2021

import scipy.integrate

## @brief Class that implements a representation of a shape moving through 2D space.


class Scene:
    ## @brief Constructor method for class Scene
    #  @details Initialized by a Shape, an unbalanced force function in the x and y direction,
    #           and the initial velocity in the x and y direction.
    #  @param s_ A shape.
    #  @param Fx_ Unbalanced force function in the x direction.
    #  @param Fy_ Unbalanced force function in the y direction.
    #  @param Vx_ Initial velocity in the x durection.
    #  @param Vy_ Initial velocity in the y direction.
    def __init__(self, s_, fx_, fy_, vx_, vy_):
        self.s = s_
        self.fx = fx_
        self.fy = fy_
        self.vx = vx_
        self.vy = vy_

    ## @brief Getter method to obtain shape.
    #  @return The shape.
    def get_shape(self):
        return self.s

    ## @brief Getter method to obtain unbalanced force functions in both directions.
    #  @return Tuple consisting of unbalanced force functions in the x and y directions.
    def get_unbal_forces(self):
        return self.fx, self.fy

    ## @brief Getter method to obtain initial velocities in both directions.
    #  @return Tuples consisting of initial velocities in the x and y directions.
    def get_init_velo(self):
        return self.vx, self.vy

    ## @brief Setter method to modify the shape.
    def set_shape(self, s_):
        self.s = s_

    ## @brief Setter method to modify the unbalanced force functions in either direction.
    def set_unbal_forces(self, fx_, fy_):
        self.fx = fx_
        self.fy = fy_

    ## @brief Setter method to modify the initial velocities in either direction.
    def set_init_velo(self, vx_, vy_):
        self.vx = vx_
        self.vy = vy_

    ## @brief Function that determines the position and velocity
    #  @details Position and velocity over time are determined specifically based on the
    #           forces and the initial values for position and velocity.
    #  @param final_t The value for the final time
    #  @param nsteps The value for the number of steps that the time interval
    #         will be divided into.
    #  @return A simulation of the scene as a sequence of times, and a sequence of sequences
    #          for the position and velocity over time.
    def sim(self, final_t, nsteps):
        t = []
        for i in range(nsteps):
            t.append((i * final_t) / (nsteps - 1))
        sequence = [self.s.cm_x(), self.s.cm_y(), self.vx, self.vy]
        ode = scipy.integrate.odeint(self.__ode, sequence, t)
        return t, ode

    def __ode(self, w, t):
        return [w[2], w[3], self.fx(t) / self.s.mass(), self.fy(t) / self.s.mass()]
