package hr.fer.util;

import java.net.URL;
import java.util.List;

/**
 * This is an utility class which provides helper methods for reading and
 * collecting word datasets
 * 
 * @author Ivan Lokas
 *
 */
public class WordDatasetUtil {
	/**
	 * Default directory where the given datasets are located
	 */
	private static final String DEFAULT_DIRECTORY = "WordDatasets";

	/**
	 * Returns the parsed dataset in form of a list of words
	 * 
	 * @param filename  the name of the file that will be parsed
	 * @param directory the specific location where the file is stored
	 * @return a list of words parsed from the given dataset
	 */
	public static List<String> getDataset(String filename, String directory) throws Exception {
		URL resource = IOUtil.getResourceFromFilename(filename, directory);
		List<String> result = IOUtil.readLinesFromResource(resource);

		return result;
	}

	/**
	 * Returns the parsed dataset in form of a list of words
	 * 
	 * @param filename the name of the file that will be parsed
	 * @return a list of words parsed from the given dataset
	 */
	public static List<String> getDataset(String filename) throws Exception {
		return getDataset(filename, DEFAULT_DIRECTORY);
	}

}
