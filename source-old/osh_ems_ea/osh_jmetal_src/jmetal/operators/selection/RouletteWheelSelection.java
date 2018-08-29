//  BinaryTournament.java
//
//  Author:
//       Antonio J. Nebro <antonio@lcc.uma.es>
//       Juan J. Durillo <durillo@lcc.uma.es>
//
//  Copyright (c) 2011 Antonio J. Nebro, Juan J. Durillo
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU Lesser General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU Lesser General Public License for more details.
// 
//  You should have received a copy of the GNU Lesser General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.

package jmetal.operators.selection;

import jmetal.core.Solution;
import jmetal.core.SolutionSet;
import jmetal.util.PseudoRandom;
import jmetal.util.comparators.DominanceComparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * This class implements an binary tournament selection operator
 */
@SuppressWarnings("rawtypes")
public class RouletteWheelSelection extends Selection {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
   * Stores the <code>Comparator</code> used to compare two
   * solutions
   */
  private Comparator comparator_;
  
  private int numberToSelect_;

  /**
   * Constructor
   * Creates a new RouletteWheelSelection operator using a DominanceComparator
   */
  public RouletteWheelSelection(HashMap<String, Object> parameters, PseudoRandom pseudoRandom){
  	super(parameters, pseudoRandom);
  	if ((parameters != null) && (parameters.get("comparator") != null))
  		comparator_ = (Comparator) parameters.get("comparator");  	
  	else
      //comparator_ = new BinaryTournamentComparator();
      comparator_ = new DominanceComparator();
  	if ((parameters != null) && (parameters.get("numberToSelect") != null))
  		numberToSelect_ = (int) parameters.get("numberToSelect");  	
  	else
  		numberToSelect_ = 2;
  } // RouletteWheelSelection
  
  /**
  * Performs the operation
  * @param object Object representing a SolutionSet
  * @return the selected solution
  */
  @Override
  public Object execute(Object object){
    SolutionSet solutionSet = (SolutionSet)object;
    Solution[] result = new Solution[numberToSelect_];
    solutionSet.sort(comparator_);
    
    Solution best = solutionSet.get(0);
    Solution worst = solutionSet.get(solutionSet.size() - 1);    
   
    double[] wheel = new double[solutionSet.size()];
    double sumOfFitness = 0.0;
    
    //if minProblem just change to maxproblem by *(-1)
    if (best.getObjective(0) < worst.getObjective(0)) {
    	double negCorrection = 0.0;
    	
    	if (worst.getObjective(0) > 0) {
    		negCorrection = worst.getObjective(0) + 0.00001;
    	}
    	
    	for (int i = 0; i < wheel.length; i++) {
    		sumOfFitness += (- solutionSet.get(i).getObjective(0) + negCorrection);
    		wheel[i] = sumOfFitness;    		
    	}
    } else {
    	for (int i = 0; i < wheel.length; i++) {
    		double negCorrection = 0.0;
    		if (worst.getObjective(0) < 0) {
        		negCorrection = 0.0001 - worst.getObjective(0);
        	}
    		sumOfFitness += solutionSet.get(i).getObjective(0) + negCorrection;
    		wheel[i] = sumOfFitness;
    	}
    }
    
    //if all have the same fitness just select randomly
    if (sumOfFitness == 0) {
    	for (int i = 0; i < numberToSelect_; i++) {
    		result[i] = solutionSet.get(pseudoRandom.randInt(0, solutionSet.size()));
    	}
    	return result;
    }
    
    for (int i = 0; i < wheel.length; i++) {	
		wheel[i] /= sumOfFitness;
	}
    
    double[] selectedValues = new double[numberToSelect_];
    
    for (int i = 0; i < numberToSelect_; i++) {
    	selectedValues[i] = pseudoRandom.randDouble();
    }
    
    Arrays.sort(selectedValues);
    
    int selectPointer = 0;
    int counter = 0;
    
    while (selectPointer < numberToSelect_) {
    	if (wheel[counter] >= selectedValues[selectPointer]) {
    		result[selectPointer] = solutionSet.get(counter);
    		selectPointer++;
    	} else 
    		counter++;  	
    }
    
    return result;
                           
  } // execute
} // RouletteWheelSelection
