import java.util.HashSet;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int nums[]) {
        HashSet<Integer> res= new HashSet<>();
        for(int i : nums) {
            if(res.contains(i)) {
                return true;
            }
            res.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1,1,23,4,5,6,8})); //true
        System.out.println(containsDuplicate(new int[]{1,2,3,9,43,23,4,5,6,8})); //false
    }
}