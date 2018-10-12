package PL;

import BLL.IterativeMethod;

public class ConsolePL implements Runnable {
    private static final int ITERATE = 1000000;

    private IterativeMethod iterativeMethod = new IterativeMethod();

    double[][] matrix = new double[][]{
            {0.450, 0.030, -0.01, 0.020, -0.111, 2.491},
            {0.020, 0.375, -0.01, 0.010, 0.000, 1.275},
            {0.000, 0.0700, 0.440, 0.000, 0.113, -0.738},
            {-0.03, 0.015, -0.02, 0.41, -0.084, 0.429},
            {0.020, 1.000, 0.000, 0.000, 0.290, -0.16},
    };

    public void run() {
        double[] x = iterativeMethod.findX(matrix, ITERATE);
        for (int i = 0; i < x.length; i++) {
            System.out.println("x" + i + " " + x[i]);
        }

        System.out.println("невязка");
        double[] residual = getResidual(matrix, x);

        double residualOne = 0;
        for (int i = 0; i < x.length; i++) {
            System.out.println("x" + i + " " + residual[i]);
            residualOne += Math.abs(residual[i]);
        }
        System.out.println("невязка = " + residualOne);

    }

    private double[] getResidual(double[][] matrix, double[] x) {
        double[] residual = new double[x.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                residual[i] += matrix[i][j] * x[j];
            }
            residual[i] -= matrix[i][matrix[0].length - 1];
        }

        return residual;
    }
}
