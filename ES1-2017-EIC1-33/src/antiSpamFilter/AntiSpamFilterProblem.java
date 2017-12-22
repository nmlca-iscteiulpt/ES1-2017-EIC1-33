package antiSpamFilter;

import java.util.ArrayList;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;

public class AntiSpamFilterProblem extends AbstractDoubleProblem {
	
	private ArrayList<String> mspam = ReadFiles.getSpam(); 
	private ArrayList<String> mham = ReadFiles.getHam();
	private ArrayList<String> mrules = ReadFiles.getRules();
	
	  public AntiSpamFilterProblem() {
	    this(335);
	  }

	  public AntiSpamFilterProblem(Integer numberOfVariables) {
	    setNumberOfVariables(numberOfVariables);
	    setNumberOfObjectives(2);
	    setName("AntiSpamFilterProblem");

	    List<Double> lowerLimit = new ArrayList<>(getNumberOfVariables()) ;
	    List<Double> upperLimit = new ArrayList<>(getNumberOfVariables()) ;

	    for (int i = 0; i < getNumberOfVariables(); i++) {
	      lowerLimit.add(-5.0);
	      upperLimit.add(5.0);
	    }

	    setLowerLimit(lowerLimit);
	    setUpperLimit(upperLimit);
	  }

	  public void evaluate(DoubleSolution solution){
		  double aux, xi, xj;
		  double[] fx = new double[getNumberOfObjectives()];
		  double[] x = new double[getNumberOfVariables()];
		  for (int i = 0; i < solution.getNumberOfVariables(); i++) {
			  x[i] = solution.getVariableValue(i) ;
		  }

		  fx[0] = 0.0;
		  int i=0;

		  for(String w:mspam){
			  double count=0;
			  String[] parts = w.split("	");
			  for(int v=1;v<parts.length;v++){
				  for(String u:mrules){
					  if(u.equals(parts[v]))
						  count=count+((Double)(x[mrules.indexOf(u)]));
				  }	
			  }
			  if (count<5)
				  fx[0]++;
			  i++;
		  } 

		  fx[1] = 0.0;
		  for(String w:mham){
			  double count=0;
			  String[] parts = w.split("	");
			  for(int v=1;v<parts.length;v++){
				  for(String u:mrules){
					  if(u.equals(parts[v]))
						  count=count+((Double)(x[mrules.indexOf(u)]));
				  }	
			  }
			  if (count>5)
				  fx[1]++;
		  } 
		  solution.setObjective(0, fx[0]);
		  solution.setObjective(1, fx[1]);
	  }

	public ArrayList<String> getMspam() {
		return mspam;
	}

	public void setMspam(ArrayList<String> mspam) {
		this.mspam = mspam;
	}

	public ArrayList<String> getMham() {
		return mham;
	}

	public void setMham(ArrayList<String> mham) {
		this.mham = mham;
	}

	public ArrayList<String> getMrules() {
		return mrules;
	}

	public void setMrules(ArrayList<String> mrules) {
		this.mrules = mrules;
	}
	  
}
