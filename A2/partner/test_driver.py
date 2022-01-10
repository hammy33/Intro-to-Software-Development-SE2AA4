## @file test_driver.py
#  @author Hamrish Saravanakumar
#  @brief Test driver
#  @date February 16 2021
#  @details Presents test cases for BodyT.py, CircleT.py, Scene.py & TriangleT.py

from Shape import *
from CircleT import *
from TriangleT import *
from BodyT import *
from Scene import *

from pytest import *


class TestCircleT:

    def test_normalcm_x(self):
        circle1 = CircleT(3.0, 5.0, 6.0, 9.0)
        assert circle1.cm_x() == 3.0

    def test_normalcm_y(self):
        circle1 = CircleT(3.0, 5.0, 6.0, 9.0)
        assert circle1.cm_y() == 5.0

    def test_normalmass(self):
        circle1 = CircleT(3.0, 5.0, 6.0, 9.0)
        assert circle1.mass() == 9.0

    def test_normalm_inert(self):
        circle1 = CircleT(3.0, 5.0, 6.0, 9.0)
        assert circle1.m_inert() == 162.0

    def test_invalidRadius(self):
        with raises(ValueError):
            CircleT(2.0, 5.0, -2.0, 3.0)

    def test_invalidMass(self):
        with raises(ValueError):
            CircleT(2.0, 5.0, 2.0, 0.0)


class TestTriangleT:

    def test_normalcm_x(self):
        triangle1 = TriangleT(3.0, 5.0, 6.0, 9.0)
        assert triangle1.cm_x() == 3.0

    def test_normalcm_y(self):
        triangle1 = TriangleT(3.0, 5.0, 6.0, 9.0)
        assert triangle1.cm_y() == 5.0

    def test_normalmass(self):
        triangle1 = TriangleT(3.0, 5.0, 6.0, 9.0)
        assert triangle1.mass() == 9.0

    def test_normalm_inert(self):
        triangle1 = TriangleT(3.0, 5.0, 6.0, 9.0)
        assert triangle1.m_inert() == 27.0

    def test_invalidSideLength(self):
        with raises(ValueError):
            TriangleT(2.0, 5.0, -2.0, 3.0)

    def test_invalidMass(self):
        with raises(ValueError):
            TriangleT(2.0, 5.0, 2.0, 0.0)


class TestBodyT:

    def test_normalcm_x(self):
        body1 = BodyT([1, -1, -1, 1], [1, 1, -1, -1], [10, 10, 10, 10])
        assert body1.cm_x() == 0

    def test_normalcm_y(self):
        body1 = BodyT([1, -1, -1, 1], [1, 1, -1, -1], [10, 10, 10, 10])
        assert body1.cm_y() == 0

    def test_normalmass(self):
        body1 = BodyT([1, -1, -1, 1], [1, 1, -1, -1], [10, 10, 10, 10])
        assert body1.mass() == 40.0

    def test_normalm_inert(self):
        body1 = BodyT([1, -1, -1, 1], [1, 1, -1, -1], [10, 10, 10, 10])
        assert body1.m_inert() == 80.0

    def test_invalidSequenceLengths(self):
        with raises(ValueError):
            BodyT([7, 8, 8, 7, 5, 2], [7, 7, 8, 8], [10, 10, 10, 10])

    def test_invalidMass(self):
        with raises(ValueError):
            BodyT([7, 8, 8, 7], [7, 7, 8, 8], [-10, 10, 0, 10])


class TestScene:

    def test_normalget_shape(self):
        circle1 = CircleT(1.0, 10.0, 0.5, 1.0)

        def fx(t):
            return 1 if t < 5 else 0

        def fy(t):
            return -9.81 if t < 5 else 9.81
        vx, vy = 0, 0
        scene1 = Scene(circle1, fx(3), fy(3), vx, vy)
        assert scene1.get_shape() == circle1

    def test_normalget_unbal_forces(self):
        circle1 = CircleT(1.0, 10.0, 0.5, 1.0)

        def fx(t):
            return 1 if t < 5 else 0

        def fy(t):
            return -9.81 if t < 5 else 9.81
        vx, vy = 0, 0
        scene1 = Scene(circle1, fx(3), fy(3), vx, vy)
        assert scene1.get_unbal_forces() == (1, -9.81)

    def test_normalget_init_velo(self):
        circle1 = CircleT(1.0, 10.0, 0.5, 1.0)

        def fx(t):
            return 1 if t < 5 else 0

        def fy(t):
            return -9.81 if t < 5 else 9.81
        vx, vy = 0, 0
        scene1 = Scene(circle1, fx(3), fy(3), vx, vy)
        assert scene1.get_init_velo() == (0, 0)

    def test_normalset_shape(self):
        circle1 = CircleT(1.0, 10.0, 0.5, 1.0)

        def fx(t):
            return 1 if t < 5 else 0

        def fy(t):
            return -9.81 if t < 5 else 9.81
        vx, vy = 0, 0
        scene1 = Scene(circle1, fx(3), fy(3), vx, vy)
        triangle1 = TriangleT(3.0, 5.0, 6.0, 9.0)
        scene1.set_shape(triangle1)
        assert scene1.get_shape() == triangle1

    def test_normalset_unbal_forces(self):
        circle1 = CircleT(1.0, 10.0, 0.5, 1.0)

        def fx(t):
            return 1 if t < 5 else 0

        def fy(t):
            return -9.81 if t < 5 else 9.81
        vx, vy = 0, 0
        scene1 = Scene(circle1, fx(3), fy(3), vx, vy)
        scene1.set_unbal_forces(fx(7), fy(7))
        assert scene1.get_unbal_forces() == (0, 9.81)

    def test_normalset_init_velo(self):
        circle1 = CircleT(1.0, 10.0, 0.5, 1.0)

        def fx(t):
            return 1 if t < 5 else 0

        def fy(t):
            return -9.81 if t < 5 else 9.81
        vx, vy = 0, 0
        scene1 = Scene(circle1, fx(3), fy(3), vx, vy)
        new_vx, new_vy = 1, 1
        scene1.set_init_velo(new_vx, new_vy)
        assert scene1.get_init_velo() == (1, 1)

    def test_normalsim_t(self):
        circle1 = CircleT(1.0, 10.0, 0.5, 1.0)

        def fx(t):
            return 1 if t < 5 else 0

        def fy(t):
            return -9.81 if t < 5 else 9.81
        vx, vy = 0, 0
        scene1 = Scene(circle1, fx(3), fy(3), vx, vy)
        t, w = scene1.sim(2, 5)
        calculated_t = [0.0, 0.5, 1.0, 1.5, 2.0]
        sub = [x1 - x2 for (x1, x2) in zip(t, calculated_t)]
        norm_t = abs(max(sub))
        val = norm_t / max(calculated_t)
        assert val <= 0.000001

    def test_normalsim_w(self):
        circle1 = CircleT(1.0, 10.0, 0.5, 1.0)

        def fx(t):
            return 1 if t < 5 else 0

        def fy(t):
            return -9.81 if t < 5 else 9.81
        vx, vy = 0, 0
        scene1 = Scene(circle1, fx(3), fy(3), vx, vy)
        t, w = scene1.sim(2, 5)
        calculated_w = [[1, 10, 0, 0]
                        [1.625, 8.77375, 2.5, -4.905]
                        [3.5, 5.095, 5, -9.81]
                        [6.625, -1.03625, 7.5, -14.715]
                        [11, -9.62, 10, -19.62]]
        sub = [x1 - x2 for (x1, x2) in zip(w, calculated_w)]
        norm_w = abs(max(sub))
        val = norm_w / max(calculated_w)
        assert val <= 0.000001
