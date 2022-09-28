package primenumber;

import java.util.List;

public class ExportData {
    private List<Integer> numberList;
    private String elapsedTimeForAllElements;
    private String elapsedTimeForHalfOfElements;
    private String elapsedTimeForRootOfElements;
    private long comparisonsForAllElements;
    private long comparisonsForHalfOfElements;
    private long comparisonsForRootOfElements;

    public List<Integer> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public String getElapsedTimeForAllElements() {
        return elapsedTimeForAllElements;
    }

    public void setElapsedTimeForAllElements(String elapsedTimeForAllElements) {
        this.elapsedTimeForAllElements = elapsedTimeForAllElements;
    }

    public String getElapsedTimeForHalfOfElements() {
        return elapsedTimeForHalfOfElements;
    }

    public void setElapsedTimeForHalfOfElements(String elapsedTimeForHalfOfElements) {
        this.elapsedTimeForHalfOfElements = elapsedTimeForHalfOfElements;
    }

    public String getElapsedTimeForRootOfElements() {
        return elapsedTimeForRootOfElements;
    }

    public void setElapsedTimeForRootOfElements(String elapsedTimeForRootOfElements) {
        this.elapsedTimeForRootOfElements = elapsedTimeForRootOfElements;
    }

    public long getComparisonsForAllElements() {
        return comparisonsForAllElements;
    }

    public void setComparisonsForAllElements(long comparisonsForAllElements) {
        this.comparisonsForAllElements = comparisonsForAllElements;
    }

    public long getComparisonsForHalfOfElements() {
        return comparisonsForHalfOfElements;
    }

    public void setComparisonsForHalfOfElements(long comparisonsForHalfOfElements) {
        this.comparisonsForHalfOfElements = comparisonsForHalfOfElements;
    }

    public long getComparisonsForRootOfElements() {
        return comparisonsForRootOfElements;
    }

    public void setComparisonsForRootOfElements(long comparisonsForRootOfElements) {
        this.comparisonsForRootOfElements = comparisonsForRootOfElements;
    }

    public String formatNumberListAsString() {
        String list = "[";
        for (int i = 0; i < numberList.size(); i++) {
            if (i % 20 == 0 && i != 0) {
                list = list.concat("\n");
            }
            if ((i + 1) >= numberList.size()) {
                list = list.concat(numberList.get(i).toString() + "]");
                break;
            }
            list = list.concat(numberList.get(i).toString() + ", ");
        }
        return list;
    }
}
