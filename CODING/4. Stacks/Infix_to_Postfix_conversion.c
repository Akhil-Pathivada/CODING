/*
Program to convert a Infix Expression into Postfix Expression.....

Time Complexity : O(N)
Space Complexity : O(N)
*/
#include<stdio.h>
#include<ctype.h>

char stack[100], expr[100], postfix[100], *s = expr, x;
int top = -1;

void push(char x) {

		stack[++top] = x;
}

char pop() {

		if(top == -1) {
			return -1;
		}
		else {
			return stack[top--];
		}
}

int Priority(char x) {

	    if(x == '(') {
	        return 0;
	    }
	    if(x == '+' || x == '-') {
	        return 1;
	    }
	    if(x == '*' || x == '/') {
	        return 2;
	    }
	    return -1;
}

int main() {

		int index = 0;

		printf("\nEnter the expression : ");
		scanf("%s", expr);

		while(*s != '\0') {

				if(isalnum(*s)) {
					postfix[index++] = *s;
				}
				else if(*s == '(') {
					push(*s);
				}
				else if(*s == ')') {

					while((x = pop()) != '(') {
						postfix[index++] = x;
					}
				}
				else {

					while(Priority(stack[top]) >= Priority(*s)) {
						postfix[index++] = pop();
		             	
					}
					push(*s);
				}
				++s;
		}

		while(top != -1) {
	   	     postfix[index++] = pop(); 
	   	}
	    printf("\n POSTFIX :: %s ", postfix);

}
