
public class Solution {

    public int calPoints(String[] operations) {

        final int MAX_NUMBER_OF_OPERATIONS = 1000;
        int[] scores = new int[MAX_NUMBER_OF_OPERATIONS];
        int index = 0;

        for (String operation : operations) {
            if (operation.equals("+")) {
                scores[index] = scores[index - 1] + scores[index - 2];
            } else if (operation.equals("C")) {
                scores[index - 1] = 0;
                index -= 2;
            } else if (operation.equals("D")) {
                scores[index] = 2 * scores[index - 1];
            } else {
                scores[index] = Integer.parseInt(operation);
            }
            ++index;
        }

        /*
        The array is too small to justify the overhead of streams.  
        Slower alternatives to the loop for this particular problem:
        Arrays.stream(scores).limit(index).sum();
        Arrays.stream(scores, 0, index).parallel().sum();
         */
        int sumAllScores = 0;
        for (int i = 0; i < index; i++) {
            sumAllScores += scores[i];
        }
        return sumAllScores;
    }
}
