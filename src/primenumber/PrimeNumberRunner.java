package primenumber;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.*;

public class PrimeNumberRunner {
    private final double MILLIS_TO_SEC = 1000.0;
    private final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.0000");

    public void runAlgorithmsAndGetResults() throws IOException {
        ExportData exportData = new ExportData();
        int countOfPrimeNumbers;
        double totalTime;
        double startTime;
        long numberOfComparisons;

        out.println("******   Welcome to prime number finder   ******\n");
        out.println("How many prime numbers do you want to find? (If you want to compare elapsed time, find 1000 or more prime numbers)");
        out.print("Please enter: ");
        countOfPrimeNumbers = numericValueCheck();

        out.println("\nFinding # of prime numbers: " + countOfPrimeNumbers);

        startTime = currentTimeMillis() / MILLIS_TO_SEC;
        numberOfComparisons = PrimeNumberFinder.primeNumberDivideAllElement(countOfPrimeNumbers);
        totalTime = currentTimeMillis() / MILLIS_TO_SEC - startTime;
        out.println("Total time for dividing all numbers:     " + DECIMAL_FORMAT.format(totalTime) + " seconds -- # of comparisons: " + numberOfComparisons);
        exportData.setComparisonsForAllElements(numberOfComparisons);
        exportData.setElapsedTimeForAllElements(DECIMAL_FORMAT.format(totalTime));

        startTime = currentTimeMillis() / MILLIS_TO_SEC;
        numberOfComparisons = PrimeNumberFinder.primeNumberDivideHalfElement(countOfPrimeNumbers);
        totalTime = currentTimeMillis() / MILLIS_TO_SEC - startTime;
        out.println("Total time for dividing half of numbers: " + DECIMAL_FORMAT.format(totalTime) + " seconds -- # of comparisons: " + numberOfComparisons);
        exportData.setComparisonsForHalfOfElements(numberOfComparisons);
        exportData.setElapsedTimeForHalfOfElements(DECIMAL_FORMAT.format(totalTime));

        startTime = currentTimeMillis() / MILLIS_TO_SEC;
        numberOfComparisons = PrimeNumberFinder.primeNumberDivideRootElement(countOfPrimeNumbers);
        totalTime = currentTimeMillis() / MILLIS_TO_SEC - startTime;
        out.println("Total time for dividing root of numbers: " + DECIMAL_FORMAT.format(totalTime) + " seconds -- # of comparisons: " + numberOfComparisons);
        exportData.setComparisonsForRootOfElements(numberOfComparisons);
        exportData.setElapsedTimeForRootOfElements(DECIMAL_FORMAT.format(totalTime));
        exportData.setNumberList(PrimeNumberFinder.getPrimeNumberList());

        out.println("Prime number list: " + PrimeNumberFinder.getPrimeNumberList());

        export(exportData);
    }

    private int numericValueCheck() {
        Scanner scanner = new Scanner(in);
        boolean numericValue = false;
        String regex = ".*[a-zA-Z].*";
        Pattern pattern = Pattern.compile(regex);
        String input = "";
        Matcher matcherText;
        while (!numericValue) {
            numericValue = true;
            input = scanner.nextLine();
            matcherText = pattern.matcher(input);
            if (input.equals("")) {
                out.println("Input can not be empty");
                numericValue = false;
            } else if (matcherText.matches()) {
                out.println("Input must not contains any letter");
                numericValue = false;
            } else if (Integer.parseInt(input) >= 1000000) {
                out.println("It may take too long for values greater than 1000000");
                out.println("Are you sure?(y/n)");
                if (!scanner.nextLine().equalsIgnoreCase("y")) {
                    out.print("Please enter new value: ");
                    numericValue = false;
                }
            }
        }
        return Integer.parseInt(input);
    }

    private void exportResult(ExportData exportData, boolean includedPrimeList) throws IOException {
        File file = new File("results\\result.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);
            fw.write("Finding # of prime numbers: " + exportData.getNumberList().size());
            fw.write("\n");
            fw.write("Total time for dividing all numbers:          " + exportData.getElapsedTimeForAllElements() + " seconds    --    # of comparisons: " + exportData.getComparisonsForAllElements());
            fw.write("\n");
            fw.write("Total time for dividing half of  numbers:     " + exportData.getElapsedTimeForHalfOfElements() + " seconds    --    # of comparisons: " + exportData.getComparisonsForHalfOfElements());
            fw.write("\n");
            fw.write("Total time for dividing root of numbers:      " + exportData.getElapsedTimeForRootOfElements() + " seconds    --    # of comparisons: " + exportData.getComparisonsForRootOfElements());
            if(includedPrimeList) {
                fw.write("\n");
                fw.write("****  Prime Number List  ****");
                fw.write("\n");
                fw.write(exportData.formatNumberListAsString());
            }
            fw.write("\n");
            fw.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert fw != null;
        fw.close();
    }

    private void export(ExportData exportData) throws IOException {
        Scanner scanner = new Scanner(in);
        out.println("Do you want to export the result?(y/n)");
        if(scanner.nextLine().equalsIgnoreCase("y")){
            out.println("Do you want prime number list in the result?(y/n)");
            exportResult(exportData, scanner.nextLine().equalsIgnoreCase("y"));
        }
    }
}
