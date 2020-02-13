import matplotlib.pyplot as plt
import numpy as np

with open(r"C:\eclipse-workspace\ETCS_EBD\test.txt") as file:
    lines = file.readlines()
    
xL = []
yL = []
y2L = []

for line in lines:
    
    xysplit = line.split(":")
    x = xysplit[0].replace(",",".")
    y = xysplit[1].replace(",",".")
    y2 = xysplit[2].replace(",",".")
    
    x = float(x)
    y = float(y) * (3.6)
    y2 = float(y2) * (3.6) + 1

    
    xL.append(x)
    yL.append(y)
    y2L.append(y2)
    
xArray = np.array(xL)
yArray = np.array(yL) 
y2Array = np.array(y2L) 



plt.plot(xArray,yArray, label = "BC")
plt.plot(xArray,y2Array, label = "TSP + 1 km/h")

plt.legend()
plt.xlabel("Distance [m]")
plt.ylabel("Speed k[m/h]")

plt.show()