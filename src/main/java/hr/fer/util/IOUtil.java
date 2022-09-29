package hr.fer.util;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * This is an utility class which provides helper methods for reading files.
 * 
 * @author Ivan Lokas
 *
 */
public class IOUtil {

	/**
	 * Utility method which converts a given file into a resource
	 * 
	 * @param filename  the name of the file that will be converted
	 * @param directory the specific location where the file is stored
	 * @return given file as a resource
	 */
	public static URL getResourceFromFilename(String filename, String directory) {
		String resourceString = String.format("%s/%s", directory, filename);
		return (new KeyboardDistancesUtil()).getClass().getClassLoader().getResource(resourceString);
	}

	/**
	 * Utility method which converts a given resource to a list of lines
	 * 
	 * @param resource the resource that will be converted
	 * @return given resource as a list of lines
	 */
	public static List<String> readLinesFromResource(URL resource) throws Exception {
		return Files.readAllLines(Paths.get(resource.toURI()));
	}

}
