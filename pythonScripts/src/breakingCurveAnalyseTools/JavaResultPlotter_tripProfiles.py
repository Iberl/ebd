import os
import matplotlib.pyplot as plt
import numpy as np

path = r"C:\intellij-workspace\etcs\results\tripProfiles\2020-07-07T14-52-25.9910181"
path = path + "/"
pathList = [(path + f) for f in os.listdir(path)]

for path in pathList:

    with open(path) as file:
        lines = file.readlines()

    xL = []
    yL = []

    firstLine = lines.pop(0)
    for line in lines:
        firstSplit = line.split(";")

        xL.append(float(firstSplit[0][4:]))

        secondSplit = firstSplit[1][14:].split(",")
        yL.append(float(secondSplit[0]))

    xArray = np.array(xL)
    yArray = np.array(yL)

    plt.plot(xArray, yArray, label = firstLine)


plt.legend()
plt.xlabel("Distance [m]")
plt.ylabel("Speed k[m/h]")

plt.show()