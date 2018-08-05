/**
 * Created by Siddharth on 10/6/16.
 */
public class Matrix {

    public boolean isSymmetric(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        if (m != n) {
            return false;
        }

        for (m = 0; m < matrix.length; m++) {
            for (n = 0; n < matrix.length; n++) {
                if (matrix[m][n] != matrix[n][m]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isDiagonal(int[][] matrix) {


        for (int m = 0; m < matrix.length; m++) {
            for (int n = 0; n < matrix.length; n++) {
                if (m != n) {
                    if (matrix[m][n] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isIdentity(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        if (m != n) {
            return false;
        }

        for (m = 0; m < matrix.length; m++) {
            for (n = 0; n < matrix[0].length; n++) {
                if (m != n && matrix[m][n] != 0) {
                    return false;
                } else if (m == 0 && matrix[m][n] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isUpperTriangle(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        if (m != n) {
            return false;
        }

        for (m = 0; m < matrix.length; m++) {
            for (n = 0; n < matrix[0].length; n++) {
                if (m < n && matrix[m][n] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isTridiagonal(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        if (m != n) {
            return false;
        }

        for (m = 0; m < matrix.length; m++) {
            for (n = 0; n < matrix[0].length; n++) {
                if ((m == n)) {
                    if(matrix[m][n] == 0)
                        return false;
                } else if ((m - 1 == n)) {
                    if(matrix[m][n] == 0)
                        return false;
                } else if ((m + 1 == n)) {
                    if(matrix[m][n] == 0)
                        return false;
                } else {
                    if(matrix[m][n] != 0)
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Matrix m = new Matrix();
        int[][] isSymmetric = {
                {1,3,0,0},
                {2,1,2,0},
                {0,3,1,4},
                {0,0,1,1}
        };

        System.out.println(m.isTridiagonal(isSymmetric));
    }
}