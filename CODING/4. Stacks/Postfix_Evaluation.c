/*
Program for evaluation of a Postfix expression.....

Time Complexity : O(N)
Space Complexity : O(N)

*/

#include<stdio.h>
#include<ctype.h>

int stack[20], top = -1;

char expr[100], *e = expr;

void push(int x) {

        stack[++top] = x;
}

int pop() {

        return stack[top--];
}

int main() {

        int n1, n2, res;
        
        printf("Enter the exprression :: ");
        scanf("%s", expr);
        
        while(*e != '\0') {

                if(isdigit(*e)) {
                        push(*e - 48);
                }
                else{
                        n2 = pop();
                        n1 = pop();

                        switch(*e) {

                                case '+': {

                                        res = n2 + n1;
                 		        break;
                                }
                                case '-': {

                                        res = n1 - n2;
                                        break;
                                }
                                case '*': {

                                        res = n2 * n1;
                                        break;
                                }
                                case '/': {

                                        res = n1 / n2;
                                        break;
                                }
                        }
                        push(res);
                }
                ++e;
        }
        printf("The result of expression = %d ", pop());
}
