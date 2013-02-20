
package ee.ut.fuzzylogic.codeoffload.modifier;

import ee.ut.fuzzylogic.codeoffload.rules.FuzzyTerm;
import ee.ut.fuzzylogic.codeoffload.variables.FuzzySet;


public class FzSet implements FuzzyTerm {
   
    /**
     * References the instance of the FuzzySet
     */
    FuzzySet set;
    /**
     * Modifier of the set
     */
    Modifier mod;
/**
 * Creates an instance of the FzSet Class, acting as a proxy for one FuzzySet Object
 * @param set the FuzzySet instance.
 */
    public FzSet(FuzzySet set) {
        this.set = set;
        this.mod = Modifier.NORMAL;
    }

    /**
     * Creates an instance of the FzSet Class,
     * acting as a proxy for one FuzzySet Object
     * also generate the values acording to the modifier <code>VERY</code> or
     * <code> FAIRLY </code>
     * @param set
     * @param mod 
     */
    public FzSet(FuzzySet set, Modifier mod) {
        this.set = set;
        this.mod = mod;
    }

    /**
     * Generate a copy of this object, but using the modifier FAIRLY
     * @return a copy of the object, referencing to the same FuzzySet
     */
    public FzSet fairly() {
        return new FzSet(set, Modifier.FAIRLY);
    }
    
    /**
     * Generate a copy of this object, but using the modifier FAIRLY
     * @return a copy of the object, referencing to the same FuzzySet
     */
    public FzSet very() {
        return new FzSet(set, Modifier.VERY);
    }
/**
 * Return the Degree of Membership of the FuzzySet. 
 * @return 
 */
    @Override
    public double getDOM() {
        switch (mod) {
            case NORMAL:
                return set.getDOM();
            case VERY:
                return Math.sqrt(set.getDOM());
            case FAIRLY:
                return Math.pow(set.getDOM(), 2);
        }
        return -1;
    }
/**
 * Set the degree of membership of the FuzzySet to zero
 */
    @Override
    public void clearDOM() {
        set.clearDOM();
    }
/**
 * Use the Fuzzy Operator OR to compare both (the actual degree and the given), 
 * set the result as the degree of membership in the FuzzySet.
 * @param val the input to compare
 */
    @Override
    public void orWithDOM(double val) {
        set.orWithDOM(val);
    }
//
//    public static void main(String arg[]) throws FunctionException {
//        FuzzySet fs = new FuzzySet("LOL", new TriangularMembershipFunction(10, 50));
//        fs.orWithDOM(30);
//        System.out.println(fs.getDOM());
//        FzSet fz = new FzSet(fs);
//        System.out.println(fz.getDOM());
//    }
}
