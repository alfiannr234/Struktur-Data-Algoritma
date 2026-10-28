import java.util.Arrays;

class InsertionSortAnalysis {

    public static void main(String[] args) {
        int totalData = 100;
        int[] data = new int[totalData];

        for (int i = 0; i < totalData; i++) {
            data[i] = i + 1;
        }

        int outOfPlaceVal = data[90];

        for (int i = 90; i > 10; i--) {
            data[i] = data[i - 1];
        }
        data[10] = outOfPlaceVal;

        int[] previewBefore = Arrays.copyOfRange(data, 1, 100);
        System.out.println(Arrays.toString(previewBefore) + " ...\n");

        insertionSortAnalysis(data);
    }

    public static void insertionSortAnalysis(int[] arr) {
        int n = arr.length;
        long comparisons = 0;
        long shifts = 0;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            comparisons++;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                shifts++;
                j--;

                if (j >= 0) {
                    comparisons++;
                }
            }
            arr[j + 1] = key;
        }

        System.out.println("Beberapa elemen array setelah sorting:");
        int[] previewAfter = Arrays.copyOfRange(arr, 1, 100);
        System.out.println(Arrays.toString(previewAfter) + " ...\n");

        System.out.println("=== Hasil Analisis ===");
        System.out.println("Total Elemen Data    : " + n);
        System.out.println("Total Perbandingan   : " + comparisons);
        System.out.println("Total Pergeseran     : " + shifts);
    }
}