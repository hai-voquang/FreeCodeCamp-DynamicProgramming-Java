package br.com.guilhermealvessilve.dynamic.programming.howsum;
import java.util.*;

/**
 * m= target sum
 * n= array length
 *
 * brute force:
 *  O(n^m * m) time
 *  O(m) space
 *
 * memoized:
 *  O(n * m^2) time
 *  O(m^2) space
 *
 * tabulation:
 *  O(n * m^2) time
 *  O(m^2) space
 *
 */
public class HowSum {

    public static ArrayList<Long> howSumRec(long target, long[] nums){
        if(target==0){
            ArrayList<Long> arr2=new ArrayList<>();
            return arr2;
        }
        if(target<0){
            return null;
        }

        for(int i=0;i<nums.length;i++){
            ArrayList<Long> arr2=howSumRec(target-nums[i],nums);

            if(arr2!=null){
                arr2=new ArrayList<>(arr2);
                arr2.add(nums[i]);
                return arr2;
            }
        }

        return null;
    }

    public static ArrayList<Long> howSumMemo(long target, long[] nums, HashMap<Long, ArrayList<Long>> memo){
        if(memo.containsKey(target)) return memo.get(target);
        if(target==0){
            ArrayList<Long> arr2=new ArrayList<>();
            return arr2;
        }
        if(target<0){
            return null;
        }

        for(int i=0;i<nums.length;i++){
            ArrayList<Long> arr2=howSumMemo(target-nums[i],nums,memo);

            if(arr2!=null){
                arr2.add(nums[i]);
                memo.put(target-nums[i],arr2);
                return arr2;
            }
        }

        memo.put(target, null);
        return null;
    }

    public static ArrayList<Long> howSumTab(long target, long[] nums){
        ArrayList<Long>[] tab = new ArrayList[(int)target+1];
        Arrays.fill(tab, null);

        tab[0]=new ArrayList<>();

        for(int i=0;i<=target;i++){
            if(tab[i]!=null){
                for(int j=0;j<nums.length;j++){
                    if(i+nums[j]<=target){
                        tab[i+(int)nums[j]] = new ArrayList<>(tab[i]);
                        tab[i+(int)nums[j]].add(nums[j]);
                    }
                }
            }
        }

        return tab[(int)target];
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        long target = s.nextLong();

        int n = s.nextInt();
        long[] num = new long[n];
        for(int i=0;i<n;i++) num[i]=s.nextLong();

        //---Recursion---
        //System.out.println(howSumRec(target,num));

        //---Memoisation---
        //System.out.println(howSumMemo(target,num,new HashMap<>()));

        //---Tabulation---
        System.out.println(howSumTab(target,num));
    }

}
