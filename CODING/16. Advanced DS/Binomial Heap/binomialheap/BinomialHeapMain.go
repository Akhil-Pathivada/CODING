package binomialheap

import (
	"fmt"
	"log"
)

const (
	MinInt32 = -1 << 31
)

func BinomialHeapMain() {

	binomialHeap := NewBinomialHeap()
	elements := []int{3, 10, 7, 20, 70, 25, 30, 8, 12, 33, 72, 2, 9}
	var pointerToNode *BinomialHeapNode

	for true {
		var option int
		fmt.Print("\n 1. Insert\n 2. Extract Minimum\n 3. Merge\n 4. Decrease Key\n 5. Delete Element\n 6. Print Binomial Tree\n Select an option : ")
		fmt.Scanf("%d", &option)

		switch option {
		case 1:
			{
				for i := 0; i < len(elements); i++ {
					binomialHeap.Insert(elements[i])
				}
			}
		case 2:
			{
				fmt.Println("Extracted Min. Element =  ", binomialHeap.ExtractMin())
			}
		case 3:
			{
				newHeap := NewBinomialHeap()
				elements := []int{89, 88, 87, 86, 85, 84, 83, 82, 81}
				for i := 0; i < len(elements); i++ {
					newHeap.Insert(elements[i])
				}
				binomialHeap.MergeTwoBinomialHeaps(newHeap)
			}
		case 4:
			{
				var newKey int
				fmt.Print("Enter new key to replace : ")
				fmt.Scanf("%d", &newKey)

				log.Println("Need to provide pointer of the node to be decreased....")
				pointerToNode.DecreaseKey(newKey)
			}
		case 5:
			{
				log.Println("Need to provide pointer of the node to be removed....")
				pointerToNode.DecreaseKey(MinInt32)
				binomialHeap.ExtractMin()
			}
		case 6:
			{
				fmt.Print("\n Binomial Heap Elements : ")
				binomialHeap.PrintBinomialHeap()
				fmt.Println()
			}
		default:
			{

			}
		}
		if option > 6 {
			break
		}
	}
}
