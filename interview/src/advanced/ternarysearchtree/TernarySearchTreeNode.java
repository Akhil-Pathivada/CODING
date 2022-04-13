/**
 * Date 05/04/2022
 *
 * @author akhilpathivada
 */
package advanced.ternarysearchtree;


public class TernarySearchTreeNode {
        
        char data;
        TernarySearchTreeNode left, equal, right;
        boolean isEndOfString;
        
        public TernarySearchTreeNode() {
        }
        
        public TernarySearchTreeNode(char data) {
                this.data = data;
                this.left = this.equal = this.right = null;
                isEndOfString = false;
        }
}
