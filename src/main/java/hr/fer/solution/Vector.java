package hr.fer.solution;

/**
 * This class represents an implementation of a 2D immutable vector
 * 
 * @author Ivan Lokas
 *
 */
public class Vector {
	/**
	 * The first value of the vector
	 */
	private double x;
	/**
	 * The second value of the vector
	 */
	private double y;

	/**
	 * Constructor which initializes a vector with given values
	 * 
	 * @param x the first value of the vector
	 * @param y the second value of the vector
	 */
	public Vector(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * @return first value of the vector
	 */
	public double getX() {
		return x;
	}

	/**
	 * @return second value of the vector
	 */
	public double getY() {
		return y;
	}

	/**
	 * Calculates the euclidean distance between two vectors
	 * 
	 * @param a the first vector
	 * @param b the second vector
	 * @return the euclidian distance between two vectors
	 */
	public static double calculateDistance(Vector a, Vector b) {
		double x = Math.pow(a.getX() - b.getX(), 2);
		double y = Math.pow(a.getY() - b.getY(), 2);

		return Math.round(Math.sqrt(x + y) * 100.0) / 100.0;
	}

	@Override
	public String toString() {
		return String.format("(%f, %f)", x, y);
	}

}
