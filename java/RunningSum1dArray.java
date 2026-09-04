public class RunningSum1dArray {

    public static int[] runningSum(int nums[]) {
        int result[]=new int[nums.length];
        result[0]=0;
        int sum=0;
        for(int i =0; i <nums.length; i++) {
            sum+=nums[i];
            result[i]=sum;
        }
        return result;
    }
    public static void main(String[] args) {
        int []test={12,3,4,5};
        int res[]=runningSum(test);
        for(int i: res) {
            System.out.println(i);
        }
    }
}