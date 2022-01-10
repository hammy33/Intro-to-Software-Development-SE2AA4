## @file Scene.py
#  @author Laura Southwood (MacId: southwol)
#  @brief implements an ADT for a scene of a shape
#  @date February 16, 2021
#  @details only models 1 shape at a time

from Shape import Shape
from scipy.integrate import odeint


## @brief creates a scene with 1 Shape, initial velocity, and unbalanced forces
# @details velocity and forces are in their x and y components
class Scene:

    ## @brief constructor for Scene class
    # @param s a Shape
    # @param Fx a function (R -> R), the unbalanced force in the x direction
    # @param Fy a function (R -> R), the unbalanced force in the y direction
    # @param vx a real number (int or float), the initial velocity in the x direction
    # @param vy a real number (int or float), the initial velocity in the y direction
    def __init__(self, s_prime, Fx_prime, Fy_prime, vx_prime, vy_prime):
        self.s = s_prime
        self.Fx = Fx_prime
        self.Fy = Fy_prime
        self.vx = vx_prime
        self.vy = vy_prime

    ## @brief a method for getting the scene's shape
    # @return a Shape, the one in the scene
    def get_shape(self):
        return self.s

    ## @brief a method for getting the unbalanced forces acting on the shape
    # @return two functions (R -> R), the first one acting in the x direction,
    # the second acting in the y direction
    def get_unbal_forces(self):
        return self.Fx, self.Fy

    ## @brief a method for getting the initial velocity of the shape
    # @return two real numbers (int or float), the first one being inital velocity
    # in the x direction, the second being initial velocity in the y direction.
    def get_init_velo(self):
        return self.vx, self.vy

    ## @brief a method for setting the scene's shape
    # @param s_prime a Shape, a new one to be replaced in the scene
    def set_shape(self, s_prime):
        self.s = s_prime

    ## @brief a method for setting the unbalanced forces acting on the shape
    # @param Fx_prime a function (R -> R) to replace the x direction force
    # @param Fy_prime a function (R -> R) to replace the y direction force
    def set_unbal_forces(self, Fx_prime, Fy_prime):
        self.Fx = Fx_prime
        self.Fy = Fy_prime

    ## @brief a method for setting the initial velocity of the shape
    # @param vx_prime a real number (int or float) to replace the x direction initial velocity
    # @param vy_prime a real number (int or float) to replace the y direction initial velocity
    def set_init_velo(self, vx_prime, vy_prime):
        self.vx = vx_prime
        self.vy = vy_prime

    ## @brief simulates the scene (calculates the ode)
    # @param t_final a real number (int or float)
    # @param nsteps a natural number (int)
    # @return a sequence of real numbers, time values increasing incrementally up to t_final.
    # Also returns a sequence of sequences ([rx, ry, vx, vy] real number values over time)
    def sim(self, t_final, nsteps):
        t = []
        for i in range(nsteps):
            t.append((i * t_final) / (nsteps - 1))

        ## @brief uses x and y position and velocity (and time),
        # to get x and y velocity and acceleration
        # @param w a sequence of 4 elements [rx, ry, vx, vy]
        # @param t a real number (int or float), represents time
        # @return a sequence of 4 elements [vx, vy, deriv(vx/t), deriv(vy/t)]
        def ode(w, t):
            return [w[2], w[3], self.Fx(t) / self.s.mass(), self.Fy(t) / self.s.mass()]

        return t, odeint(ode, [self.s.cm_x(), self.s.cm_y(), self.vx, self.vy], t)
