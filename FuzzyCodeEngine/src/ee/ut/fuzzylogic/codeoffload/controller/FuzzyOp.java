
package ee.ut.fuzzylogic.codeoffload.controller;

import ee.ut.fuzzylogic.codeoffload.comparator.FuzzyAND;
import ee.ut.fuzzylogic.codeoffload.comparator.FuzzyNOT;
import ee.ut.fuzzylogic.codeoffload.comparator.FuzzyOR;
import ee.ut.fuzzylogic.codeoffload.rules.FuzzyTerm;




public class FuzzyOp {

    public static double and(double a, double b) {
        return Math.min(a, b);
    }

    public static FuzzyTerm and(FuzzyTerm a, FuzzyTerm b) {
        return new FuzzyAND(a, b);
    }

    public static FuzzyTerm or(FuzzyTerm a, FuzzyTerm b) {
        return new FuzzyOR(a, b);
    }

    public static FuzzyTerm not(FuzzyTerm a) {
        return new FuzzyNOT(a);
    }

    public static double or(double a, double b) {
        return Math.max(a, b);
    }

    public static double not(double a) {
        return 1 - a;
    }
}
