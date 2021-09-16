Question:
---------
Given expression y = ((2 * x * x) - (4 * x) + 12)
int array x = { -6 , -5 , -3 , -2 , 0 , 1 , 3 , 4 , 7}
Evaluate y for every x value and sort all the y values in ascending order.
 
Solution:
---------
 
Time complexity: O(n)
Space Complexity: O(n)

public class sortExpressionValues {
    public static void main(String[] args) {
        int[] x = {-6, -5, -3, -2, 0, 1, 3, 4, 7};
        sortYvalues(x);
        for (int i = 0 ; i < x.length ; i++)
            System.out.print(x[i]+" ");

    }

    public static int[] sortYvalues(int[] x) {
        int index = -1;
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < x.length; i++) {
            int y = ((2 * x[i] * x[i]) - (4 * x[i]) + 12);
            x[i] = y;
            if (minimum > y) {
                minimum = y;
                index = i;
            }
        }
        int i = index - 1, j = index + 1;
        int[] sortedArr = new int[x.length];
        int k = 1;
        while (i >= 0 && j < x.length) {
            if (x[i] < x[j]) {
                sortedArr[k++] = x[i--];
            } else {
                sortedArr[k++] = x[j++];
            }
        }
        while (i >= 0)
            sortedArr[k++] = x[i--];
        while (j < x.length)
            sortedArr[k++] = x[j++];

        sortedArr[0] = minimum;
        for (int p = 0; p < x.length; p++) {
            x[p] = sortedArr[p];
        }
        return x;
    }
}
