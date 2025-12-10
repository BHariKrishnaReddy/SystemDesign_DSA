# Sliding Window

Problem type it solves :
* Sliding Window is used when you need to examine contiguous (continuous) parts of an array/string.

Examples:
1. Longest subarray with something
2. Smallest subarray that meets a condition
3. Count subarrays with specific properties
4. Maximum/minimum sum of any window of size K

### Why do we need Sliding Window?

* Without sliding window / Brute force approach:  `Check all possible subarrays → O(n²) time.`

* Sliding window approach:
    * Instead of recomputing the whole subarray every time, we "slide" from left to right and efficiently update the answer → O(n) time.

### Idea

We maintain a window defined by two pointers:
* **left** (start of window) and **right** (end of window)
* As right moves forward: we expand window
* if window becomes invalid, we shrink window by moving left
* You do **NOT recalculate from scratch**. You simply update the old sum.

### Two major types of sliding windows
* Type 1: **Fixed**-size window. Window size = constant (K).

* Type 2: **Variable**-size window. Window size changes based on condition.

`This is the pattern:  expand → break condition → shrink → restore validity → continue`

🔑 How to identify Sliding Window problems
* Look for these keywords in a problem statement:
* subarray / substring
* contiguous
* at most K
* longest / shortest
* sum / average
* "without repeating"
* "with K distinct"
* If it requires checking every possible continuous segment, sliding window is the right tool.

## Step-by-Step Logic Template

```
left = 0                                             // start of window
for right in range(len(arr)):                        //right end of window

    include arr[right] into window                   //Expand by moving right

    while window becomes invalid:
         remove arr[left]                            //Shrink by moving left
         left++

    update answer (if needed)
```

### Questions to Practice (No Duplicates, No Same-Pattern Variants)

| Checkbox | Level  | Question                                                                                 | Topics Covered                               |
|----------|--------|-------------------------------------------------------------------------------------------|-----------------------------------------------|
| [ ]      | Easy   | Longest substring without repeating characters                                           | Strings, HashMap, Unique Window              |
| [ ]      | Easy   | Check if string B is a permutation of any substring of string A                          | Anagram Window, Fixed Window, Frequency Map  |
| [ ]      | Easy   | Count how many substrings have at most K distinct characters                             | Strings, Frequency Window                    |
| [ ]      | Easy   | Longest substring with at most K distinct characters                                     | Variable Window, Frequency Control           |
| [ ]      | Easy   | Count subarrays where the number of odd elements is ≤ K                                  | Condition-Based Window                       |
| [ ]      | Easy   | Longest subarray that contains at most K zeroes                                          | Binary Array, Replace Zeros, Expand–Shrink   |
| [ ]      | Medium | Find the smallest substring that contains all characters of a pattern (Min Window)       | Covering Window, Frequency Map, Shrinking    |
| [ ]      | Medium | Longest substring where vowels appear in non-decreasing order                            | Ordering-Based Window                        |
| [ ]      | Medium | Smallest subarray that contains at least one occurrence of each category label           | Window Covering, Distinct Categories         |
| [ ]      | Medium | Check if any subarray of length ≥ 2 has duplicate elements                               | Duplicate Detection, Frequency Map           |
| [ ]      | Medium | Count number of subarrays with sum < K (positive numbers only)                           | Sum Constraint, Expand–Shrink                |
| [ ]      | Medium | Longest subarray with sum ≤ K (positive numbers only)                                    | Variable Window, Sum Constraint              |
| [ ]      | Medium | Longest subarray with product < K                                                        | Product Window, Multiplicative Constraint    |
| [ ]      | Medium | Count subarrays where no element appears more than twice                                 | Frequency Constraint, Validity Window        |
| [ ]      | Medium | Longest substring where you can replace at most K characters to make all letters same    | Character Replace, Frequency Max             |
| [ ]      | Hard   | Longest subarray where max(arr) – min(arr) ≤ X                                           | Monotonic Queue, Range Window                |
| [ ]      | Hard   | Find the number of subarrays where the average is ≥ threshold T                          | Sum Transform, Dynamic Window                |
| [ ]      | Hard   | Longest subarray whose elements can be rearranged into a consecutive sequence            | Max-Min Window, Frequency & Range Check      |
| [ ]      | Hard   | Sliding Window Maximum (find max in each window of size K using deque)                   | Monotonic Deque, Fixed Window                |
| [ ]      | Hard   | Find sum of (max - min) for every window of size K                                       | Two Monotonic Deques, Advanced Window        |

