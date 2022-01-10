## @file Plot.py
#  @author Hamrish Saravanakumar
#  @brief Plot module used to plot functions.
#  @date February 16 2021

import matplotlib.pyplot as plt

## @brief Plot will plot three separate graphs of data points
#  @details The first graph will plot x versus t, the second graph will plot y versus t,
#           and the third graph will plot y versus x.
#  @param w Sequence of sequences that represent the x and y values to be plotted against.
#  @param t Sequence of times


def plot(w, t):
    if len(w) != len(t):
        raise ValueError
    x = []
    y = []
    if len(w) != len(t):
        raise ValueError
    for i in range(0, len(w)):
        x.append(w[i][0])
    for i in range(0, len(w)):
        y.append(w[i][1])
    fig, axes = plt.subplots(3)
    fig.suptitle('Motion Simulation')
    axes[0].plot(t, x)
    axes[0].set(ylabel="x (m)")
    axes[1].plot(t, y)
    axes[1].set(ylabel="y (m)")
    axes[2].plot(x, y)
    axes[2].set(ylabel="y (m)")
    axes[2].set(xlabel="x (m)")
    plt.show()
