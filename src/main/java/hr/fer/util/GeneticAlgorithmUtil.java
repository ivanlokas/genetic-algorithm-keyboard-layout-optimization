package hr.fer.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import hr.fer.solution.Keyboard;

/**
 * This is an utility class which provides helper methods for easier
 * implementation of the genetic algorithm.
 * 
 * @author Ivan Lokas
 *
 */
public class GeneticAlgorithmUtil {
	/**
	 * Default string layout
	 */
	private static final String DEFAULT_STRING_LAYOUT = "QWERTYUIOPASDFGHJKLZXCVBNM";
	/**
	 * The delimiter used for splitting and joining the random string layout
	 */
	private static final String DELIMITER = "";

	/**
	 * Generates a random population with the size of <code>n</code>
	 * 
	 * @param n the number of individuals in a population
	 * @return random population
	 */
	public static List<Keyboard> generateRandomPopulation(int n) {
		List<Keyboard> population = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			population.add(new Keyboard(generateRandomStringLayout()));
		}

		return population;
	}

	/**
	 * @return random string layout used for generating a random individual
	 */
	private static String generateRandomStringLayout() {
		List<String> stringLayoutAsList = Arrays.asList(DEFAULT_STRING_LAYOUT.split(DELIMITER));
		Collections.shuffle(stringLayoutAsList);
		String result = stringLayoutAsList.stream().collect(Collectors.joining(DELIMITER));

		return result;
	}

}
