import java.util.ArrayDeque;

/**
 * Queue object for a stack of primitive doubles. 
 */
public class FIFOQueue extends ArrayDeque<Double> {
    

    /**
     * is empty?
     */
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * Size of your Queue
     */
    @Override
    public int size() {
        return super.size();
    }

    /**
     * Enqueue
     */
    public void enqueue(double value) {
        super.add(value);
    }

    /**
     * Dequeue
     * 
     * return the deleted value
     */
    public double dequeue() {
        return super.poll();
    }
}
