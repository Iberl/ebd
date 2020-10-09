import matplotlib.pyplot as plt
import numpy as np

with open(r"C:\intellij-workspace\etcs\results\breakingCurves\ServicePermittedSpeedCurve.txt") as file:
    lines = file.readlines()
    
xL = []
yL = []

for line in lines:
    
    xysplit = line.split(":")
    x = xysplit[0].replace(",",".")
    y = xysplit[1].replace(",",".")
    
    x = float(x)
    y = float(y) * (3.6)

    
    xL.append(x)
    yL.append(y)
    
xArray = np.array(xL)
yArray = np.array(yL)



plt.plot(xArray,yArray, label = "BC")

plt.legend()
plt.xlabel("Distance [m]")
plt.ylabel("Speed k[m/h]")

plt.show()