package hr.fer.operators.selection;

import java.util.List;
import java.util.stream.Collectors;

import hr.fer.solution.Keyboard;

/**
 * Selection operator implementation that selects <code>n</code> solutions with
 * the highest fitness.
 * 
 * @author Ivan Lokas
 *
 */
public class SelectionOperatorBest implements ISelectionOperator<Keyboard> {

	@Override
	public List<Keyboard> select(List<Keyboard> population, List<String> dataset, int n) {
		return population.stream()
				.sorted((a, b) -> Double.compare(a.getPunishment(dataset), (b.getPunishment(dataset)))).limit(n)
				.collect(Collectors.toList());
	}

}
