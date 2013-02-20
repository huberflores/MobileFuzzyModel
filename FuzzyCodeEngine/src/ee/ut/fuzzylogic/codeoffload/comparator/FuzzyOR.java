/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ut.fuzzylogic.codeoffload.comparator;


import java.util.ArrayList;
import java.util.List;

import ee.ut.fuzzylogic.codeoffload.rules.FuzzyTerm;

/**
 *
 * @author Root
 */
public class FuzzyOR implements FuzzyTerm {

    List<FuzzyTerm> terms;

    public FuzzyOR(FuzzyTerm termA, FuzzyTerm termB) {
        terms = new ArrayList<FuzzyTerm>();
        terms.add(termA);
        terms.add(termB);
    }

    public FuzzyOR(FuzzyTerm termA, FuzzyTerm termB, FuzzyTerm termC) {
        terms = new ArrayList<FuzzyTerm>();
        terms.add(termA);
        terms.add(termB);
        terms.add(termC);
    }

    public FuzzyOR(FuzzyTerm termA, FuzzyTerm termB, FuzzyTerm termC, FuzzyTerm termD) {
        terms = new ArrayList<FuzzyTerm>();
        terms.add(termA);
        terms.add(termB);
        terms.add(termC);
        terms.add(termD);
    }

    @Override
    public double getDOM() {
        double minDOM = Double.NEGATIVE_INFINITY;
        for (FuzzyTerm t : terms) {
            if (t.getDOM() > minDOM) {
                minDOM = t.getDOM();
            }
        }
        return minDOM;
    }

    @Override
    public void clearDOM() {
        for (FuzzyTerm t : terms) {
            t.clearDOM();
        }
    }

    @Override
    public void orWithDOM(double val) {
        for (FuzzyTerm t : terms) {
            t.orWithDOM(val);
        }
    }
}
