public class Merge{

  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    mergesortInsertion(data, 0, data.length - 1); //call to helper function
  }

  public static void mergesortWrap(int[] data, int lo, int hi){
    if(lo < hi){
      //System.out.println(lo);
      //System.out.println(hi);
      int[] left = new int[(((hi - lo) + 1) / 2)];
      int[] right = new int[((hi - lo) + 1) - left.length];
      /*for(int i = lo; i <= hi; i++){
        if(i < (lo + left.length)){
          left[i - lo] = data[i];
        }else right[i - (left.length + lo)] = data[i];
      }
      */
      //System.out.println(print(left));
      //System.out.println(print(right));
      mergesortWrap(data, lo, lo + left.length - 1);
      mergesortWrap(data, lo + left.length, hi);
      for(int i = lo; i <= hi; i++){
        if(i < (lo + left.length)){
          left[i - lo] = data[i];
        }else right[i - (left.length + lo)] = data[i];
      }
      mergesortH(data, left, right, lo, hi);
    }
    /*else{
      System.out.println("done");
    }*/
  }

  public static void mergesortInsertion(int[] data, int lo, int hi){
    if((hi - lo) > 6){
      System.out.println(lo);
      System.out.println(hi);
      int[] left = new int[(((hi - lo) + 1) / 2)];
      int[] right = new int[((hi - lo) + 1) - left.length];
      /*for(int i = lo; i <= hi; i++){
        if(i < (lo + left.length)){
          left[i - lo] = data[i];
        }else right[i - (left.length + lo)] = data[i];
      }
      */
      //System.out.println(print(left));
      //System.out.println(print(right));
      mergesortWrap(data, lo, lo + left.length - 1);
      mergesortWrap(data, lo + left.length, hi);
      for(int i = lo; i <= hi; i++){
        if(i < (lo + left.length)){
          left[i - lo] = data[i];
        }else right[i - (left.length + lo)] = data[i];
      }
      mergesortH(data, left, right, lo, hi);
    }else{
      int[] left = new int[(((hi - lo) + 1) / 2)];
      int[] right = new int[((hi - lo) + 1) - left.length];
      for(int i = lo; i <= hi; i++){
        if(i < (lo + left.length)){
          left[i - lo] = data[i];
        }else right[i - (left.length + lo)] = data[i];
      }
      insertionsort(data, lo, lo + left.length - 1);
      insertionsort(data, lo + left.length, hi);

    }
  }
  public static void mergesortH(int[] data, int[] left, int[] right, int lo, int hi){
    int leftIndex = 0;
    int rightIndex = 0;
    int index = lo;
    //System.out.println(lo + " " + hi + " li " + leftIndex + " ri " + rightIndex);
    //System.out.println(print(left));
    //System.out.println(print(right));
    while(leftIndex < left.length && rightIndex < right.length){ //when the function hasn't finished with either half
      /*boolean smallestL = true;
      for(int i = rightIndex; i < right.length; i++){
        if(left[leftIndex] > right[rightIndex]) smallestL = false;
      }
      if(smallestL){
        data[index] = left[leftIndex];
        leftIndex++;
        index++;
      }
      if(!smallestL){
        boolean smallestR = true;
        for(int y = leftIndex; y < left.length; y++){
          if(right[rightIndex] > left[leftIndex]) smallestR = false;
        }
        if(smallestR){
          data[index] = right[rightIndex];
          rightIndex++;
          index++;
        }
      }*/
      if(left[leftIndex] < right[rightIndex]){ //if the value at left is smaller than the value at right..
        data[index] = left[leftIndex]; //the array picks the value at left
        leftIndex++; //the index of left increases once the value at the previous index has been considered
      }else{ //if the value at right is smaller than the value at left..
        data[index] = right[rightIndex]; //the array picks the value at right
        rightIndex++; //the index of right increases once the value at the previous index has been considered
      }
      index++; //once a value has been picked, the index increases
      //System.out.println(print(data));

    }
    if(leftIndex < left.length){ //if the left array has values left over...
      for(int i = leftIndex; i < left.length; i++){ //copy them back into data
        data[index] = left[i];
        leftIndex++;
        index++;
      }
    }
    if(rightIndex < right.length){ //if the right array has values left over...
      for(int i = rightIndex; i < right.length; i++){ //copy back them back into data
        data[index] = right[i];
        rightIndex++;
        index++;
      }
    }
    //System.out.println(print(data));
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

  public static void insertionsort(int[] data, int lo, int hi){
    for(int i = lo + 1; i <= hi; i++){ //insertion within the bounds of lo and hi
      //System.out.println(i);
      //System.out.println(lo);
      int x;
      int temp = data[i]; //store the value to be compared
      for(x = i - 1; (x >= lo) && (data[x] > temp); x--){ //if the values before it are greater than the value being compared...
        //System.out.println(x);
        data[x+1] = data[x]; //shift the values to the right
      }
      data[x+1] = temp; //when the value is at the correct index, set it down
    }
  }

  public static void main(String[] args){
    int[] test = {6, 5, 4, 3, 2, 1, 0};
    mergesort(test);
    System.out.println(print(test) + "\n");
    int[] test2 = {0, 2, 4, 1, 3, 6, 8};
    mergesort(test2);
    System.out.println(print(test2) + "\n");
    int[] test3 = {8, 4, 6, 32, 24, 44, 20, 443, 122};
    mergesort(test3);
    System.out.println(print(test3) + "\n");

    int[] test4 = new int[100];
    for(int i = 0; i < 100; i++){
      test4[i] = 99-i;
    }
    System.out.println(print(test4) + "\n");
    mergesort(test4);
    System.out.println(print(test4) + "\n");

    int[] test5 = {1, 2, 7, 6, 5, 4, 3, 8};
    insertionsort(test5, 2, 6);
    System.out.println(print(test5) + "\n");

  }

}
