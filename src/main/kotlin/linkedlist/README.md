# Linked Lists:

- Simply explained, a linked list is just a chain of nodes.
- Each node contains 2 things:
  * a value (of generic type)
  * a reference to the next node in the chain (in doubly linked lists each node has an additional reference to the previous node).

- My implementation of linked lists is really easy to understand. I First defined "Node.kt" which is a data class to represent a node.
- The class "LinkedList.kt" defines the linked list by a reference to the head and tail of the chain (and none of other nodes).

### * Please remember that when a LinkedList has only 1 Node, both head and tail of that LinkedList are equal to that node. And also, when it's empty, both head and tail are null. *