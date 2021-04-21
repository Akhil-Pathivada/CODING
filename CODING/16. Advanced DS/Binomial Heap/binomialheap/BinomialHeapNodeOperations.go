package binomialheap

import "fmt"

/* Creating a new BinomialTree node */
func NewBinomialHeapNode(value int) *BinomialHeapNode {
	return &BinomialHeapNode{
		Value:   value,
		Degree:  0,
		Parent:  nil,
		Child:   nil,
		Sibling: nil,
	}
}

/* Linking two BinomialTrees of same Degree */
func (parent *BinomialHeapNode) makeAsChild(newChild *BinomialHeapNode) {
	newChild.Parent = parent
	newChild.Sibling = parent.Child
	parent.Child = newChild

}

/* Making Union of two BinomialTrees of same Degree */
func Union(n1 *BinomialHeapNode, n2 *BinomialHeapNode) *BinomialHeapNode {

	if n1.Value < n2.Value {
		n1.Degree++
		n1.makeAsChild(n2)
		return n1
	}
	n2.Degree++
	n2.makeAsChild(n1)
	return n2

}

/* Prints root nodes of all BinomialTrees */
func (bh *LinkedList) PrintBinomialHeap() {

	if bh.Head == nil {
		fmt.Println("Binomial Heap is Empty")
		return
	}
	for _, node := range GetAllSiblings(bh.Head) {
		fmt.Printf(" %v,", node.Value)
		node.printDFS()
	}
}

/* Recursively prints all BinomialTree children nodes */
func (node *BinomialHeapNode) printDFS() {

	for _, child := range GetAllSiblings(node.Child) {
		fmt.Printf(" %v,", child.Value)
		child.printDFS()
	}
}

/* Swaps Parent, Child values, where Parent > Child */
func (node *BinomialHeapNode) BubbleUpToParent() {

	if node.Parent == nil {
		return
	}
	for node.Parent != nil && node.Parent.Value > node.Value {
		node.Value, node.Parent.Value = node.Parent.Value, node.Value
		node = node.Parent
	}
}
