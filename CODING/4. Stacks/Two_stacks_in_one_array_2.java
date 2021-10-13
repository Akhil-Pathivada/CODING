
   
/* Create a data structure twoStacks that represents two stacks. Implementation of twoStacks should use only one array, i.e., both stacks should use the same array for storing elements. Following functions must be supported by twoStacks.
 * push1(int x) –> pushes x to first stack
 * push2(int x) –> pushes x to second stack
 *
 * pop1() –> pops an element from first stack and return the popped element
 * pop2() –> pops an element from second stack and return the popped element
 *
 * Implementation of twoStack should be space efficient.
 *
 * Time Complexity:
 * Push operation : O(1)
 * Pop operation : O(1)
 * Auxiliary Space: O(N).
 * Use of array to implement stack so. It is the space-optimised method as explained above.
 *
 *  */

class TwoStacks {

        int size; // size of array
        int top1, top2; // top elements of two stacks
        int arr[];

        TwoStacks(int n) {

                arr = new int[n];
                size = n;
                top1 = -1;
                top2 = n;
        } 

        private void push1(int x) {

                if(top1 < top2 - 1) {

                        arr[++top1] = x;
                }
                else {
                        System.out.println("Stack Overflow");
                        System.exit(1);
                }
        }

        private void push2(int x) {

                if(top1 < top2 - 1) {

                        arr[--top2] = x;
                }
                else {
                        System.out.println("Stack Overflow");
                        System.exit(1);
                }
        }

        private int pop1() {

                if(top1 >= 0) {

                        int x = arr[top1--];
                        return x;
                }
                else {
                        System.out.println("Stack Underflow");
                        System.exit(1);
                }
                return 0;
        }

        private int pop2() {

                if(top2 < size) {

                        int x = arr[top2++];
                        return x;
                }
                else {
                        System.out.println("Stack Underflow");
                        System.exit(1);
                }
                return 0;
        }


        public static void main(String[] args) {

                TwoStacks ts = new TwoStacks(5);
                ts.push1(5);
                ts.push2(10);
                ts.push2(15);
                ts.push1(11);
                ts.push2(7);

                System.out.println("Popped element from stack1 is " + ts.pop1());  
                
                ts.push2(40);
                System.out.println("Popped element from stack2 is " + ts.pop2());
        }
}