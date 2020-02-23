import matplotlib.pyplot as plt
import numpy as np

pathList = [r"M:\OneDrive\Verkehr\Code\windows\EmergencyDecelerationCurve.txt",
            r"M:\OneDrive\Verkehr\Code\windows\EmergencyInterventionCurve.txt",
            r"M:\OneDrive\Verkehr\Code\windows\ServiceDecelerationCurve.txt",
            r"M:\OneDrive\Verkehr\Code\windows\ServiceInterventionCurve.txt",
            r"M:\OneDrive\Verkehr\Code\windows\ServiceWarningCurve.txt",
            r"M:\OneDrive\Verkehr\Code\windows\ServicePermittedSpeedCurve.txt",
            r"M:\OneDrive\Verkehr\Code\windows\ServiceIndicationCurve.txt",
            r"M:\OneDrive\Verkehr\Code\windows\ServiceCoastingPhaseCurve.txt"]
            
for path in pathList:
    
    with open(path) as file:
        lines = file.readlines()
        
    xL = []
    yL = []
    
    for line in lines:
        
        xysplit = line.split(":")
        x = xysplit[0].replace(",", ".")
        y = xysplit[1].replace(",", ".")
        
        x = float(x)
        y = float(y)
        
        xL.append(x)
        yL.append(y)
        
    xArray = np.array(xL)
    yArray = np.array(yL) - 1
    labelList = path.split("\\")
    name = labelList[-1].replace(".txt", "")
    plt.plot(xArray, yArray, label = name)

plt.legend()
plt.xlabel("Distance [m]")
plt.ylabel("Speed [m/s]")

plt.show()
