import matplotlib

matplotlib.use('TkAgg')

import matplotlib.pyplot as plt
import numpy as np
import os.path

path = r"C:\intellij-workspace\etcs\results\breakingCurves\2020-10-10T18-12-03.7167627"


def getMatrixFrom(allLines):
    matrix = []
    for ii in range(2, len(allLines)):
        lineList = allLines[ii].replace("\n", "").replace(" ", "").split("|")
        matrix.append(lineList)
    return matrix


def getPlotDir(allLines):
    nameList = allLines[1].replace("\n", "").replace(" ", "").split("|")
    matrix = getMatrixFrom(allLines)
    plotDir = {}
    xList = []

    for list in matrix:
        xList.append(float(list[0]))

    for ii in range(1, len(matrix[0])):
        valueList = []
        for list in matrix:
            valueList.append(float(list[ii]))
        plotDir[nameList[ii]] = valueList

    return plotDir,xList

path = path + "/"
pathList = [(path + f) for f in os.listdir(path)]

i = 0
fig, axs = plt.subplots(len(pathList), 1, sharex="all")
highestX = 0

for path in pathList:

    with open(path) as file:
        lines = file.readlines()

    plotDir, xList = getPlotDir(lines)
    highestX = max(highestX, xList[-1])
    xArray = np.array(xList)
    lableCounter = 0
    for key in plotDir:
        yArray = np.array(plotDir.get(key))
        axs[i].plot(xArray, yArray, label=key)

    axsTitel = path.split("/")[-1].split("-")[1]
    axsTitel = axsTitel.upper()
    axs[i].legend(loc="upper left",
                  bbox_to_anchor=(1, 1.05),
                  fontsize=8,
                  labelspacing=0,
                  ncol=1,
                  columnspacing=0)
    axs[i].set_ylabel(axsTitel + "\nSpeed [m/s]")

    i += 1
axs[i-1].set_xlabel("Distance [m]")
plt.xlim(0,highestX)
fig.tight_layout()
plt.show()
