You are given:

An integer T → number of test cases (or array length).

Next T lines each contain two binary strings m and n.

👉 Task:

For each pair:

Convert both binary strings to decimal.

Compute their sum.

Convert the sum back to binary.

Among all computed binary sums, return the maximum binary sum.



class Solution {
    public String maxBinarySum(String[][] arr) {

        int max = 0;

        for (int i = 0; i < arr.length; i++) {

            String str1 = arr[i][0];
            String str2 = arr[i][1];

            int dec1 = Integer.parseInt(str1, 2);
            int dec2 = Integer.parseInt(str2, 2);

            int currSum = dec1 + dec2;

            max = Math.max(currSum, max);
        }

        // convert max decimal back to binary
        return Integer.toBinaryString(max);
    }
}


