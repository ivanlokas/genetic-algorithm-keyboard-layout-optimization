package hr.fer.operators.selection;

import java.util.List;

/**
 * Interface that represents a generic selection operator.
 * 
 * @author Ivan Lokas
 * 
 */
public interface ISelectionOperator<T> {

	/**
	 * Performs a selection over a given <code>population</code>. The number of
	 * solutions returned is equal to <code>n</code>
	 * 
	 * @param population that will be used for selection
	 * @param dataset    that will be used for calculating fitness
	 * @param n          the number of selected solutions
	 * @return a collection of solutions after selection
	 */
	List<T> select(List<T> population, List<String> dataset, int n);

}
