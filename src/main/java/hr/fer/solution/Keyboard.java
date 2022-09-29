package hr.fer.solution;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This class represents an abstract keyboard with an arbitrary fixed-format
 * layout.
 * 
 * @author Ivan Lokas
 *
 */
public class Keyboard {
	/**
	 * A specific string layout
	 */
	private String stringLayout = null;
	/**
	 * KeyboardLayout used by this keyboard
	 */
	private KeyboardLayout keyboardLayout = null;
	/**
	 * Punishment of this keyboard, -1 if not calculated yet
	 */
	private double punishment = -1;

	/**
	 * Constructor which initializes the keyboard with custom
	 * <code>stringLayout</code>
	 * 
	 * @param stringLayout custom layout
	 */
	public Keyboard(String stringLayout) {
		super();
		this.stringLayout = stringLayout;
		this.keyboardLayout = new KeyboardLayout();
	}

	/**
	 * @return string layout for this keyboard
	 */
	public String getStringLayout() {
		return stringLayout;
	}

	/**
	 * Initialization method which updates the distance map and calculates the
	 * punishment for this keyboard.
	 * 
	 * @param dataset which will be used to initialize this keyboard
	 */
	private void init(List<String> dataset) {
		keyboardLayout.calculateDistanceMap(stringLayout);
		punishment = calculatePunishment(dataset);
	}

	/**
	 * This method returns the punishment for a given dataset.
	 * 
	 * @param dataset which will be used to calculate the punishment
	 * @return punishment of this keyboard
	 */
	public double getPunishment(List<String> dataset) {
		if (punishment < 0) {
			init(dataset);
		}

		return punishment;
	}

	/**
	 * The punishment is defined as the inverse of the average distance needed to
	 * travel per-word basis.
	 * 
	 * The distance needed to travel per-word is defined as the sum of the distances
	 * between the characters, for a given word, weighted by the number of letters.
	 * 
	 * Greater the punishment, worse the solution.
	 * 
	 * @param dataset which will be used to calculate the punishment
	 * @return the punishment of this keyboard
	 */
	private double calculatePunishment(List<String> dataset) {
		dataset.replaceAll(String::toUpperCase);

		var distanceMap = keyboardLayout.getDistanceMap();
		double total = 0;

		for (String word : dataset) {
			double wordLength = word.length();
			double wordDistance = 0;

			for (int i = 0; i < wordLength - 1; i++) {
				var tmp = Map.entry(word.charAt(i), word.charAt(i + 1));
				wordDistance += distanceMap.get(tmp);
			}

			total += wordDistance / wordLength;
		}

		return total / dataset.size();
	}

	@Override
	public int hashCode() {
		return Objects.hash(stringLayout);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Keyboard other = (Keyboard) obj;
		return Objects.equals(stringLayout, other.stringLayout);
	}

	@Override
	public String toString() {
		return String.format("Punishment: %2f", punishment);
	}

}
