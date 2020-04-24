package binomialheap

type BinomialHeapNode struct {
	Value   int               // value of the node
	Degree  int               // number of children
	Parent  *BinomialHeapNode // points to parent node
	Child   *BinomialHeapNode // points to left most child
	Sibling *BinomialHeapNode // points to right side sibling
}

type LinkedList struct { // contains the heads of all Binomial Trees
	Head *BinomialHeapNode // points to head of entire Binomial Heap
	Size int               // number of nodes in Heap
}
