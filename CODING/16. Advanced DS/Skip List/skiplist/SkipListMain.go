package skiplist

import "fmt"

const (
	MinInt32 = -1 << 31
)

/* Note : Level for a Node always ranges from 0 to MAX_LEVEL - 1 */

func SkipListMain() {
	var targetNode int
	var skiplist *SkipList = NewSkipList()
	skiplist.Head = NewSkipListNode(MinInt32, MAX_LEVEL)
	elements := []int{5, 7, 10, 15, 20, 22, 34, 72, 90, 95, 102, 110, 127, 134, 139}
	//levels := []int{1, 2, 1, 3, 1, 2, 1, 4, 1, 2, 1, 3, 1, 2, 1}

	for true {
		var option int
		fmt.Print("\n 1. Insert \n 2. Search \n 3. Delete \n 4. Print SkipList \n Select an option : ")
		fmt.Scanf("%d", &option)

		switch option {
		case 1:
			{
				for i := 0; i < len(elements); i++ {
					skiplist.Insert(elements[i])
				}
			}
		case 2:
			{
				fmt.Print("Enter node to Search : ")
				fmt.Scanf("%d", &targetNode)
				isFound := skiplist.Search(targetNode)
				if isFound {
					fmt.Printf("** Node %v was found **", targetNode)
				} else {
					fmt.Printf("** Node %v was not found **", targetNode)
				}
			}
		case 3:
			{
				fmt.Print("Enter node to Delete : ")
				fmt.Scanf("%d ", &targetNode)
				isDeleted := skiplist.Delete(targetNode)
				if isDeleted {
					fmt.Printf("** Node %v was deleted successfully **", targetNode)
				} else {
					fmt.Printf("** Node %v not exists in SkipList **", targetNode)
				}
			}
		case 4:
			{
				skiplist.PrintList()
			}
		default:
			{

			}
		}
		if option > 5 {
			break
		}
	}
}
