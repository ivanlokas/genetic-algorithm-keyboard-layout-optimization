package hr.fer.operators.crossover;

import hr.fer.solution.Keyboard;

/**
 * Crossover operator implementation that takes the left side of the string
 * layout, of the first parent, and appends the missing characters from the
 * string layout from the second parent, in the order they appeared.
 * 
 * @author Ivan Lokas
 *
 */
public class CrossoverOperatorSplitAndFill implements ICrossoverOperator<Keyboard> {

	@Override
	public Keyboard crossover(Keyboard first, Keyboard second) {
		String firstStringLayout = first.getStringLayout();
		String secondStringLayout = second.getStringLayout();

		String left = firstStringLayout.substring(0, firstStringLayout.length() / 2);
		StringBuilder sb = new StringBuilder(left);

		for (int i = 0; i < secondStringLayout.length(); i++) {
			char currentCharacter = secondStringLayout.charAt(i);

			if (!left.contains(String.valueOf(currentCharacter))) {
				sb.append(currentCharacter);
			}
		}

		return new Keyboard(sb.toString());
	}

}
