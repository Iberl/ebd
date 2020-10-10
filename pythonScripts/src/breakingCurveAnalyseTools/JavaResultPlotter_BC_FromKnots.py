import matplotlib

matplotlib.use('TkAgg')

import matplotlib.pyplot as plt
import numpy as np
import os.path

path = r"C:\intellij-workspace\etcs\results\breakingCurves\2020-10-10T18-01-58.2544423"

def getPlotDir(allLines):
    highX = 0.0
    newPlotDir = {}
    curName = ""
    curDegree = 0
    curPointList = [[], []]
    for line in allLines:
        line = line.rstrip()
        if line.startswith("START"):
            curName = line.split(" ")[1]
        elif line.startswith("Id"):
            curDegree = int(line[-1])
        elif line.startswith("Key:"):
            lineSplit = line.split(";")
            x = float(lineSplit[0].replace("Key: ", ""))
            highX = max(x,highX)
            yPart = lineSplit[1].split(",")[0]
            y = float(yPart.replace("Coefficients: ", ""))
            curPointList[0].append(x)
            curPointList[1].append(y)
        elif line.startswith("END"):
            newPlotDir[curName + " " + str(curDegree)] = curPointList
            curPointList = [[], []]
    return newPlotDir, highX


def getDegree0PointList(pointList, maxX):
    oldXList = pointList[0]
    oldYList = pointList[1]
    newXList = []
    newYList = []

    newXList.append(oldXList.pop(0))
    newYList.append(oldYList.pop(0))

    for i in range(len(oldXList)):
        newXList.append(oldXList[i])
        newXList.append(oldXList[i])

        newYList.append(newYList[-1])
        newYList.append(oldYList[i])

    newXList.append(maxX)
    newYList.append(newYList[-1])
    return [newXList, newYList]


path = path + "/"
pathList = [(path + f) for f in os.listdir(path)]

i = 0
fig, axs = plt.subplots(len(pathList), 1, sharex="all")
highestX = 0

for path in pathList:

    with open(path) as file:
        lines = file.readlines()

    plotDir, maxX = getPlotDir(lines)
    highestX = max(highestX, maxX)
    lableCounter = 0

    for key in plotDir:
        name = key.split(" ")[0]
        degree = int(key.split(" ")[1])
        if degree > 0:
            pointList = plotDir.get(key)
        else:
            pointList = getDegree0PointList(plotDir.get(key), highestX)

        xList = pointList[0]
        yList = pointList[1]
        xArray = np.array(xList)
        yArray = np.array(yList)
        axs[i].plot(xArray, yArray, label=name[:3] + ".." + name.split(":")[1])
        lableCounter += 1

    axsTitel = path.split("/")[-1].split("-")[1]
    axsTitel = axsTitel.upper()
    axs[i].legend(loc="upper left",
                  bbox_to_anchor=(1, 1.05),
                  fontsize=8,
                  labelspacing=0,
                  ncol=int(lableCounter/12) + 1,
                  columnspacing=0)
    axs[i].set_ylabel(axsTitel + "\nSpeed [m/s]")

    i += 1
axs[i-1].set_xlabel("Distance [m]")
plt.xlim(0,highestX)
fig.tight_layout()
plt.show()
