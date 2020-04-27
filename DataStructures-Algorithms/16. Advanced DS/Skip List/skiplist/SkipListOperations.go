package skiplist

import "fmt"

func NewSkipList() *SkipList {
	return &SkipList{
		Head:  nil,
		Level: 1,
		Size:  0,
	}
}

/* Inserts a new key into SkipList */
func (skiplist *SkipList) Insert(key int) {
	nodesToUpdate := [MAX_LEVEL]*SkipListNode{}
	current := skiplist.Head
	currentMaxLevel := skiplist.Level

	for i := currentMaxLevel - 1; i >= 0; i-- {
		for current.Forward[i] != nil && current.Forward[i].Value < key {
			current = current.Forward[i]
		}
		nodesToUpdate[i] = current
	}
	current = current.Forward[0]
	// Generate random level for node
	randomLevel := GetRandomLevel()

	if current == nil || current.Value != key {
		if randomLevel > currentMaxLevel {
			for i := currentMaxLevel; i < randomLevel; i++ {
				nodesToUpdate[i] = skiplist.Head
			}
			// Update the SkipList current max. level
			skiplist.Level = randomLevel
		}

	}
	newNode := NewSkipListNode(key, randomLevel)

	for i := 0; i < randomLevel; i++ {
		newNode.Forward[i] = nodesToUpdate[i].Forward[i]
		nodesToUpdate[i].Forward[i] = newNode
	}
	fmt.Printf("Successfully inserted Key : %v, with Level : %v \n", key, randomLevel)
}

/* Searching an element in the SkipList */
func (skiplist *SkipList) Search(target int) bool {
	var nodesTraversed []int
	current := skiplist.Head
	currentMaxLevel := skiplist.Level - 1

	for i := currentMaxLevel; i >= 0; i-- {
		for current.Forward[i] != nil && current.Forward[i].Value < target {
			nodesTraversed = append(nodesTraversed, current.Forward[i].Value)
			current = current.Forward[i]
		}
	}
	current = current.Forward[0]

	if current != nil && current.Value == target {
		fmt.Println("Traversed nodes on the way : ", nodesTraversed)
		return true
	}
	return false
}

/* Deletes a node from the SkipList */
func (skiplist *SkipList) Delete(target int) bool {
	nodesToUpdate := [MAX_LEVEL]*SkipListNode{}
	currentMaxLevel := skiplist.Level - 1
	current := skiplist.Head

	for i := currentMaxLevel; i >= 0; i-- {
		for current.Forward[i] != nil && current.Forward[i].Value < target {
			current = current.Forward[i]
		}
		nodesToUpdate[i] = current
	}
	fmt.Println(nodesToUpdate)
	current = current.Forward[0]

	// If node exists, removes it from SkipList
	if current != nil && current.Value == target {
		for i := 0; i <= currentMaxLevel; i++ {
			if nodesToUpdate[i].Forward[i] != current {
				break
			}
			nodesToUpdate[i].Forward[i] = current.Forward[i]
		}
		// Remove levels having no elements
		for currentMaxLevel >= 0 && skiplist.Head.Forward[currentMaxLevel] == nil {
			currentMaxLevel--
		}
		skiplist.Level = currentMaxLevel
		return true
	}
	return false
}

/* Prints the SkipList as Level By Level */
func (skiplist *SkipList) PrintList() {

	for i := 0; i < MAX_LEVEL; i++ {
		fmt.Print(" Level ", i, " : ")
		node := skiplist.Head.Forward[i]
		for node != nil {
			fmt.Printf(" %v,", node.Value)
			node = node.Forward[i]
		}
		fmt.Println()
	}
}
