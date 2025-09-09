# Pattern Printing 1

## Problem Statement
Print a pattern for given N rows where each row i contains stars from 1 to i.

## Examples

### Example 1:
**Input:** N = 5  
**Output:**
```
*
**
***
****
*****
```

### Example 2:
**Input:** N = 3  
**Output:**
```
*
**
***
```

### Example 3:
**Input:** N = 1  
**Output:**
```
*
```

## Constraints
- 1 <= N <= 100

## Approaches

### 1. Brute Force Approach
- **Logic:** Use nested loops where outer loop runs for rows and inner loop prints stars
- **Time Complexity:** O(n²)
- **Space Complexity:** O(1)
- **Best for:** Simple implementation, good for understanding

### 2. Better Approach (String Repeat)
- **Logic:** Use Java's `String.repeat()` method for cleaner code
- **Time Complexity:** O(n²)
- **Space Complexity:** O(n)
- **Best for:** Cleaner code, good for smaller patterns

### 3. Optimal Approach (StringBuilder)
- **Logic:** Build pattern incrementally using StringBuilder for efficient string operations
- **Time Complexity:** O(n²)
- **Space Complexity:** O(n)
- **Best for:** Large patterns, most efficient string operations

### 4. Recursive Approach
- **Logic:** Use recursion to print each row
- **Time Complexity:** O(n²)
- **Space Complexity:** O(n) - due to recursion stack
- **Best for:** Educational purposes, demonstrates recursive thinking

### 5. Single Loop Approach
- **Logic:** Use mathematical calculation to determine row transitions
- **Time Complexity:** O(n²)
- **Space Complexity:** O(1)
- **Best for:** Alternative mathematical approach

## Key Insights
- All approaches have O(n²) time complexity due to the inherent nature of the problem
- StringBuilder approach is most practical for large inputs
- Pattern problems often have multiple valid solutions
- Space complexity varies based on approach chosen
- For competitive programming, brute force is often sufficient and fastest to code

## Files
- `Solution.java` - Contains all approaches with detailed comments
- `input.txt` - Sample test cases
- `output.txt` - Expected outputs
- `README.md` - This file with problem explanation

## Usage
1. Compile: `javac Solution.java`
2. Run: `java Solution`
3. Check output against expected results in `output.txt`

## Related Topics
- Pattern Printing
- Nested Loops
- String Manipulation
- Recursion
- Basic Programming
