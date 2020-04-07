leftview(head){
	printf("%d", head->data);
	leftview(head->left);
}

rightview(head){
	printf("%d", head->data);
	rightview(head->right);
}

void topview(head){

	leftview(head->left);
	rightview(head->right);
}