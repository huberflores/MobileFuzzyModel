
package ee.ut.fuzzylogic.codeoffload.variables;

import ee.ut.fuzzylogic.codeoffload.controller.FuzzyOp;
import ee.ut.fuzzylogic.codeoffload.functions.MembershipFunction;




public class FuzzySet {

    /**
     * The label of the Set
     */
    private String label;
    /**
     * The function that defines this set
     */
    private MembershipFunction function;
    /**
     * The degree bounded to this set to defuzzify
     */
    private double degree;

    /**
     * Creates a new instance of FuzzySet.
     * @param label the label of the set
     * @param function the MembershipFunction that define the Set.
     */
    public FuzzySet(String label, MembershipFunction function) {
        this.label = label;
        this.function = function;
        this.degree = 0;
    }
    /**
     * Return directly the result of a given input in the set
     * without set it as a degree of membership.
     * @param input the input to test
     * @return the value of the 
     */
    public double getNormalValue(double input) {
        return function.getValue(input);
    }
    /**
     * Return directly the result of a given input in the set
     * with the modifier FAIRLY and without set it as a degree of membership.
     * @param input the input to test
     * @return the value of the 
     */
    public double getFairlyValue(double input) {
        return Math.sqrt(function.getValue(input));
    }
    /**
     * Return directly the result of a given input in the set
     * with the modifier VERY and without set it as a degree of membership.
     * @param input the input to test
     * @return the value of the 
     */
    public double getVeryValue(double input) {
        return Math.pow(function.getValue(input), 2);
    }
    /**
     * return true if the given object has the same label that this.
     * @param obj the reference of the object to compare.
     * @return true if the two objects are equals, else false.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FuzzySet) {
            return getLabel().equalsIgnoreCase(obj.toString()) ? true : false;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return getLabel();
    }
    /**
     * 
     * @return the degree of membership bounded to this set
     */
    public double getDOM() {
        return degree;
    }
    /**
     * set the degree of membership of this set to zero
     */
    public void clearDOM() {
        degree = 0;
    }
    /**
     * Use the Fuzzy Operator OR with the current degree of membership
     * and the given input, then set the result to the degree value of the set
     */
    public void orWithDOM(double val) {
        degree = FuzzyOp.or(degree, val);
    }
/**
     * Calculate the degree of membership of a given input, and set it to this 
     * FuzzySet, also return the same value.
     * @param input the input to test
     * @return the result of calculate the degree of membership of the given input
     * with this set
     */
    public double calculateDOM(double input) {
        degree = function.getValue(input);
        return function.getValue(input);
    }

    
    public double getClippedValue(double input) {
        return function.getClippedValue(input, degree);
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the function
     */
    public MembershipFunction getMembershipFunction() {
        return function;
    }

    /**
     * @param function the function to set
     */
    public void setMembershipFunction(MembershipFunction function) {
        this.function = function;
    }
}
