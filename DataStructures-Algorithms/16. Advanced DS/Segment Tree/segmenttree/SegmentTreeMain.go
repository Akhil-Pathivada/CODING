package segmenttree

import "fmt"

func SegmentTreeMain() {
	inputArray := []int{1, 3, 5, 7, 9, 11}
	var segmentTree []int

	for true {
		var option int
		fmt.Print("\n 1. Construct Segment Tree \n 2. Print Segment Tree \n 3. Find sum in range \n Select an option : ")
		fmt.Scanf("%d", &option)
		switch option {
		case 1:
			{
				segmentTree = ConstructSegmentTree(inputArray)
			}
		case 2:
			{
				fmt.Println(segmentTree)
			}
		case 3:
			{
				var qs, qe int
				fmt.Print("Enter range : ")
				fmt.Scanf("%d", &qe)
				fmt.Scanf("%d", &qs)
				fmt.Println(qs, qe)
				fmt.Printf("Sum in range %v to %v = %v ", qe, qs, GetSumInRange(segmentTree, len(inputArray), 1, 3))
			}
		}
		if option > 3 {
			break
		}
	}
}
