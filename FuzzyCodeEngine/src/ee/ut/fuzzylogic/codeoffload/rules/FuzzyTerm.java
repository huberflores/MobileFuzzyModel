
package ee.ut.fuzzylogic.codeoffload.rules;

import java.io.Serializable;


public interface FuzzyTerm extends Serializable {

    double getDOM();

    void clearDOM();

    void orWithDOM(double val);
    
}
