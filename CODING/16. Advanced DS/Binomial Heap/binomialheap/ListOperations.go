package binomialheap

/* Creating a new BinomialTree node */
func NewBinomialHeap() *LinkedList {
	return &LinkedList{
		Head: nil,
		Size: 0,
	}
}

/* It returns node with same order of parameter node passed,otherwise returns nil */
func getNodeWithSameDegree(head *BinomialHeapNode, degree int) *BinomialHeapNode {

	for current := head; current != nil; current = current.Sibling {
		if current.Degree == degree {
			return current
		}
	}
	return nil
}

/* Inserts new node into Binomial Tree */
func insertToList(head **BinomialHeapNode, newNode *BinomialHeapNode) {
	var prev, next *BinomialHeapNode = nil, *head

	for next != nil && newNode.Degree > next.Degree {
		prev = next
		next = next.Sibling
	}
	if prev == nil && next == nil {
		*head = newNode
	} else if prev == nil && next != nil {
		newNode.Sibling = *head
		*head = newNode
	} else if prev != nil && next == nil {
		prev.Sibling = newNode
	} else if prev != nil && next != nil {
		prev.Sibling = newNode
		newNode.Sibling = next
	}
}

/* Gets the left sibling of Head of a Binomial Tree */
func getLeftSibling(head *BinomialHeapNode, actualNode *BinomialHeapNode) *BinomialHeapNode {

	if head == actualNode {
		return nil
	}
	current := head

	for current.Sibling != actualNode {
		current = current.Sibling
	}
	return current
}

/* Removes a node from Binomial Tree */
func removeFromList(head **BinomialHeapNode, targetNode *BinomialHeapNode) {
	leftSibling := getLeftSibling(*head, targetNode)

	if leftSibling == nil {
		*head = targetNode.Sibling
	} else {
		leftSibling.Sibling = targetNode.Sibling
	}
	targetNode.Sibling = nil
}

/* Inserting into Binomial Forest */
func (bh *LinkedList) Put(newNode *BinomialHeapNode) {
	sameDegreeNode := getNodeWithSameDegree(bh.Head, newNode.Degree)

	if sameDegreeNode == nil {
		insertToList(&bh.Head, newNode)
	} else {
		removeFromList(&bh.Head, sameDegreeNode)
		linkedNode := Union(sameDegreeNode, newNode)
		bh.Put(linkedNode)
	}
}

/* Get all siblings of a node */
func GetAllSiblings(head *BinomialHeapNode) []*BinomialHeapNode {
	var siblings []*BinomialHeapNode

	for current := head; current != nil; current = current.Sibling {
		siblings = append(siblings, current)
	}
	return siblings
}

/* Gets min. node from among all BinomialHeap Head nodes */
func GetMinimumNode(head *BinomialHeapNode) *BinomialHeapNode {
	var min, current *BinomialHeapNode = head, head.Sibling

	for current != nil {
		if current.Value < min.Value {
			min = current
		}
		current = current.Sibling
	}
	return min
}
