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