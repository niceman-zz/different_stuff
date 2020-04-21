public class CommonsInSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {13, 27, 35, 40, 49, 55, 59};
        int[] arr2 = {17, 35, 39, 40, 55, 58, 60};
        int[] arr3 = {1, 3, 7, 9, 10, 15};
        int[] arr4 = {3, 4, 6, 7, 15, 18};
        printCommon(arr3, arr4);
    }

    static void printCommon(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        while (i < arr1.length) {
            if (arr1[i] == arr2[j]) {
                System.out.println(arr1[i] + ", " + arr2[j]);
                i++; j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
    }
}
