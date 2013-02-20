package ee.ut.fuzzylogic.codeoffload.functions;


public class TrapezoidalMembershipFunction implements MembershipFunction {
	
	
    /**
     * The a point of the trapezoid 
     */
    private double a;
    /**
     * The b point of the trapezoid 
     */
    private double b;
    /**
     * The c point of the trapezoid 
     */
    private double c;
    /**
     * The d point of the trapezoid 
     */
    private double d;

    /**
     * 
     * @param a
     * @param b
     * @param c
     * @param d 
     */
    public TrapezoidalMembershipFunction(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    /**
     * 
     * @param a
     * @param b
     * @param c
     * @param right 
     */
    public TrapezoidalMembershipFunction(double a, double b, double c, boolean right) {
        if (!right) {
        	/**  ------
        	 * 		   \
        	 * 			\
        	 * 			 \
        	 * 			  \
        	 */
        	
            this.a = a;
            this.b = a;
            this.c = b;
            this.d = c;
        } else {
        	
        	/**     ------
        	 * 	   /   
        	 * 	  /	
        	 * 	 /	
        	 * 	/	
        	 */
        	
        	
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = c;
        }
    }

    /**
     * @param input the value x of f(x). 
     * @return double the result of the function.
     */
    @Override
    public double getValue(double input) {
        double result = 0;
        if (input >= a && input <= b) {
            result = (input - a) / (b - a);
            return result;
        }
        if (input >= b && input <= c) {
            result = 1;
            return result;
        }
        if (input >= c && input <= d) {
            result = (input - d) / (c - d);
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
        double flag = 0;
        if (input >= a && input <= b) {
            flag = (input - a) / (b - a);
            if (result < clip) {
                result = flag;
            } else {
                result = clip;
            }
        }
        if (input >= b && input <= c) {
            flag = 1;
            if (flag < clip) {
                result = flag;
            } else {
                result = clip;
            }
        }
        if (input >= c && input <= d) {
            flag = (input - d) / (c - d);
        }
        if (flag < clip) {
            result = flag;
        } else {
            result = clip;
        }
        return result;
    }

    /**
     * @return the maximum (not infinity) value of the function, 
     * warning
     */
    @Override
    public double getMax() {
        if (Double.isInfinite(d)) {
            if (Double.isInfinite(c)) {
                if (Double.isInfinite(b)) {
                    return a;
                }
                return b;
            }
            return c;
        }
        return d;
    }

    /**
     * @return the minimum (not infinity) value of the function, 
     * warning
     */
    @Override
    public double getMin() {
        if (Double.isInfinite(a)) {
            if (Double.isInfinite(b)) {
                if (Double.isInfinite(c)) {
                    return d;
                }
                return c;
            }
            return b;
        }
        return a;
    }
}
