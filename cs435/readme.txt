********************** Problem 1 ****************************

For this problem, you will implement a max heap using an array for underlying storage. For example, in C++, the class definition would look like:
class MaxHeap {
    vector<int> data;
};
You will need to implement the following operations on heaps:
size which returns the number of items in the heap.
max lookup which returns the max element in the heap.
extract max which removes the max element from the heap.
insert which takes an integer and adds it to the max heap.
delete which takes an index and removes the item at that index from the heap.
For example, in C++, the function headers would be the following:
class MaxHeap {
    vector<int> data;
  public:
    MaxHeap() {
// ...
}
int size() {
// ...
    }
    int maxLookup() {
// ...
    }
    void extractMax() {
// ...
    }
    void insert(int data) {
// ...
    }
    void remove(int index) {
// ...
} };

Input
• The first line contains an integer n, 0 ≤ n ≤ 100, denoting the number of commands following it.
• The next n lines will consist of one of 5 commands (”size”, ”maxLookup”, ”extract- Max”, ”insert”, and ”delete”).
• The commands ”insert” and ”delete” will be followed by a space and an integer to perform the command on.
• At the end of the input there will be a blank line.
Your program should initialize an empty max heap and perform the commands given by the input, in sequence, on it. See sample input and output below for a concrete example.
(Note that the argument to ”delete” represents the index of the element in the underlying array, not the element itself.)
Constraints
You can assume there will be no invalid input including never calling maxLookup on an empty heap or calling delete on out-of-bounds index. You can assume the max heap will consist only of positive integers with no duplicates.
Output
• For the ”maxLookup” command, print the max.
• For the ”size” command, print the number of elements in the heap.
• For the ”insert”, ”delete”, and ”extractMax” commands, print nothing.
See the sample output section for a concrete example.

Sample Input 1
25
size
insert 5
maxLookup
insert 18
maxLookup
insert 3
maxLookup
insert 12
insert 19
maxLookup
extractMax
maxLookup
insert 25
insert 6
insert 1
size
extractMax
extractMax
extractMax
size
delete 1
delete 1
delete 0
size
maxLookup

Sample Output 1

0
5
18
18
19
18
7
4
1
1

********************** Problem 2 ****************************

For this problem, we will implement a Complete tree using nodes. For example, in C++, the node and class definitions would look like this:
struct Node {
    int data;
    Node* left;
    Node* right;
    Node* parent;
};
class CompleteTree {
Node* root;
... };
You will need to implement the following operations on complete trees:
fromArray which creates nodes for a complete tree represented by the given array.
toArray which returns the array representation of the complete tree.
isBST which returns true if the complete tree is a Binary Search Tree.
preOrder which prints a pre-order traversal of the tree.
postOrder which prints a post-order traversal of the tree.
numNodesInLookup which prints the number of nodes visited when looking up the given value.
For example, in C++, the function headers would be the following:
class CompleteTree {
    Node* root;
  public:
    CompleteTree() {
// ...
    }
    void fromArray(vector<int> list) {
// ...
    }
    vector<int> toArray() {
// ...
    }
    bool isBST() {
// ...
     }
     void preOrder() {
// ...
     }
     void postOrder() {
// ...
     }
     int numNodesInLookup(int value) {
    // ...

    Input
    • The first line contains an integer n, 0 ≤ n ≤ 100, denoting the number of nodes in the tree.
    • The next line will consist of n integers that make up the values to be stored in the tree.
    • The third line contains an integer m, 0 ≤ m ≤ 10, denoting the number of commands in the following lines.
    • The next m lines have one of the following commands (”toArray”, ”isBST”, ””pre- Order”, ”postOrder”, ”numNodesInLookup”) per line.
    Constraints
    In this problem, a binary search tree must have unique values. You can assume the value given to ”numNodesInLookup” is in the tree.
    numNodesInLookup should try to look at as few nodes as possible. This means that if the tree is a Binary Search Tree, it should use binary search. If the tree is not a binary tree, use level-order traversal.
    Output
    • ”toArray” will print out the array representation of the complete tree.
    • ”isBST” will print out either ”true” or ”false”.
    • ”preOrder” and ”postOrder” will print out the order they visit each node respectively.
    • ”numNodesInLookup” will print out an integer.
    }
};

Sample Input 1
10
1 2 3 4 5 6 7 8 9 10 4
isBST
preOrder
toArray numNodesInLookup 4

Sample Output 1
false
1 2 4 8 9 5 10 3 6 7 1 2 3 4 5 6 7 8 9 10 4


Sample Input 2
12
100 53 172 24 64 150 200 12 33 60 98 130 3
isBST
postOrder
numNodesInLookup 98


Sample Output 2
true
12 33 24 60 98 64 53 130 150 200 172 100 4

****************************Problem 3*****************************


There is a promotional offer in a bookstore “Take 3, pay for the 2 more expensive ones”. So, each customer who picks 3 books gets the cheapest one for free. Of course, the customer can take even more books and, depending on the way the books are arranged into groups of three, get the cheapest one in each group for free.
For example, let the prices of the books taken by the customer be: 2,3,4,4,6,9,10. If he arranges them into the groups (10,3,2), (4,6,4) and (9), he will get the book priced 2 from the first group for free and the book priced 4 from the second group. We can see that he will not get anything for free from the third group because it contains only one book.
The lady working in the bookstore is well-intentioned and she always wants to lower the price for each customer as much as possible. For given book prices, help the lady arrange the books into groups in the best way possible, so that the total price the customer has to pay is minimal.
Hints
Think about the data structure and algorithms we’ve covered so far. Are there any that can help you solve this problem?
Input
• The first line of input contains the integer-N,1 ≤ N ≤ 100, denoting the number of books the customer bought.
• Each of the following N lines contains a single integer C,1 ≤ C ≤ 100, the price of each book.
Constraints
The lady doesn’t have to arrange the books into groups so that each group contains exactly 3 books, but the number of books in a group needs to be between 1 and 3, inclusively.
Output
• The first and only line of output must contain the required minimal price.


Sample Input
4 3 2 3 2

Sample Output
8

Sample Input
6 6 4 5 5 5 5

Sample Output
21

