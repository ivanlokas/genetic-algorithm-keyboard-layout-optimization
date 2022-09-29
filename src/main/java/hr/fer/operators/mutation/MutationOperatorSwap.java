package hr.fer.operators.mutation;

import java.util.Random;

import hr.fer.solution.Keyboard;

/**
 * Mutation operator implementation that swaps characters with a given
 * probability.
 * 
 * @author Ivan Lokas
 *
 */
public class MutationOperatorSwap implements IMutationOperator<Keyboard> {
	/**
	 * Mutation probability that will be used for this mutation operator
	 */
	private static final double MUTATION_PROBABILITY = 0.1;
	/**
	 * An instance of the <code>Random</code> class that is used for generating
	 * random doubles
	 */
	private Random random = new Random();

	@Override
	public Keyboard mutate(Keyboard solution) {
		char[] array = solution.getStringLayout().toCharArray();

		if (random.nextDouble() < MUTATION_PROBABILITY) {
			int startIndex = random.nextInt(array.length);
			int endIndex = startIndex + random.nextInt(array.length - startIndex);

			char tmp = array[startIndex];
			array[startIndex] = array[endIndex];
			array[endIndex] = tmp;
		}

		return new Keyboard(String.valueOf(array));
	}

}
