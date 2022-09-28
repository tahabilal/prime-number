package primenumber;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberFinder {

    private PrimeNumberFinder() {
    }
    private static final ArrayList<Integer> primeNumberList = new ArrayList<>();

    public static long primeNumberDivideAllElement(int primeNumberCount) {
        long divideAllElementsNumberOfComparisons = 0;
        int i = 2;
        int j;
        int primeNumbers = 0;
        while (primeNumbers != primeNumberCount) {
            divideAllElementsNumberOfComparisons++;
            if (i == 2) {
                primeNumbers++;
            }
            for (j = 2; j < i; j++) {
                divideAllElementsNumberOfComparisons++;
                if (i % j == 0) break;
                divideAllElementsNumberOfComparisons++;
                if (i == (j + 1)) {
                    primeNumbers++;
                }
            }
            i++;
        }
        return divideAllElementsNumberOfComparisons;
    }

    public static long primeNumberDivideHalfElement(int primeNumberCount) {
        long divideHalfOfElementsNumberOfComparisons = 0;
        int i = 2;
        int j;
        int primeNumbers = 0;
        while (primeNumbers != primeNumberCount) {
            divideHalfOfElementsNumberOfComparisons++;
            if (i == 2 || i == 3 || i == 5) {
                primeNumbers++;
            }
            for (j = 2; j < i / 2; j++) {
                divideHalfOfElementsNumberOfComparisons++;
                if (i % j == 0) break;
                divideHalfOfElementsNumberOfComparisons++;
                if ((i / 2) == (j + 1)) {
                    primeNumbers++;
                }
            }
            i++;
        }
        return divideHalfOfElementsNumberOfComparisons;
    }

    public static long primeNumberDivideRootElement(int primeNumberCount) {
        long divideRootOfElementsNumberOfComparisons = 0;
        int i = 2;
        int j;
        int k;
        int primeNumbers = 0;
        while (primeNumbers != primeNumberCount) {
            divideRootOfElementsNumberOfComparisons++;
            if (i == 2 || i == 3 || i == 5 || i == 7) {
                primeNumberList.add(i);
                primeNumbers++;
                i++;
                continue;
            }
            k = (int) Math.sqrt(i);
            for (j = 2; j <= k; j++) {
                divideRootOfElementsNumberOfComparisons++;
                if (i % j == 0) break;
                divideRootOfElementsNumberOfComparisons++;
                if (k < (j + 1)) {
                    primeNumberList.add(i);
                    primeNumbers++;
                }
            }
            i++;
        }
        return divideRootOfElementsNumberOfComparisons;
    }

    public static List<Integer> getPrimeNumberList() {
        return primeNumberList;
    }
}
