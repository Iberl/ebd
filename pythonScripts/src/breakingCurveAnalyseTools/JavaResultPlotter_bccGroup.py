import matplotlib.pyplot as plt
import numpy as np
import os.path

path = r"C:\intellij-workspace\etcs\results\breakingCurves\2020-07-07T14-52-25.9850195"
path = path + "/"
pathList = [(path + f) for f in os.listdir(path)]
            
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
    yArray = np.array(yL)
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
