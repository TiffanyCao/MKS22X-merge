public class Merge{
  
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    mergesortWrap(data, 0, data.length - 1);
  }

  public static void mergesortWrap(int[] data, int lo, int hi){
    if(lo < hi){
      //System.out.println(lo);
      //System.out.println(hi);
      int[] left = new int[(((hi - lo) + 1) / 2)];
      int[] right = new int[((hi - lo) + 1) - left.length];
      for(int i = lo; i <= hi; i++){
        if(i < (lo + left.length)){
          left[i - lo] = data[i];
        }else right[i - (left.length + lo)] = data[i];
      }
      //System.out.println(print(left));
      //System.out.println(print(right));
      mergesortWrap(data, lo, lo + left.length - 1);
      mergesortWrap(data, lo + left.length, hi);
      mergesortH(data, left, right, lo, hi);
    }
    /*else{
      System.out.println("done");
    }*/
  }

  public static void mergesortH(int[] data, int[] left, int[] right, int lo, int hi){
    int leftIndex = 0;
    int rightIndex = 0;
    int index = lo;
    while(leftIndex < left.length && rightIndex < right.length){ //when the function hasn't finished with either half
      if(left[leftIndex] < right[rightIndex]){ //if the value at left is smaller than the value at right..
        data[index] = left[leftIndex]; //the array picks the value at left
        leftIndex++; //the index of left increases once the value at the previous index has been considered
      }else{ //if the value at right is smaller than the value at left..
        data[index] = right[rightIndex]; //the array picks the value at right
        rightIndex++; //the index of right increases once the value at the previous index has been considered
      }
      index++; //once a value has been picked, the index increases
    }
  }

  /**A method that prints out the array
  *@return String
  */
  public static String print(int[] data){
   String result = "[";
   for(int i = 0; i < data.length; i++){
     if(i != data.length-1){
       result += data[i] + ", ";
     }else{
       result += data[i] + "]";
     }
   }
   return result;
  }

  public static void main(String[] args){
    int[] test = {6, 5, 4, 3, 2, 1, 0};
    mergesort(test);
    System.out.println(print(test));
  }

}
