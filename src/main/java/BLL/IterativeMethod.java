package BLL;

public class IterativeMethod {
    public double[] findX(double[][] matrix, int iterate) {
        double[] approx = new double[matrix.length];
        double[] x = new double[matrix.length];
        for (int i = 0; i < iterate; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length - 1; k++) {
                    if (j != k) {
                        x[j] += matrix[j][k] * approx[k];
                    }
                }
                x[j] = -x[j] + matrix[j][matrix[0].length - 1];
                x[j] /= matrix[j][j];
            }

            for (int j = 0; j < approx.length; j++) {
                approx[j] = x[j];
                x[j] = 0;
            }
        }
        return approx;
    }
}
