package hr.fer;

import java.util.List;

import hr.fer.operators.crossover.CrossoverOperatorSplitAndFill;
import hr.fer.operators.crossover.ICrossoverOperator;
import hr.fer.operators.mutation.IMutationOperator;
import hr.fer.operators.mutation.MutationOperatorSwap;
import hr.fer.operators.selection.ISelectionOperator;
import hr.fer.operators.selection.SelectionOperatorBest;
import hr.fer.operators.selection.SelectionOperatorRouletteWheel;
import hr.fer.solution.Keyboard;
import hr.fer.util.GeneticAlgorithmUtil;
import hr.fer.util.WordDatasetUtil;

public class Main {
	/**
	 * Number of iterations, positive integer
	 */
	private static final int NUMBER_OF_ITERATIONS = 1000;
	/**
	 * Population size, positive integer
	 */
	private static final int POPULATION_SIZE = 10;
	/**
	 * Number of best solutions that will be added to the next population,
	 * non-negative integer
	 */
	private static final int ELITISM = 1;

	// Selection operators
	/**
	 * Selection operator that chooses the best solution
	 */
	private static final ISelectionOperator<Keyboard> selectionOperatorBest = new SelectionOperatorBest();
	/**
	 * Selection operator that uses fitness proportional selection
	 */
	private static final ISelectionOperator<Keyboard> selectionOperatorRoulleteWheel = new SelectionOperatorRouletteWheel();

	// Crossover operator
	/**
	 * Crossover operator that creates a child combining the left and right part of
	 * the string layout of the first and the second parent, respectively
	 */
	private static final ICrossoverOperator<Keyboard> crossoverOperatorSplit = new CrossoverOperatorSplitAndFill();

	// Mutation operator
	/**
	 * Mutation operator that swaps characters of a string layout, with a given
	 * probability
	 */
	private static final IMutationOperator<Keyboard> mutationOperatorSwap = new MutationOperatorSwap();

	/**
	 * Main method that demonstrates the functionality of the genetic algorithm
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		List<Keyboard> population = GeneticAlgorithmUtil.generateRandomPopulation(POPULATION_SIZE);
		List<String> dataset = WordDatasetUtil.getDataset("dataset.txt");
//		List<String> dataset = Arrays.asList("word");

		for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
			// Elite population
			List<Keyboard> newPopulation = selectionOperatorBest.select(population, dataset, ELITISM);

			for (int j = 0; j < POPULATION_SIZE - ELITISM; j++) {
				// Selection
				List<Keyboard> parents = selectionOperatorRoulleteWheel.select(population, dataset, 2);

				// Crossover
				Keyboard child = crossoverOperatorSplit.crossover(parents.get(0), parents.get(1));

				// Mutation
				Keyboard mutatedChild = mutationOperatorSwap.mutate(child);

				// Add child to new population
				newPopulation.add(mutatedChild);
			}

			System.out.println(String.format("Iteration: %4d, lowest punishment: %2f", i + 1,
					selectionOperatorBest.select(population, dataset, 1).get(0).getPunishment(dataset)));

			population = newPopulation;
		}
	}

}
