package hr.fer.operators.mutation;

/**
 * Interface that represents a generic mutation operator.
 * 
 * @author Ivan Lokas
 *
 */
public interface IMutationOperator<T> {

	/**
	 * Performs a mutation over a given <code>solution</code>
	 * 
	 * @param solution that will be mutated
	 * @return a solution after mutation
	 */
	T mutate(T solution);

}
