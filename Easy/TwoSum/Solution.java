/*
 * Two Sum Problem - Easy Level
 * 
 * Problem Statement:
 * Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target. You may assume that each input would have exactly
 * one solution, and you may not use the same element twice.
 * 
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * 
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * 
 * Constraints:
 * - 2 <= nums.length <= 10^4
 * - -10^9 <= nums[i] <= 10^9
 * - -10^9 <= target <= 10^9
 * - Only one valid answer exists.
 */

import java.util.*;

public class Solution {
    
    // APPROACH 1: BRUTE FORCE
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    // Check every pair of numbers to see if they sum to target
    public int[] twoSumBruteForce(int[] nums, int target) {
        // Iterate through each element
        for (int i = 0; i < nums.length; i++) {
            // For each element, check all elements after it
            for (int j = i + 1; j < nums.length; j++) {
                // If sum equals target, return indices
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        // This should never be reached given problem constraints
        return new int[]{};
    }
    
    // APPROACH 2: BETTER APPROACH (Two-pass Hash Map)
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // Use hash map to store values and their indices
    public int[] twoSumTwoPass(int[] nums, int target) {
        // Create hash map to store value -> index mapping
        Map<Integer, Integer> map = new HashMap<>();
        
        // First pass: populate the hash map
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        // Second pass: find complement
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // Check if complement exists and is not the same element
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        
        return new int[]{};
    }
    
    // APPROACH 3: OPTIMAL APPROACH (One-pass Hash Map)
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // Build hash map while searching for complement
    public int[] twoSum(int[] nums, int target) {
        // Create hash map to store value -> index mapping
        Map<Integer, Integer> map = new HashMap<>();
        
        // Single pass through array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if complement exists in map
            if (map.containsKey(complement)) {
                // Return indices: complement index first, then current index
                return new int[]{map.get(complement), i};
            }
            
            // Add current element to map
            map.put(nums[i], i);
        }
        
        // This should never be reached given problem constraints
        return new int[]{};
    }
    
    // Test method with sample inputs
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1: [2,7,11,15], target = 9
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Test 1: " + Arrays.toString(result1)); // Expected: [0, 1]
        
        // Test Case 2: [3,2,4], target = 6
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Test 2: " + Arrays.toString(result2)); // Expected: [1, 2]
        
        // Test Case 3: [3,3], target = 6
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Test 3: " + Arrays.toString(result3)); // Expected: [0, 1]
    }
}

/*
 * COMPLEXITY ANALYSIS:
 * 
 * 1. Brute Force Approach:
 *    - Time: O(n^2) - nested loops through the array
 *    - Space: O(1) - only using constant extra space
 *    - When to use: When space is extremely limited and n is small
 * 
 * 2. Two-Pass Hash Map:
 *    - Time: O(n) - two passes through the array
 *    - Space: O(n) - hash map stores all elements
 *    - When to use: When you want clear separation of concerns
 * 
 * 3. One-Pass Hash Map (Optimal):
 *    - Time: O(n) - single pass through the array
 *    - Space: O(n) - hash map stores at most n-1 elements
 *    - When to use: Best overall solution for most cases
 * 
 * KEY INSIGHTS:
 * - Hash map allows O(1) average case lookup
 * - Trade space for time to achieve linear time complexity
 * - One-pass solution is more efficient as it may terminate early
 * - HashMap handles duplicate values correctly by overwriting indices
 */
