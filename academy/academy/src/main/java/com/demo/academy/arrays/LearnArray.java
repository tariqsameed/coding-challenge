
package com.demo.academy.arrays;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class LearnArray {

    // Leet Code: Two Sum
    //  Reverse array with optimize code, Leet code reverse string
    public void programmingArrays(){

        int[] intarrays = new int[2];
        intarrays[0] = 20;
        intarrays[1] = 35;

        for(int value: intarrays){
            System.out.println(value);
        }
    }

    public void reverseArray(){

        int array[] = new int[]{1,2,3,4,5};

        for(int i=0; i < array.length - i; i++){
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;

        }

        System.out.println(Arrays.toString(array));

    }

    public int[] twoSum(){
        int nums[] = new int[]{2,7,11,15};
        int target = 9;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < nums.length ; i++){
            int num = nums[i];
            int rem = target - num;

            if(map.containsKey(rem)){
                return new int[]{i, map.get(rem)};
            }

            map.put(num,i);
        }

        return null;
    }

}
