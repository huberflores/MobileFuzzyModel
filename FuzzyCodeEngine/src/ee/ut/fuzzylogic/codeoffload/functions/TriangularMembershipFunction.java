
package ee.ut.fuzzylogic.codeoffload.functions;


public class TriangularMembershipFunction implements MembershipFunction {

    /**
     * The left point of the triangle
     */
    private double a;
    /**
     * The right point of the triangle
     */
    private double b;
    /**
     * The central point of the triangle or its center
     */
    private double c;

    /**
     * 
     * @param a The left point of the triangle x when y=0
     * @param b The right point of the triangle x when y=0
     * @param c The central point of the triangle x when y=1
     * @exception FunctionException if at least one of the values in the 
     * constructor is infinity
     */
    public TriangularMembershipFunction(double a, double b, double c) throws FunctionException {
        if (!Double.isInfinite(a) || !Double.isInfinite(b) || !Double.isInfinite(c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            throw new FunctionException("the construtor must have non-infinity double values only");
        }
    }

    /**
     * This constructor create a new instance of <code> TriangularMembershipFunction</code>
     * taking the central point as the middle point between a and b.
     * c=(a+b)/2
     * @param a The left point of the triangle x when y=0
     * @param b The right point of the triangle x when y=0
     * @exception FunctionException if at least one of the values in the 
     * constructor is infinity
     */
    public TriangularMembershipFunction(double a, double b) throws FunctionException {
        if (!Double.isInfinite(a) || !Double.isInfinite(b) || !Double.isInfinite(c)) {
            this.a = a;
            this.b = b;
            this.c = (a + b) / 2;
        } else {
            throw new FunctionException("the construtor must have non-infinity double values only");
        }
    }

    /**
     * @param input the value x of f(x). 
     * @return double the result of the function.
     */
    @Override
    public double getValue(double input) {
        double result = 0;
        if (input >= a && input <= c) {
            result = (input - a) / (c - a);
            return result;
        } else if (input >= c && input <= b) {
            result = (input - b) / (c - b);
            return result;
        }
        return result;
    }

    /**
     * 
     * @param input the value x of f(x). 
     * @param clip the value to clip: if result > clip then return clip.
     * @return double the result of the function if it is under clip,
     * else return the clip value
     */
    @Override
    public double getClippedValue(double input, double clip) {
        double result = 0;
        if (input >= a && input <= c) {
            result = (input - a) / (c - a);
            if (result < clip) {
                return result;
            } else {
                return clip;
            }
        } else if (input >= c && input <= b) {
            result = (input - b) / (c - b);
            if (result < clip) {
                return result;
            } else {
                return clip;
            }
        }
        return result;
    }

    /**
     * @return the maximum (not infinity) value of the function, 
     * b-point in this case.
     */
    @Override
    public double getMax() {
        return b;
    }

    /**
     * @return the minimum (not infinity) value of the function, 
     * a-point in this case.
     */
    @Override
    public double getMin() {
        return a;
    }
}
