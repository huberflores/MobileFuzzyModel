package ee.ut.fuzzylogic.codeoffload.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ee.ut.fuzzylogic.codeoffload.deffuzifyer.CentroidMethod;
import ee.ut.fuzzylogic.codeoffload.deffuzifyer.DefuzzyerMethod;
import ee.ut.fuzzylogic.codeoffload.rules.FuzzyTerm;
import ee.ut.fuzzylogic.codeoffload.rules.Rule;
import ee.ut.fuzzylogic.codeoffload.variables.FuzzySet;
import ee.ut.fuzzylogic.codeoffload.variables.LinguisticVariable;


public class BasicFuzzyController extends FuzzyController {

    /*
     * DefuzzyerMethod
     */
    DefuzzyerMethod defMethod;
    /*
     * List of Variables
     */
    List<LinguisticVariable> variablesList;
    /*
     * list of rules.
     */
    List<Rule> rulesList;
    

    /**
     * Create a new instance of the BasicFuzzyController
     */
    public BasicFuzzyController() {
        variablesList = new ArrayList<LinguisticVariable>();
        rulesList = new ArrayList<Rule>();
        defMethod = new CentroidMethod();
    }

    /**
     * add a new Variable to the Controller.
     *
     * @param lv the Variable to add.
     */
    public void addVariable(LinguisticVariable lv) {
        variablesList.add(lv);
    }

    /**
     * Set the DefuzzifyerMethod to the Controller. By default, this references
     * to an instance of CentroidMethod
     *
     * @param defMethod the metod to set.
     */
    public void setDefuzzifyerMethod(DefuzzyerMethod defMethod) {
        this.defMethod = defMethod;
    }

    /**
     * create and add a new Rule to the Controller.
     *
     * @param ant Antecedent of the Rule
     * @param con Consequent of the Rule
     */
    public void addRule(FuzzyTerm ant, FuzzyTerm con) {
        rulesList.add(new Rule(ant, con));
    }

    /**
     * fuzzify the variable desgined by the label with the given value
     *
     * @param label the label of the variable to fuzzify
     * @param val the input
     */
    public void fuzzify(String label, double val) {
        //System.out.println("FUZZIFYING...");
        for (LinguisticVariable lv : variablesList) {
            if (label.equalsIgnoreCase(lv.getLabel())) {
                lv.fuzziffy(val);
            }
        }
    }

     /**
     * defuzzify the variable designed by the label
     *
     * @param label the label of the variable to fuzzify
     * @return the puntual value.
     */
    public Map<String, Double> defuzzify(String label) {
        //System.out.println("DEFUZZIFYING...");
        setConfidencesOfConsequentsToZero();
        LinguisticVariable lv = null;

        for (LinguisticVariable l : variablesList) {
            if (l.getLabel().equalsIgnoreCase(label)) {
                lv = l;
            }
        }

        if (lv == null) {
            throw new UnsupportedOperationException("HACER NUEVA EXCEPCION PARA ESTO");
        } else {
            this.setConfidencesOfConsequentsToZero();
            for (Rule r : rulesList) {
                r.calculate();
            }
            //System.out.println(lv.getBestLabel());
            HashMap<String, Double> values = new HashMap<String, Double>();
            values.put(lv.getBestLabel(), defMethod.getDefuzziedValue(lv));
            
            //return defMethod.getDefuzziedValue(lv);
            return values;
        }
    }
    
       
/**
 * Private method: used to defuzzify
 */
    private void setConfidencesOfConsequentsToZero() {
        for (Rule r : rulesList) {
            r.getConsequent().clearDOM();
        }
    }
}