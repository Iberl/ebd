package ebd.messageLibrary.util;

import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryCodedDecimalTest {

    final int iterations = 2000;
    Random random     = new Random();
    char[] digitChars = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    String randomNumberString(int digits, int bound) {
        StringBuilder s = new StringBuilder();

        while(digits > 0) {
            s.append(digitChars[random.nextInt(bound)]);
            digits -= 1;
        }

        return s.toString();
    }

    void testStringConstructor(int bound) {
        String input = randomNumberString(random.nextInt(15) + 1, bound);

        System.out.println("input: " + input);

        BinaryCodedDecimal bcd = new BinaryCodedDecimal(input);

        for(int i = 0; i < bcd.getNumberOfDigits(); i++) {
            assertEquals(Character.getNumericValue(input.charAt(i)), bcd.getDigitAt(i));
        }

        System.out.println("bcd: " + bcd.toString());

        assertEquals(input, bcd.toString());
    }

    @RepeatedTest(iterations)
    void testNumberStringConstructor() {
        testStringConstructor(9);
    }

    @RepeatedTest(iterations)
    void testHexNumberStringConstructor() {
        testStringConstructor(15);
    }

    @RepeatedTest(iterations)
    void testLongConstructor() {
        Long input = random.nextLong();

        System.out.println(input);

        String inputStr = Long.toHexString(input);

        BinaryCodedDecimal bcd = new BinaryCodedDecimal(input);

        for(int i = 0; i < bcd.getNumberOfDigits(); i++) {
            assertEquals(Character.getNumericValue(inputStr.charAt(i)), bcd.getDigitAt(i));
        }

        assertEquals(input, bcd.getNumber());

    }

}