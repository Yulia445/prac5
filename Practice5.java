import java.util.Random;

//double version

public class Practice5 {
    public static void main(String[] args) {
        Random rand = new Random();
        double[] randomArray = new double[10];

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = rand.nextDouble() * 10;
        }

        System.out.println("Before:");
        printArray(randomArray);

        quickSort(randomArray, 0, randomArray.length - 1);

        System.out.println("After:");
        printArray(randomArray);
    }

    private static void quickSort(double[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex + 1) + lowIndex;
        double pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);

        int leftPointer = partition(array, lowIndex, highIndex, pivot);

        quickSort(array, lowIndex, leftPointer - 1);
        quickSort(array, leftPointer + 1, highIndex);
    }

    private static int partition(double[] array, int lowIndex, int highIndex, double pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }

        swap(array, leftPointer, highIndex);

        return leftPointer;
    }

    private static void swap(double[] array, int index1, int index2) {
        double temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.2f ", array[i]);
        }
        System.out.println();
    }
}
