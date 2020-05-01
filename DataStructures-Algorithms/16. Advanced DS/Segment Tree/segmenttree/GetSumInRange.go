package segmenttree

func getSumInRangeUtil(tree []int, ss int, se int, qs int, qe int, index int) int {

	if qs <= ss && qe >= se {
		return tree[index]
	}
	if ss > qe || se < qs {
		return 0
	}
	mid := getMid(ss, se)
	return getSumInRangeUtil(tree, ss, mid, qs, qe, 2*index+1) + getSumInRangeUtil(tree, mid+1, se, qs, qe, 2*index+2)
}

func GetSumInRange(tree []int, n int, qs int, qe int) int {

	if qs < 0 || qe > n-1 || qs > qe {
		return -1
	}
	return getSumInRangeUtil(tree, 0, n-1, qs, qe, 0)
}
