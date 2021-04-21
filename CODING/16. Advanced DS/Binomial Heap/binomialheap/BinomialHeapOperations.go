package binomialheap

/* Inserting an element into BinomialHeap */
func (bh *LinkedList) Insert(key int) *BinomialHeapNode {
	bh.Size++
	newHeap := NewBinomialHeapNode(key)
	bh.Put(newHeap)
	return newHeap
}

/* Merges two BinomialHeaps */
func (bh *LinkedList) MergeTwoBinomialHeaps(other *LinkedList) {

	for _, child := range GetAllSiblings(other.Head) {
		removeFromList(&other.Head, child)
		bh.Put(child)
	}
}

/* Extracts min. element from BinomialHeap */
func (bh *LinkedList) ExtractMin() int {

	if bh.Head == nil {
		return -1
	}
	min := GetMinimumNode(bh.Head)
	removeFromList(&bh.Head, min)

	for _, child := range GetAllSiblings(min.Child) {

		removeFromList(&min.Child, child)
		bh.Put(child)
	}
	return min.Value
}

/* Decreases a particular node value from BinomialHeap */
func (targetNode *BinomialHeapNode) DecreaseKey(newValue int) {
	targetNode.Value = newValue
	targetNode.BubbleUpToParent()
}
