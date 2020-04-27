package skiplist

const (
	MAX_LEVEL = 4
)

type SkipListNode struct {
	Value   int             // value of node
	Forward []*SkipListNode // pointers to next, next level nodes
}

type SkipList struct {
	Level int           // current max. level of the SkipList Head
	Size  int           // number of nodes in SkipList
	Head  *SkipListNode // points to Head of SkipList
}
