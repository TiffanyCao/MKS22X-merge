public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    int[] temp1 = new int[data.length / 2];
    int[] temp2 = new int[data.length - (data.length / 2)];
    for(int i = 0; i < data.length; i++){
      if(i < temp1.length){
        temp1[i] = data[i];
      }else temp2[i - (temp2.length - 1)] = data[i];
    }
    System.out.println(print(temp1));
    System.out.println(print(temp2));
    //mergesortH(data, temp1, temp2, 0, data.length);
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
