package hr.fer.util;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is an utility class which provides helper methods for reading and
 * parsing precalculated keyboard key distances.
 * 
 * @author Ivan Lokas
 *
 */
public class KeyboardDistancesUtil {
	/**
	 * The delimiter used for transforming the given distances file
	 */
	private static final String DELIMITER = " ";
	/**
	 * Default directory where the given distance files are located
	 */
	private static final String DEFAULT_DIRECTORY = "KeyboardDistances";

	/**
	 * Returns the distances for each key pair
	 * 
	 * @param filename  the name of the file that will be parsed
	 * @param directory the specific location where the file is stored
	 * @return a generic format which stores the distances for each key pair
	 */
	public static Map<Map.Entry<Character, Character>, Double> getDistances(String filename, String directory)
			throws Exception {
		URL resource = IOUtil.getResourceFromFilename(filename, directory);
		List<String> lines = IOUtil.readLinesFromResource(resource);
		var result = parseLines(lines);

		return result;
	}

	/**
	 * Returns the distances for each key pair
	 * 
	 * @param filename the name of the file that will be parsed
	 * @return a generic format which stores the distances for each key pair
	 */
	public static Map<Map.Entry<Character, Character>, Double> getDistances(String filename) throws Exception {
		return getDistances(filename, DEFAULT_DIRECTORY);
	}

	/**
	 * Utility method which converts a given list of lines to their corresponding
	 * key pair distances
	 * 
	 * @param lines the list of lines that will be converted
	 * @return a map of distances for each key pair
	 */
	private static Map<Map.Entry<Character, Character>, Double> parseLines(List<String> lines) {
		Map<Map.Entry<Character, Character>, Double> result = new HashMap<>();

		for (String line : lines) {
			String[] elements = line.split(DELIMITER);
			result.put(Map.entry(elements[0].charAt(0), elements[1].charAt(0)), Double.parseDouble(elements[2]));
		}

		return result;
	}

}
