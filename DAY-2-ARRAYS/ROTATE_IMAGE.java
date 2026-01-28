Q] You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

  class Solution {
    public void rotate(int[][] matrix) {
        int[][]nums=new int[matrix.length][matrix[0].length];
        int rows=matrix.length;
        int cols=matrix[0].length;
       for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
            nums[j][i]=matrix[i][j];
        }
       } 
       for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
        matrix[i][cols-j-1]=nums[i][j];
        }
        
       } 
       
    }
}
