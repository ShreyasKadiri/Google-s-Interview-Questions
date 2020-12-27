//https://www.ideserve.co.in/learn/re-arrange-elements-to-put-positive-negative-elements-in-alternate-order


public class RearrangeElements {
    private void rotateSubarrayRightByOneElement(int[] array, int low, int high) {
        int lastElement = array[high];
 
        for (int i = high; i > low; i--) {
            array[i] = array[i - 1];
        }
 
        array[low] = lastElement;
    }
 
    private boolean notAtRightPosition(int[] array, int index) {
        // even indices should have positive elements in them
        if ((index % 2) == 0) {
            // if negative element
            if ((array[index]) < 0) {
                return true;
            } else {
                return false;
            }
        } else // odd indices should have negative elements in them
        {
            if ((array[index]) < 0) {
                return false;
            } else {
                return true;
            }
 
        }
    }
 
    private int getNextOpposite(int[] array, int index) {
        for (int i = index + 1; i < array.length; i++) {
            if ((array[i] * array[index]) < 0) {
                return i;
            }
        }
 
        return -1;
    }
 
    public void reArrangePositivesNegatives(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (notAtRightPosition(array, i)) {
                int nextOppositeIndex = getNextOpposite(array, i);
                if (nextOppositeIndex != -1) {
                    rotateSubarrayRightByOneElement(array, i, nextOppositeIndex);
                } else // no more opposite signed elements
                {
                    break;
                }
            }
        }
    }
}
