import java.io.FileReader;
import java.math.BigInteger;
import java.util.*;
import org.json.JSONObject;
import org.json.JSONTokener;

public class PolynomialFromJSON {

    // Perform Lagrange Interpolation
    public static double[] lagrangeInterpolation(double[] x, double[] y, int k) {
        double[] coeffs = new double[k];
        Arrays.fill(coeffs, 0.0);

        for (int i = 0; i < k; i++) {
            double[] basis = new double[k];
            basis[0] = 1.0;

            double denom = 1.0;
            int degree = 0;

            for (int j = 0; j < k; j++) {
                if (i != j) {
                    for (int d = degree; d >= 0; d--) {
                        basis[d + 1] += basis[d];
                        basis[d] *= -x[j];
                    }
                    degree++;
                    denom *= (x[i] - x[j]);
                }
            }

            double scale = y[i] / denom;
            for (int d = 0; d <= degree; d++) {
                coeffs[d] += basis[d] * scale;
            }
        }
        return coeffs;
    }

    public static void main(String[] args) {
        try {
            // Load JSON file (replace with your file name)
            FileReader reader = new FileReader("testcase.json");
            JSONObject json = new JSONObject(new JSONTokener(reader));

            JSONObject keys = json.getJSONObject("keys");
            int n = keys.getInt("n");
            int k = keys.getInt("k");

            double[] x = new double[k];
            double[] y = new double[k];

            int idx = 0;
            for (String key : json.keySet()) {
                if (!key.equals("keys") && idx < k) {
                    JSONObject obj = json.getJSONObject(key);
                    int base = Integer.parseInt(obj.getString("base"));
                    String valueStr = obj.getString("value");

                    // Decode y in given base
                    BigInteger yValBig = new BigInteger(valueStr, base);
                    long yVal = yValBig.longValue();

                    x[idx] = Integer.parseInt(key);
                    y[idx] = (double) yVal;
                    idx++;
                }
            }

            // Perform interpolation
            double[] coeffs = lagrangeInterpolation(x, y, k);

            // Print coefficients
            System.out.println("Polynomial Coefficients (constant term first):");
            for (int i = 0; i < coeffs.length; i++) {
                System.out.printf("a%d = %.4f\n", i, coeffs[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
