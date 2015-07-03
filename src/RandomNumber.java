

import java.util.Random;

public class RandomNumber {
	
	Random rand = new Random();
	
	int[] random(int min, int max ){
		int[] nums = new int[6];
		int r = randomRange(min,max);
		for( int i = 0 ; i < 6 ; ++i ){
			while( check_uniqueNumber(nums,r) ){
				r = randomRange(min,max);
				check_uniqueNumber(nums,r);
			}
			nums[i] = r;
		}
		
		return nums;
		
	}
	int randomRange(int min, int max){
	   return  rand.nextInt((max - min) + 1) + min;
	}
	boolean check_uniqueNumber(int[] nums,int r){
		for(int i = 0 ; i < nums.length ; ++i){
			if(nums[i] == r){
				return true;
			}
		}
		return false;
	}
}
