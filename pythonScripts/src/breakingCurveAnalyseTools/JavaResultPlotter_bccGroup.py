import matplotlib.pyplot as plt
import numpy as np
import os.path

pathStart = r"C:\intellij-workspace\etcs\results\breakingCurves"

pathEnd = r"\2020-06-09T12-40-39.4546809"

path = r"C:/intellij-workspace/etcs/results/breakingCurves/2020-06-09T12-40-39.4546809/"
print(os.listdir(path))
pathList = [(path + f) for f in os.listdir(path)]
print(pathList)
            
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
    labelList = path.split("/")
    name = labelList[-1].replace(".txt", "")
    name = name[13:-14]
    name = name.replace("Emergency", "E")
    name = name.replace("Service", "S")
    name = name.replace("Deceleration", "Dec")
    name = name.replace("CoastingPhase", "CP")
    name = name.replace("PermittedSpeed", "PS")
    name = name.replace("Intervention", "Inter")
    name = name.replace("Indication", "Indi")

    plt.plot(xArray, yArray, label = name)

plt.legend()
plt.xlabel("Distance [m]")
plt.ylabel("Speed [m/s]")

plt.show()
