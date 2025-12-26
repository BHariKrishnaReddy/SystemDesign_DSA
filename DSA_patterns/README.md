# DSA

<h2 align = center >DSA problems don’t have infinite solutions.They reuse ~8–10 core ideas again and again.</h2><br>

Before Getting A head with problem solving You should check [the bridge from Java basics to data structures and algorithms (DSA)](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/blob/main/DSA_patterns/DSA_Bridge.pdf)



## 📌 Core DSA Patterns & Techniques

| Topic | Simple Definition | Common Use Cases | Key Idea / Mental Signal |
|------|-------------------|------------------|--------------------------|
| **Two Pointers** | Use two indices to traverse a data structure efficiently | Pair problems, palindrome check, remove duplicates, merge sorted arrays | “I can move left and right independently” |
| **Prefix Sum / Prefix Count** | Precompute cumulative sums/counts to answer range queries fast | Subarray sum problems, range queries, handling negatives | “I need info about everything before index i” |
| **Monotonic Stack** | Stack that maintains elements in increasing or decreasing order | Next greater/smaller element, stock span, histogram problems | “Order matters, and some elements become useless” |
| **Monotonic Deque** | Deque that keeps max/min in a sliding window | Sliding window max/min, range-based windows | “I need max/min of window in O(1)” |
| **Heap (Priority Queue)** | Data structure to always access smallest/largest element quickly | Top K problems, scheduling, merging sorted lists | “I always need the best candidate right now” |
| **Binary Search (on Answer Space)** | Binary search applied to possible answers, not just arrays | Optimization problems, capacity/speed thresholds | “Answer space is monotonic (possible → impossible)” |
| **Graph Traversal (BFS / DFS)** | Explore nodes and edges to analyze connectivity | Shortest path, islands, cycles, connected components | “This problem is about relationships, not order” |
| **Dynamic Programming (DP)** | Solve problems using overlapping subproblems and optimal substructure | Knapsack, subsequences, grid paths, optimization | “Decision at i depends on earlier decisions” |
| **Bit Manipulation** | Use bits to represent and manipulate states efficiently | XOR tricks, single number, subsets, state compression | “Each bit has meaning” |


## 🌳 DSA Decision Guide — Which Technique to Use?

| Question to Ask | If YES → Use | If NO → Go To |
|-----------------|--------------|---------------|
| Is the problem about a **contiguous subarray / substring**? | Sliding Window | Sorted / Graph / DP checks |
| Does the window have a **validity condition** (≤K, ≥K, exactly K)? | Sliding Window | Order-based logic |
| Does the window need **frequency tracking**? | Sliding Window + Frequency Map/Array | Numeric / Order checks |
| Does the window need **max / min** continuously? | Monotonic Deque | Basic Sliding Window |
| Are **negative numbers** involved? | Prefix Sum + HashMap | Sliding Window |
| Is the input **sorted or monotonic**? | Two Pointers / Binary Search | Heap / Stack checks |
| Do you need **top / min / max repeatedly**? | Heap (Priority Queue) | Order-based checks |
| Do you need **next greater / smaller** elements? | Monotonic Stack | Optimization checks |
| Are there **choices / overlapping subproblems**? | Dynamic Programming | Graph checks |
| Is the problem about **connections / traversal**? | BFS / DFS | Bit logic |
| Is the problem about **bits / XOR / subsets**? | Bit Manipulation | Re-evaluate problem |


Check Out Pattren based Problems
1. [Sliding Window](https://github.com/BHariKrishnaReddy/SystemDesign_DSA/tree/main/DSA_patterns/SlidingWindow)
