import matplotlib.pyplot as plt
import numpy as np

with open(r"C:\intellij-workspace\etcs\ServiceDecelerationCurve.txt") as file:
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
    y2 = float(y2) + 1
    y3 = float(y3) * 100
    
    xL.append(x)
    yL.append(y)
    y2L.append(y2)
    y3L.append(y3)
    
xArray = np.array(xL)
yArray = np.array(yL) 
y2Array = np.array(y2L) 
y3Array = np.array(y3L) 

#with open(r"C:\eclipse-workspace\ETCS_EBD\test7_true.txt") as file:
    #lines = file.readlines()
    
x2L = []
y4L = []


for line in lines:
    
    xysplit = line.split(":")
    x2 = xysplit[0].replace(",",".")
    y4 = xysplit[1].replace(",",".")
    
    
    x2 = float(x2)
    y4 = float(y4)  * 10

    
    x2L.append(x2)
    y4L.append(y4)

x2Array = np.array(x2L)
y4Array = np.array(y4L) 


plt.plot(xArray,yArray, label = "BC")
plt.plot(xArray,y2Array, label = "TSP + 1 km/h")
#plt.plot(xArray,y3Array, label = "Gefaelle * 100000")
#plt.plot(y4Array,x2Array, label = "BP * 10")

plt.legend()
plt.xlabel("Distance [m]")
plt.ylabel("Speed [m/s]")

plt.show()