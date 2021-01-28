import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Basic {

    private static class IntegerHolder {
        int i = 0;

        public IntegerHolder(int i) {
            this.i = i;

        }

        public void set(int newI) {
            this.i = newI;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("i", i)
                    .toString();
        }
    }


    static void simpleTest() {
        ArrayList<IntegerHolder> a = new ArrayList<>();
        a.add(new IntegerHolder(1));
        a.add(new IntegerHolder(4));
        a.add(new IntegerHolder(3));
        printArray(a);
        IntegerHolder IH = a.get(1);
        IH.set(2);
        printArray(a);



    }

    private static void printArray(ArrayList<IntegerHolder> a) {
        for(IntegerHolder i : a) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        simpleTest();
    }


}
