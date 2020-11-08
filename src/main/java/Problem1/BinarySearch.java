package Problem1;

public class BinarySearch {

    public static int binarySearch(int[] data, int target) {


        return bs (data, target, 0, data.length-1);
    }

    private static int bs (int [] data, int target, int lo, int hi)
    {
        if(lo > hi) //base case
        {
            return -1;  // we couldn't find the target
        }

        int mid = lo + (hi - lo)/2;

        if (target == data[mid])
        {
            return mid;
        }

        else if(target < data[mid])
        {
            return bs (data, target, lo, mid - 1);
        }
        else
        {
            return bs (data, target, mid + 1, hi);
        }

    }
}
