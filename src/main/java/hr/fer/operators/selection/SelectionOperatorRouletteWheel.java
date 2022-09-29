package hr.fer.operators.selection;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import hr.fer.solution.Keyboard;

/**
 * Selection operator implementation that selects <code>n</code> solutions using
 * the Roulette Wheel selection method.
 * 
 * @author Ivan Lokas
 *
 */
public class SelectionOperatorRouletteWheel implements ISelectionOperator<Keyboard> {
	/**
	 * An instance of the <code>Random</code> class that is used for generating
	 * random doubles
	 */
	private Random random = new Random();

	@Override
	public List<Keyboard> select(List<Keyboard> population, List<String> dataset, int n) {
		List<Keyboard> resultPopulation = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			List<Keyboard> tmpPopulation = new LinkedList<>(population);
			tmpPopulation.removeAll(resultPopulation);

			List<Keyboard> sortedPopulation = tmpPopulation.stream()
					.sorted((a, b) -> Double.compare(b.getPunishment(dataset), (a.getPunishment(dataset))))
					.collect(Collectors.toList());

			double totalFitness = sortedPopulation.stream().mapToDouble(e -> 1 / e.getPunishment(dataset)).sum();
			double randomFitness = random.nextDouble(totalFitness);
			double partialFitness = 0;

			for (Keyboard solution : sortedPopulation) {
				partialFitness += 1 / solution.getPunishment(dataset);

				if (partialFitness >= randomFitness) {
					resultPopulation.add(solution);

					break;
				}
			}

		}

		return resultPopulation;
	}

}
