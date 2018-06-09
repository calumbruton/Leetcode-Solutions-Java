//QuickSelect algorithm, works like Quick sort but instead of recursing down both sides only
//sorts the partitions (halfs) of the array that the kth element is in each time

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //
        int low = 0;
        int high = nums.length-1;
        k = nums.length-k;
        
        //While low is less than high keep partitioning, updating low and high to narrow in 
        //on the location of k
        
        while (low < high){
            int p = partition(nums, low, high);
            if (k >= p)
                low = p;              
            else
                high = p-1;
        }

        return nums[k];
    }
    
    //Partition splits a portion of an array into a half higher than it's pivot and lower than its pivot
    //and returns the location of this pivot in the array.
    public int partition(int [] nums, int l, int h){
        
        //use high as our pivot
        int pivot = nums[h];
        int i = l-1;
        int j = l;
        
        //Move through array putting elements smaller than pivot on one side and those larger on the other side
        for (;j<h; j++){
            //Swap if nums[j] <= pivot, because j is the forward counter and i is our trailer that stays with big numbers
            // at the beginning of the array
            if (nums[j] <= pivot){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }         
        }
        
        //Put pivot in correct position - i will be on an element smaller than it or nothing (i.e i could be -1) guaranteed
        //So we increment it one to swap it with an element bigger than it
        int temp = nums[i+1];
        nums[i+1] = pivot;
        nums[h] = temp;
        
        return i+1;
        
        
    }

}