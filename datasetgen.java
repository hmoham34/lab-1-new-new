/**
 * Computes the average of a set of data values.
 * @param <T> the type of data that implements Measurable
 */
public class DataSet<T extends Measurable> {
    private double sum;
    private T maximum;
    private int count;

    /**
     * Constructs an empty data set.
     */
    public DataSet() {
        sum = 0;
        count = 0;
        maximum = null;
    }

    /**
     * Adds a data value to the data set.
     * @param x a data value
     */
    public void add(T x) {
        sum += x.getMeasure();
        if (count == 0 || (maximum != null && maximum.getMeasure() < x.getMeasure())) {
            maximum = x;
        }
        count++;
    }

    /**
     * Gets the average of the added data.
     * @return the average or 0 if no data has been added
     */
    public double getAverage() {
        if (count == 0) return 0;
        return sum / count;
    }

    /**
     * Gets the largest of the added data.
     * @return the maximum or null if no data has been added
     */
    public T getMaximum() {
        return maximum;
    }
}
