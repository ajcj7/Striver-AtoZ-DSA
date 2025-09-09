/*
 * Pattern Printing 1 Problem - Easy Level
 * 
 * Problem Statement:
 * Print a pattern for given N rows where each row i contains stars from 1 to i.
 * 
 * Example 1:
 * Input: N = 5
 * Output:
 * *
 * **
 * ***
 * ****
 * *****
 * 
 * Example 2:
 * Input: N = 3
 * Output:
 * *
 * **
 * ***
 * 
 * Example 3:
 * Input: N = 1
 * Output:
 * *
 * 
 * Constraints:
 * - 1 <= N <= 100
 */
import java.util.*;

public class Solution {
    
    // APPROACH 1: BRUTE FORCE
    // Time Complexity: O(n^2)
    // Space Complexity: O(1) - not counting output space
    // Simple nested loop approach
    public void printPattern1BruteForce(int n) {
        // Outer loop for number of rows
        for (int i = 1; i <= n; i++) {
            // Inner loop for printing stars in each row
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // Move to next line after each row
            System.out.println();
        }
    }
    
    // APPROACH 2: BETTER APPROACH (Using String Repeat)
    // Time Complexity: O(n^2)
    // Space Complexity: O(n) - for string creation
    // Use Java's string repeat functionality for cleaner code
    public void printPattern1Better(int n) {
        // For each row i, repeat "*" i times
        for (int i = 1; i <= n; i++) {
            // Create string with i stars and print
            System.out.println("*".repeat(i));
        }
    }
    
    // APPROACH 3: OPTIMAL APPROACH (StringBuilder)
    // Time Complexity: O(n^2)
    // Space Complexity: O(n) - for StringBuilder
    // Most efficient for large patterns due to reduced string operations
    public void printPattern1Optimal(int n) {
        StringBuilder pattern = new StringBuilder();
        
        // Build pattern incrementally
        for (int i = 1; i <= n; i++) {
            // Add one more star for current row
            pattern.append("*");
            // Print current pattern
            System.out.println(pattern.toString());
        }
    }
    
    // APPROACH 4: RECURSIVE APPROACH
    // Time Complexity: O(n^2)
    // Space Complexity: O(n) - due to recursion stack
    // Demonstrates recursive thinking for pattern problems
    public void printPattern1Recursive(int n) {
        printPatternRecursiveHelper(n, 1);
    }
    
    private void printPatternRecursiveHelper(int n, int currentRow) {
        // Base case: if current row exceeds n, stop
        if (currentRow > n) {
            return;
        }
        
        // Print stars for current row
        for (int j = 1; j <= currentRow; j++) {
            System.out.print("*");
        }
        System.out.println();
        
        // Recursive call for next row
        printPatternRecursiveHelper(n, currentRow + 1);
    }
    
    // APPROACH 5: SINGLE LOOP WITH CALCULATION
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    // Alternative approach using mathematical calculation
    public void printPattern1SingleLoop(int n) {
        int totalElements = n * (n + 1) / 2; // Total stars to print
        int currentRow = 1;
        int starsInCurrentRow = 0;
        
        for (int i = 1; i <= totalElements; i++) {
            System.out.print("*");
            starsInCurrentRow++;
            
            // If we've printed enough stars for current row
            if (starsInCurrentRow == currentRow) {
                System.out.println();
                currentRow++;
                starsInCurrentRow = 0;
            }
        }
    }
    
    // Test method with sample inputs
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Pattern Printing 1 - All Approaches ===");
        
        // Test Case 1: N = 5
        System.out.println("\nTest Case 1: N = 5");
        System.out.println("\n1. Brute Force Approach:");
        solution.printPattern1BruteForce(5);
        
        System.out.println("\n2. Better Approach (String Repeat):");
        solution.printPattern1Better(5);
        
        System.out.println("\n3. Optimal Approach (StringBuilder):");
        solution.printPattern1Optimal(5);
        
        System.out.println("\n4. Recursive Approach:");
        solution.printPattern1Recursive(5);
        
        System.out.println("\n5. Single Loop Approach:");
        solution.printPattern1SingleLoop(5);
        
        // Test Case 2: N = 3
        System.out.println("\n\nTest Case 2: N = 3");
        System.out.println("\nOptimal Approach Output:");
        solution.printPattern1Optimal(3);
        
        // Test Case 3: N = 1
        System.out.println("\n\nTest Case 3: N = 1");
        System.out.println("\nOptimal Approach Output:");
        solution.printPattern1Optimal(1);
        
        scanner.close();
    }
}

/*
 * COMPLEXITY ANALYSIS:
 * 
 * 1. Brute Force Approach:
 *    - Time: O(n^2) - nested loops, outer runs n times, inner runs 1+2+...+n times
 *    - Space: O(1) - only using constant extra space
 *    - When to use: Simple implementation, good for understanding
 * 
 * 2. Better Approach (String Repeat):
 *    - Time: O(n^2) - repeat() method internally creates string of length i
 *    - Space: O(n) - creates new string for each row
 *    - When to use: Cleaner code, good for smaller patterns
 * 
 * 3. Optimal Approach (StringBuilder):
 *    - Time: O(n^2) - still need to print n*(n+1)/2 stars total
 *    - Space: O(n) - StringBuilder grows incrementally
 *    - When to use: Best for large patterns, most efficient string operations
 * 
 * 4. Recursive Approach:
 *    - Time: O(n^2) - same number of operations as iterative
 *    - Space: O(n) - recursion stack depth is n
 *    - When to use: Educational purposes, demonstrates recursive thinking
 * 
 * 5. Single Loop Approach:
 *    - Time: O(n^2) - total operations still n*(n+1)/2
 *    - Space: O(1) - constant extra space
 *    - When to use: Alternative mathematical approach
 * 
 * KEY INSIGHTS:
 * - All approaches have O(n^2) time complexity due to inherent nature of problem
 * - StringBuilder approach is most practical for large inputs
 * - Pattern problems often have multiple valid solutions
 * - Space complexity varies based on approach chosen
 * - For competitive programming, brute force is often sufficient and fastest to code
 */
