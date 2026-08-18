import java.util.Arrays;
import java.util.Scanner;

public class SearchMenu {
    static int[] arr;
    static int n;

    // Insert elements
    public static void insertElements(Scanner sc) {
        System.out.print("Enter number of elements: ");
        n = sc.nextInt();
        arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Elements inserted successfully!");
    }

    // Display elements
    public static void displayElements() {
        if (arr == null) {
            System.out.println("No elements inserted yet.");
            return;
        }
        System.out.println("Array elements:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Linear Search
    public static void linearSearch(Scanner sc) {
        if (arr == null) {
            System.out.println("No elements inserted yet.");
            return;
        }
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at position " + (i + 1));
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Element not found.");
        }
    }

    // Binary Search
    public static void binarySearch(Scanner sc) {
        if (arr == null) {
            System.out.println("No elements inserted yet.");
            return;
        }
        Arrays.sort(arr); // ensure sorted
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();
        int low = 0, high = n - 1;
        boolean found = false;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                System.out.println("Element found at position " + (mid + 1));
                found = true;
                break;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (!found) {
            System.out.println("Element not found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n📌 Menu");
            System.out.println("1. Insert Elements");
            System.out.println("2. Display Elements");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: insertElements(sc); break;
                case 2: displayElements(); break;
                case 3: linearSearch(sc); break;
                case 4: binarySearch(sc); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 5);
        sc.close();
    }
}
