package bsu.comp152;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SmallestIntegerTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    ByteArrayOutputStream testOut;
    ByteArrayInputStream testIn;

    // thanks to https://stackoverflow.com/a/50721326
    @BeforeEach
    private void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    // helper method for runMain
    private void provideInput(String input) {
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
    }

    // runs main with given user input, returns the number from
    // the output as a string
    //
    private String runMain(String input) {
        provideInput(input);
        SmallestInteger.main(new String[0]);
        return getNumStringFromOutput();
    }

    private String getOutput() {
        return testOut.toString();
    }

    private String getNumStringFromOutput() {
        // this works if there is only one number in the output
        String regex = "(-?\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(getOutput());
        String numString = "";
        // if there is more than on number it stops after the first one
        while (matcher.find()) {
            numString += matcher.group();
            break;
        }
        return numString;
    }

    // TODO make this stop passing with empty main method
    @Test
    public void lowercaseQEndsProgram() {
        // if q does not end the program, the x will cause an exception
        runMain("q\nx\n");
        // check that running main actually consumed the q
        Scanner leftover = new Scanner(testIn);
        if (leftover.hasNext()) {
            assertThat(leftover.next(), not(equalTo("q")));
        }
    }

    @Test
    public void uppercaseQEndsProgram() {
        // if Q does not end the program, the x will cause an exception
        runMain("Q\nx\n");
        // check that running main actually consumed a Q
        Scanner leftover = new Scanner(testIn);
        if (leftover.hasNext()) {
            assertThat(leftover.next(), not(equalTo("Q")));
        }
    }

    @Test
    public void noNumberInOutputAfterEnteringNoNumbers() {
        assertThat(runMain("Q\n"), equalTo(""));
    }

    @Test
    public void findsMinOfOnePositiveNumber() {
        assertThat("Input: 3", Integer.parseInt(runMain("3\nQ\n")), equalTo(3));
    }

    @Test
    public void findsMinOfOneNegativeNumber() {
        assertThat("Input: -5", Integer.parseInt(runMain("-5\nQ\n")), equalTo(-5));
    }

    @Test
    public void findsMinOfNegativeAndPositive() {
        assertThat("Input: -5, 5", Integer.parseInt(runMain("-5\n5\nQ\n")), equalTo(-5));
    }

    @Test
    public void findsMinOfPositiveAndNegative() {
        assertThat("Input: 5, -5", Integer.parseInt(runMain("5\n-5\nQ\n")), equalTo(-5));
    }

    @Test
    public void findsMinAscending() {
        assertThat("Input: 6, 7, 8", Integer.parseInt(runMain("6\n7\n8\nQ\n")), equalTo(6));
    }

    @Test
    public void findsMinDescending() {
        assertThat("Input: 8, 7, 6", Integer.parseInt(runMain("8\n7\n6\nQ\n")), equalTo(6));
    }

    @Test
    public void findsMinInMiddle() {
        assertThat("Input: 7, 6, 8", Integer.parseInt(runMain("7\n6\n8\nQ\n")), equalTo(6));
    }

}
