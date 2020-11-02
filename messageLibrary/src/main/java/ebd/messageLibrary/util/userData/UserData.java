package ebd.messageLibrary.util.userData;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.Objects;

public abstract class UserData {

    /** {@link ETCSVariables#NID_XUSER} */
    @BitLength(9)
    @OrderIndex(0)
    public int X_USER;


    // Constructors

    public UserData(int x_USER) {
        X_USER = x_USER;
    }


    // Other Functions

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        UserData userData = (UserData) object;
        return X_USER == userData.X_USER;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X_USER);
    }

    @Override
    public String toString() {
        return "UserData{"
               + "X_USER=" + X_USER
               + '}';
    }

}
