package skiplist

import "math/rand"

/* Creates a new node and returns */
func NewSkipListNode(key int, level int) *SkipListNode {
	return &SkipListNode{
		Value:   key,
		Forward: make([]*SkipListNode, level),
	}
}

/* Gives a random level for a newly inserting node */
func GetRandomLevel() int {
	min := 1
	max := 5
	return rand.Intn(max-min) + min
}
