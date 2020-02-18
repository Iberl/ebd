import matplotlib.pyplot as plt
import numpy as np

TSP = [(100,150),(300,100),(600,160),(2000,90)]  #[(distance, maxSpeed),(distance2, maxSpeed2), ...]
BP = [(40,20),(60,50),(100,30),(300,40)]      #[(speed, brakeWeight),(speed2, brakeWeight2), ...]
TAP = [(50,1),(1400,0),(2000,-0.5)]             #[(distance, gravAccleration),(distance2, gravAccleration2), ...]

sorted(TSP)
sorted(BP)
sorted(TAP)




def v_TSP(distance):
    for item in TSP:
        if distance < item[0]:
            return item[1]
            
    raise ValueError("Distance outside range of TSP")

    
def b_BP(speed):
    
    for item in BP:
        if speed <= item[0]:
            return item[1]
            
    raise ValueError("Speed outside range of BP")
    
def a_TAP(distance):
    
    for item in TAP:
        if distance <= item[0]:
            return item[1]
            
    raise ValueError("Distance outside range of TAP")
    
def sStar_TSP(distance):   #Searches for next jump
    
    for i in range(len(TSP) - 1, -1, -1): #Going backwarts through the list
        if distance > TSP[i][0]:
            return TSP[i][0] - 0.001     
            
    return 0
    
    

#Algorithm



def numBackIntegration(d_EMA, v_EMA, s_EAP):
    
    c = [[],[]] #constant matrix
    Knots = [] #Knots

    DV_INIT = 0.3
    
    s_EMA = s_EAP + d_EMA
    #n = 0
    
    if v_EMA > v_TSP(s_EMA):
        
        v_EMA = v_TSP(s_EMA)
    
    v_n = v_EMA
    s_n = s_EMA
    
    
    while s_n > s_EAP:
        
        dv = DV_INIT
        while v_n < v_TSP(s_n):                              #B) Needed: Additional test if s_n > s_EAP in case v_n does not reach v_TSP(s_EAP)
            
            v_n1 = v_n + dv
            #print(v_n)
            if v_n1 > v_TSP(s_n):
                
                v_n1 = v_TSP(s_n)
                dv = v_n1 - v_n
                
            v2 = (v_n1 + v_n) / 2
            b2 = b_BP(v2)
            
            dt = -dv / b2
            ds = v2 * dt
            s2 =  0.5 * ((s_n + ds) + s_n)
            b2 += a_TAP(s2)                                   #C) Needed: Test if b2 <= 0
            if b2 <= 0:
                raise ValueError("Train will not stop")
            
            dt = -dv / b2
            ds = v2 * dt
            s_n1 = s_n + ds
            if s_n1 < s_EAP:
                s_n1 = s_EAP
                ds = s_n1 - s_n
                v_n1 = v_TSP(s_EAP)
                dv = v_n1 - v_n
            
            Knots.append(s_n1)
            c[0].append(v_n)
            c[1].append(dv/ds)
            #n += 1
            v_n = v_n1
            s_n = s_n1
        sStar = max(s_EAP, sStar_TSP(s_n))
        s_n1 = sStar
        v_n = v_TSP(sStar)                                     #A) Needed to be "v_n =" instead of "v_n1 ="
        
        
        Knots.append(s_n1)
        c[0].append(v_n)                                       #A_2) If v_n, then v_n need a assured change from the last loop, see A)
        c[1].append(0)
        #n += 1
        v_n = v_n                                       
        s_n = s_n1  - 0.001                                       #D) Now solved in def sStar_TSP(); see D_1)
        
    if len(c[0]) != len(c[1]) or len(Knots) != len(c[0]):
        raise IndexError("That should never happen")
        
    return [c,Knots]
     
     
#End of Algorithm


def splineFunction(distance, c, Knots):

    for index in range (len(c[0])):
        
        if distance > Knots[index]:
            if index == 0:

                raise ValueError("Distance outside range of breaking curve")

            return (distance - Knots[index]) * c[1][index] + c[0][index]
            
def myPlotter_spline(c, Knots):
    
    xValues = np.arange(Knots[-1], Knots[0], 1)
    yValues = []
    for x in xValues:
        yValues.append(splineFunction(x,c,Knots))
        
    return [xValues, np.array(yValues)]
    
def myPlotter_TSP(Knots):
    
    xValues = np.arange(Knots[-1], Knots[0], 1)
    yValues = []
    for x in xValues:
        yValues.append(v_TSP(x) + 1)
        
    return [xValues, np.array(yValues)]
        


rawData = numBackIntegration(1800, 0, 0)
print("Starting to plot now")

xy = myPlotter_spline(rawData[0],rawData[1])
xy2 = myPlotter_TSP(rawData[1])


plt.plot(xy[0],xy[1], label = "BC")
plt.plot(xy2[0],xy2[1], label = "TSP + 1 m/s")
plt.legend()
plt.xlabel("Distance [m]")
plt.ylabel("Speed [m/s]")

plt.show()


            


    
    
    