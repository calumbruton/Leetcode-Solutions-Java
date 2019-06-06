// 1) Sort all the elements of the input array.
// 2) Use two index variables l and r to traverse from left and right ends respectively. Initialize l as 0 and r as n-1.
// 3) sum = a[l] + a[r]
// 4) If sum is -ve, then l++
// 5) If sum is +ve, then r–
// 6) Keep track of abs min sum.
// 7) Repeat steps 3, 4, 5 and 6 while l < r


class Main 
{ 
    static void minAbsSumPair(int arr[], int n) 
    { 
      // Variables to keep track of current sum and minimum sum 
      int sum, min_sum = 999999; 
       
      // left and right index variables 
      int l = 0, r = n-1; 
       
      // variable to keep track of the left and right pair for min_sum 
      int min_l = l, min_r = n-1; 
       
      /* Array should have at least two elements*/
      if(n < 2) 
      { 
        System.out.println("Invalid Input"); 
        return; 
      } 
       
      /* Sort the elements */
      sort(arr, l, r); 
       
      while(l < r) 
      { 
        sum = arr[l] + arr[r]; 
       
        /*If abs(sum) is less then update the result items*/
        if(Math.abs(sum) < Math.abs(min_sum)) 
        { 
          min_sum = sum; 
          min_l = l; 
          min_r = r; 
        } 
        if(sum < 0) 
          l++; 
        else
          r--; 
      } 
       
        
      System.out.println(" The two elements whose "+ 
                              "sum is minimum are "+ 
                        arr[min_l]+ " and "+arr[min_r]); 
    } 
       
    // main function 
    public static void main (String[] args)  
    { 
        int arr[] = {1, 60, -10, 70, -80, 85}; 
        int n = arr.length; 
        minAbsSumPair(arr, n); 
    } 
}