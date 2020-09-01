DBDClient
============

DBDClient is a library for comminicating with the DBD server of the EBD.

# Usage #
* Instantiation

This creates a still unconnected instance of the DBDClient. A listener that retrieves all unfiltered subscribed variable changes can be passed as an argument to the constructor.
```java
DBDClient dbdclient = new DBDClient();
```

* Connecting

Connect to the DBD server on the given host address. The port is 1436 by default.
```java
dbdclient.connect("server1.ebd.signallabor.de");
```

* Set variable

Change the value of the `"TEST"` variable to `42`. If any client has subscribed this variable, they are notified if the new value differs from the old one.
```java
dbdclient.setValue("TEST", 42);
```

* Subscribe variable

Subscribe to variable changes of `"TEST"`. If the value changes on the server side, clients which have subscribed to this variable are notified, i.e. its listeners are called.
```java
dbdclient.subscribe("TEST");
```

* Query variable

Sends a request to the server which responds with the current value of `"TEST"`. Installed listeners are notified, the value is stored internally and can be queried with `getValue("TEST")`. Usually, `subscribeAndQuery` is used.
```java
dbdclient.queryValue("TEST");
```

* Get value of a variable

Returns the current value which is stored locally by the DBDClient. Only variables that are queried at least once are available. If the variable does not exist, the second default argument is returned (in this case `42`, defaults to `0` if omitted).
```java
int value = dbdclient.getValue("TEST", 42);
```

* Add Listeners

If the one argument method are used, the specified listener retrieves all variable changes, this DBDClient has subscriptions for.
```java
dbdclient.addDBDListener(new DBDListener() {

    @Override
    public void valueUpdated(DBDClient source, String name, int newValue, int oldValue) {
        // Variable `name` has changed its value from `oldValue` to `newValue`. `source` is the DBDClient instance that has called this method.
    }
});
```

If the two argument method is used, the specified listener gets only called on changes of the given `"TEST"` variable. In this example, Java 8 lambda expression is used.
```java
client.addDBDListener("TEST", (source, name, newValue, oldValue) -> {
        // Variable `name` has changed its value from `oldValue` to `newValue`. `source` is the DBDClient instance that has called this method.
    }
});
```

The `oldValue` integer is `-1` if no previous value is received from the server, which is always true if a variable is subscribed and queried the first time. All integers (`newValue` and `oldValue`) can only be positive.

* Disconnecting

```java
dbdclient.disconnect();
```

* Simulation Clock

```java
SimulationClock clock = dbdclient.getClock();
System.out.println(clock.getSimulationTime()); // Prints the `java.util.Date` object
clock.setOffset(3600); // Set the clock's offset in seconds to 3600 (= 1 hour). This is sent to the server via the `ZEITDELTA` variable and broadcasted to all other clients.
```