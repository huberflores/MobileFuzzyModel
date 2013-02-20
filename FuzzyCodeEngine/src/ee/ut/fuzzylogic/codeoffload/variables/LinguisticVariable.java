package ee.ut.fuzzylogic.codeoffload.variables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import ee.ut.fuzzylogic.codeoffload.functions.MembershipFunction;
import ee.ut.fuzzylogic.codeoffload.modifier.FzSet;


/**
 * author Huber Flores
 */

public class LinguisticVariable {

	/**
	 * Fuzzy variable
	 * (e.g. Bandwidth)
	 */
	private String label;
	
	/**
	 * Possible values of the Fuzzy variable
	 * (e.g. Bandwidth -> Slowest, Slow, Normal, Fast, Fastest)
	 */
	private List<FuzzySet> possibleValues;
	
	/**
	 * Constructor
	 */
	public LinguisticVariable(String label){
		this.label = label;
		possibleValues = new ArrayList<FuzzySet>();
	}
	
	
	/**
     * @return possible values of the variable
     */
	public List<FuzzySet> getSetList() {
        return possibleValues;
    }
	
	 /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }
    
    /**
     * Fuzzify the sets of the Variable given an input.
     *
     * @param input the input
     */
    public void fuzziffy(double input) {
        for (FuzzySet fs : possibleValues) {
            fs.calculateDOM(input);
        }
    }
	
	/**
    *
    * Add a FuzzySet to the LinguisticVariable Object, also return a FzSet
    * reference FzSetReferences is used to create the Rules.
    *
    * @param label the label of the set
    * @param MembershipFunction the function of the set
    * @return FzSet reference, act as a proxy of the FuzzySet instance, used to
    * create the Rules
    * @throws IllegalSetException when the set is already in the Variable
    */
   public FzSet addSet(String setLabel, MembershipFunction MembershipFunction) throws IllegalSetException {
       FuzzySet set = new FuzzySet(setLabel, MembershipFunction);
       for (FuzzySet fs : possibleValues) {
           if (set.equals(fs)) {
               throw new IllegalSetException("The label " + set.getLabel() + ""
                       + " is already registered");
           }
       }

       possibleValues.add(set);
       return new FzSet(set);

   }
   
   /**
    * @return The maximum (non infinity) value. Used to defuzzify proccess
    */
   public double getMax() {
       double flag = 0;
       double max = 0;
       for (FuzzySet fs : possibleValues) {
           max = fs.getMembershipFunction().getMax();
           if (flag < max) {
               flag = max;
           }
       }
       return flag;
   }

   /**
    *
    * @return The minimum (non infinity) value. Used to defuzzify proccess
    */
   public double getMin() {
       double flag = 0;
       double min = 0;
       for (FuzzySet fs : possibleValues) {
           min = fs.getMembershipFunction().getMin();
           if (flag > min) {
               flag = min;
           }
       }
       return flag;
   }

   /**
    * @return the label of the set with the highest degree of membership
    */
   public String getBestLabel() {
       double flag = 0;
       String labelFlag = "";
       for (FuzzySet fs : possibleValues) {
           double value = fs.getDOM();
           if (value > flag) {
               labelFlag = fs.getLabel();
           }
       }
       return labelFlag;
   }
   	
	
}
