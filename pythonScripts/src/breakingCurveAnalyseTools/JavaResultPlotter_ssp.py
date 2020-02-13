import matplotlib.pyplot as plt
import numpy as np

with open(r"C:\eclipse-workspace\ETCS_EBD\test_ssp.txt") as file:
    lines = file.readlines()
    
xL = []
yL = []
y2L = []
y3L = []

for line in lines:
    
    xysplit = line.split(":")
    x = xysplit[0].replace(",",".")
    y = xysplit[1].replace(",",".")
    y2 = xysplit[2].replace(",",".")
    y3 = xysplit[3].replace(",",".")
    
    x = float(x)
    y = float(y)
    y2 = float(y2)
    y3 = float(y3)
    
    xL.append(x)
    yL.append(y)
    y2L.append(y2)
    y3L.append(y3)
    
xArray = np.array(xL)
yArray = np.array(yL) - 1
y2Array = np.array(y2L)
y3Array = np.array(y3L)

plt.plot(xArray,yArray, label = "final")
plt.plot(xArray,y2Array, label = "first")
plt.plot(xArray,y3Array, label = "second")
plt.legend()
plt.xlabel("Distance [m]")
plt.ylabel("Speed [km/h]")

plt.show()