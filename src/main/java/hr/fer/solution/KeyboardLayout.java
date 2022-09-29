package hr.fer.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class represents a simplified keyboard layout which contains just 26
 * characters.
 * 
 * The mentioned characters are the uppercase version of the letters of the
 * English Alphabet.
 * 
 * @author Ivan Lokas
 *
 */
public class KeyboardLayout {
	/**
	 * The default key spacing, in millimeters
	 */
	private static final double defaultSpacing = 19.05;

	/**
	 * Custom comparator which makes sure that the key distances are ordered
	 * alphabetically
	 */
	private static final Comparator<Map.Entry<Character, Character>> comparator = (a, b) -> {
		int first = a.getKey().compareTo(b.getKey());

		if (first != 0) {
			return first;
		}

		int second = a.getValue().compareTo(b.getValue());

		if (second != 0) {
			return second;
		}

		return 0;
	};

	/**
	 * Custom spacing that can be used, for more flexibility
	 */
	private double spacing = 0;
	/**
	 * A map of distances for each key pair, if created, <code>null</code> otherwise
	 */
	public Map<Map.Entry<Character, Character>, Double> distanceMap = null;

	/**
	 * @return a map of distances for each key pair
	 */
	public Map<Map.Entry<Character, Character>, Double> getDistanceMap() {
		return distanceMap;
	}

	/**
	 * Constructor which initializes the layout with custom <code>spacing</code>
	 * 
	 * @param spacing custom spacing
	 */
	public KeyboardLayout(double spacing) {
		super();
		this.spacing = spacing;
	}

	/**
	 * Constructor which initializes the layout with <code>defaultSpacing</code>
	 */
	public KeyboardLayout() {
		this(defaultSpacing);
	}

	/**
	 * Utility method which converts a given string representation of a layout to
	 * their corresponding key pair distances.
	 * 
	 * The method does not only return the map, but it also updates the
	 * <code>distanceMap</code>.
	 * 
	 * @param stringLayout the layout of the keys
	 * @return a map of distances for each key pair
	 */
	public Map<Map.Entry<Character, Character>, Double> calculateDistanceMap(String stringLayout) {
		if (!checkUniqueCharacters(stringLayout)) {
			throw new IllegalArgumentException("The given string contains duplicate characters!");
		}

		//@formatter:off
		List<Vector> layout = Arrays.asList(
				// First row
				new Vector(0 * spacing, 0 * spacing),
				new Vector(1 * spacing, 0 * spacing),
				new Vector(2 * spacing, 0 * spacing),
				new Vector(3 * spacing, 0 * spacing),
				new Vector(4 * spacing, 0 * spacing),
				new Vector(5 * spacing, 0 * spacing),
				new Vector(6 * spacing, 0 * spacing),
				new Vector(7 * spacing, 0 * spacing),
				new Vector(8 * spacing, 0 * spacing),
				new Vector(9 * spacing, 0 * spacing),
				
				// Second row
				new Vector(0.25 * spacing, 1 * spacing),
				new Vector(1.25 * spacing, 1 * spacing),
				new Vector(2.25 * spacing, 1 * spacing),
				new Vector(3.25 * spacing, 1 * spacing),
				new Vector(4.25 * spacing, 1 * spacing),
				new Vector(5.25 * spacing, 1 * spacing),
				new Vector(6.25 * spacing, 1 * spacing),
				new Vector(7.25 * spacing, 1 * spacing),
				new Vector(8.25 * spacing, 1 * spacing),
				
				// Third row
				new Vector(0.75 * spacing, 2 * spacing),
				new Vector(1.75 * spacing, 2 * spacing),
				new Vector(2.75 * spacing, 2 * spacing),
				new Vector(3.75 * spacing, 2 * spacing),
				new Vector(4.75 * spacing, 2 * spacing),
				new Vector(5.75 * spacing, 2 * spacing),
				new Vector(6.75 * spacing, 2 * spacing)
				);
		//@formatter:on	

		if (layout.size() != stringLayout.length()) {
			throw new IllegalArgumentException("The given layout length is not supported!");
		}

		distanceMap = new TreeMap<>(comparator);

		for (int i = 0, length = stringLayout.length(); i < length; i++) {
			Character firstCharacter = stringLayout.charAt(i);

			for (int j = 0; j < length; j++) {
				Character secondCharacter = stringLayout.charAt(j);

				Map.Entry<Character, Character> characterPair = Map.entry(firstCharacter, secondCharacter);
				double distance = Vector.calculateDistance(layout.get(i), layout.get(j));

				distanceMap.put(characterPair, distance);

			}
		}

		return distanceMap;
	}

	/**
	 * An utility method which checks if all characters in a given string
	 * <code>input</code> are unique
	 * 
	 * @param input the queried string
	 * @return true if all characters in a string are unique, false otherwise
	 */
	public static boolean checkUniqueCharacters(String input) {
		Arrays.sort(input.toCharArray());

		for (int i = 0, length = input.length(); i < length - 1; i++) {
			if (input.charAt(i) == input.charAt(i + 1)) {
				return false;
			}
		}

		return true;
	}

}
