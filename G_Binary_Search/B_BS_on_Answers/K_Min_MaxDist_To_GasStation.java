//Minimise Maximum Distance between Gas Stations
package G_Binary_Search.B_BS_on_Answers;

import java.util.*;
public class K_Min_MaxDist_To_GasStation {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the K:");
        int k = input.nextInt();

        //double ans = minimiseMaxDistance(arr, k);

        //OPtimal
        double ans = optimal(arr,k);

        System.out.println("The answer is: " + ans);
    }
    //Brute
    public static double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1]; // Number of gas stations in each segment

        // Place each gas station
        for (int gasStations = 1; gasStations <= k; gasStations++) {
            double maxSection = -1;
            int maxInd = -1;

            // Find the segment with the maximum distance
            for (int i = 0; i < n - 1; i++) {
                double diff = arr[i + 1] - arr[i];
                double sectionLength = diff / (howMany[i] + 1.0);

                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }

            // Add gas station to the selected segment
            howMany[maxInd]++;
        }

        // Find the final max section length after placing all gas stations
        double maxAns = -1;
        for (int i = 0; i < n - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            double sectionLength = diff / (howMany[i] + 1.0);
            maxAns = Math.max(maxAns, sectionLength);
        }

        return maxAns;
    }
    //Optimal
    public static int numberOfGasStationsRequired(double dist, int[] arr) {
        int n = arr.length;
        int count = 0;

        for (int i = 1; i < n; i++) {
            int numberInBetween = (int) ((arr[i] - arr[i - 1]) / dist);
            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }
            count += numberInBetween; //total number of additional gas stations required
        }

        return count;  //total number of additional gas stations required
    }

    // Method to minimize the maximum distance between gas stations
    public static double optimal(int[] arr, int k) {
        int n = arr.length;
        double low = 0, high = 0;

        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }

        double diff = 1e-6;

        while (high - low > diff) {
            double mid = (low + high) / 2.0;
            int count = numberOfGasStationsRequired(mid, arr);

            if (count > k) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return high;
    }
    
}

//OUTPUT
/*
Enter the array size:5        
Enter the array elements:
1 2 3 4 5
Enter the K:2
The answer is: 1.0
*/