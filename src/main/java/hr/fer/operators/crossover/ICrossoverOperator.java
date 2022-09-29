package hr.fer.operators.crossover;

/**
 * Interface that represents a generic crossover operator.
 * 
 * @author Ivan Lokas
 *
 */
public interface ICrossoverOperator<T> {

	/**
	 * Performs a crossover considering both given solutions, <code>first</code> and
	 * <code>second</code>
	 * 
	 * @param first  solution of the crossover
	 * @param second solution of the crossover
	 * @return a solution as a product of the crossover
	 */
	T crossover(T first, T second);

}
