package src;

public class SelectionSortChar {

    public static int findIndexOfMinValue(char[] array, int startIndex) {
        int minIndex = startIndex;
        for (int i = startIndex + 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void selectionSort(char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = findIndexOfMinValue(array, i);
            char temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
