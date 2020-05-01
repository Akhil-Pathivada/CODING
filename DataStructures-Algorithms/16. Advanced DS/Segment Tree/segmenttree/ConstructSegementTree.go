package segmenttree

import (
	"math"
)

/* Constructing Segment Tree for efficiently find the Sum of given range */
func ConstructSegmentTree(arr []int) []int {
	inputArraySize := len(arr)
	// To get required size of Segment Tree
	segmentTreeSize := calculateSegmentTreeSize(inputArraySize)
	// Creating a Segment Tree with calculated size
	segmentTree := make([]int, segmentTreeSize)
	// Initialise values into Segment Tree
	buildSegmentTree(arr, 0, inputArraySize-1, segmentTree, 0)
	return segmentTree
}

func calculateSegmentTreeSize(originalSize int) int {
	return 1<<uint(math.Ceil(math.Log2(float64(originalSize)))+1) - 1
}

/* To fill values into Segment Tree */
func buildSegmentTree(arr []int, ss int, se int, tree []int, si int) int {
	// If there is one element in array, store it in current node of segment tree and return
	if ss == se {
		tree[si] = arr[ss]
		return arr[ss]
	}
	mid := getMid(ss, se)
	tree[si] = buildSegmentTree(arr, ss, mid, tree, si*2+1) + buildSegmentTree(arr, mid+1, se, tree, si*2+2)
	return tree[si]
}

func getMid(s int, e int) int {
	return s + (e-s)/2
}
