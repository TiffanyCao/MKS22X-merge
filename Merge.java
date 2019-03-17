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
      System.out.println(print(left));
      System.out.println(print(right));
      mergesortWrap(data, lo, lo + left.length - 1);
      mergesortWrap(data, lo + left.length, hi);
    }
    /*else{
      System.out.println("done");
    }*/
  }

  public static void mergesortH(int[] data, int[] temp1, int[] temp2, int lo, int hi){
    if(temp1.length == 1 && temp2.length == 1){
      if(temp1[0] >= temp2[0]){
        int[] result = {temp2[0], temp1[0]};
      }else{
        int[] result = {temp1[0], temp2[0]};
      }
    }
    //mergesortH(data, )
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
    int[] test = {0, 1, 2, 3, 4, 5, 6};
    mergesort(test);
  }

}
