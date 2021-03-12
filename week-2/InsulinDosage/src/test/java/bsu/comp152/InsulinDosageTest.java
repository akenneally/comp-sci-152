package bsu.comp152;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsulinDosageTest {

    private double firstAnswer;
    private double secondAnswer;
    private double thirdAnswer;
    private double fourthAnswer;


    @BeforeEach
    private void setup() {
        this.firstAnswer = 6.0;
        this.secondAnswer = 6.181818181818182;
        this.thirdAnswer = 6.2;
        this.fourthAnswer = 6.381818181818183;
    }

    @Test
    public void dosageReturnsAnswerTo6DecimalPlaces() {
        assertThat(InsulinDosage.dosage(220, 100, 10, 60, 2),
                   closeTo(secondAnswer, 1E-6));
    }

    private ArrayList<Double> extractNumbers(String rawOutput) {
        // match numbers in output
        String regex = "\\d+(\\.\\d+)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rawOutput);
        ArrayList<Double> numbers = new ArrayList<Double>();
        while (matcher.find()) {
            numbers.add(Double.parseDouble(matcher.group()));
        }
        return numbers;
    }

    private String getOutputFromMain() {
        ByteArrayOutputStream fakeSysOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeSysOut));
        InsulinDosage.main(new String[]{});
        return fakeSysOut.toString();
    }

    @Test
    public void dosageCalculatesFirstAnswer() {
        assertThat(InsulinDosage.dosage(210,100,10,60,2),
                   closeTo(firstAnswer, 1E-6));
    }

    @Test
    public void mainPrintsFirstAnswer() {
        String fromSysOut = getOutputFromMain();
        ArrayList<Double> outputNumbers = extractNumbers(fromSysOut);
        assertThat(outputNumbers, hasItem(closeTo(firstAnswer, 1E-6)));
    }

    @Test
    public void dosageCalculatesSecondAnswer() {
        assertThat(InsulinDosage.dosage(220,100,10,60,2),
                closeTo(secondAnswer, 1E-6));
    }

    @Test
    public void mainPrintsSecondAnswer() {
        String fromSysOut = getOutputFromMain();
        ArrayList<Double> outputNumbers = extractNumbers(fromSysOut);
        assertThat(outputNumbers, hasItem(closeTo(secondAnswer, 1E-6)));
    }

    @Test
    public void dosageCalculatesThirdAnswer() {
        assertThat(InsulinDosage.dosage(210,100,10,62,2),
                closeTo(thirdAnswer, 1E-6));
    }

    @Test
    public void mainPrintsThirdAnswer() {
        String fromSysOut = getOutputFromMain();
        ArrayList<Double> outputNumbers = extractNumbers(fromSysOut);
        assertThat(outputNumbers, hasItem(closeTo(thirdAnswer, 1E-6)));
    }

    @Test
    public void dosageCalculatesFourthAnswer() {
        assertThat(InsulinDosage.dosage(220,100,10,62,2),
                   closeTo(fourthAnswer, 1E-6));
    }

    @Test
    public void mainPrintsFourthAnswer() {
        String fromSysOut = getOutputFromMain();
        ArrayList<Double> outputNumbers = extractNumbers(fromSysOut);
        assertThat(outputNumbers, hasItem(closeTo(fourthAnswer, 1E-6)));
    }

}
