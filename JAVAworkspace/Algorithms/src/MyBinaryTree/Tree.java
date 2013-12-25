/**
 * 
 */
package MyBinaryTree;

import java.util.Stack;

/**
 * @author Dong
 *
 */
public class Tree {
	private Node root;
	
	public Tree(){
		root = null;
	}
	
	public Node find(int key){
		Node current = root;
		while(current.key != key){
			if(key < current.key){
				current = current.leftChild;
			}else{
				current = current.rightChild;
			}
			if(current == null){
				return null;
			}
		}
		return current;
	}
	
	public void insert(int inKey, double inData){
		Node nNode = new Node();
		nNode.key = inKey;
		nNode.data = inData;
		
		if(root == null){
			root = nNode;
		}else{
			Node current = root;
			Node parent;
			
			while(true){
				parent = current;
				if(inKey < current.key){
					current = current.leftChild;
					if(current == null){
						parent.leftChild = nNode;
						return;
					}
				}else{
					current = current.rightChild;
					if(current == null){
						parent.rightChild = nNode;
						return;
					}
				}
			}
		}
	}
	
	public boolean delete(int deKey){

		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while(current.key != deKey){
			parent = current;
			if(deKey < current.key){
				isLeftChild = true;
				current = current.leftChild;
			}else{
				isLeftChild = false;
				current = current.rightChild;
			}
			if(current == null) return false;
		}
		
		if(current.leftChild == null && current.rightChild == null){
			if(current == root) root = null;
			else if(isLeftChild){
				parent.leftChild = null;
			}else{
				parent.rightChild = null;
			}
		}
		
		//if no right child, just replace it with the left subtree
		else if(current.rightChild == null){
			if(current == root){
				root = current.leftChild;
			}else if(isLeftChild){
				parent.leftChild = current.leftChild;
			}else{
				parent.rightChild = current.rightChild;
			}
		}
		
		else if(current.leftChild == null){
			if(current == root){
				root = root.rightChild;//I suppose this is absolutely right, we'll see
			}else if(isLeftChild){
				parent.leftChild = current.rightChild;
			}else{
				parent.rightChild = current.rightChild;
			}
		}
		
		else{
			Node successor = getSuccessor(current);
			
			if(current == root){
				root = successor;
			}else if(isLeftChild){
				parent.leftChild = successor;
			}else{
				parent.rightChild = successor;
			}
			successor.leftChild = current.leftChild;
		}
		return true;//Fix this
	}
	
	private Node getSuccessor(Node n){
		Node sParent = n;
		Node s = n;
		Node current = n.rightChild;
		
		while(current != null){
			sParent = s; 
			s = current; 
			current = current.leftChild;
		}
		
		if(s != n.rightChild){
			sParent.leftChild = s.rightChild;
			s.rightChild = n.rightChild;
		}
		
		return s;
	}
	
	public void traverse(int tp){
		switch(tp){
		case 1:
			System.out.print("/nPreorder traversal: ");
			preOrder(root);
			break;
		case 2:
			System.out.print("/nInorder traversal: ");
			inOrder(root);
			break;
		case 3: 
			System.out.print("/nPostorder traversal: ");
			postOrder(root);
			break;
		}
		System.out.println();
	}
	
	private void preOrder(Node localRoot){
		if(localRoot != null){
			System.out.print(localRoot.key + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	
	private void inOrder(Node localRoot){
		if(localRoot != null){
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.key + " ");
			inOrder(localRoot.rightChild);
		}
	}
	
	private void postOrder(Node localRoot){
		if(localRoot != null){
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.key + " ");
		}
	}
	
	public void displayTree(){
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlank = 32;
		boolean isRowEmpty = false;
		System.out.println("..................................................................");
		while(!isRowEmpty){
			Stack localStack = new Stack();
			isRowEmpty = true;
			
			for(int i = 0; i < nBlank; i++){
				System.out.print(" ");//Should be the same
			}
			
			while(!globalStack.isEmpty()){
				Node temp = (Node)globalStack.pop();
				if(temp != null){
					System.out.print(temp.key);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					
					if(temp.leftChild != null || temp.rightChild != null){
						isRowEmpty = false;
					}else{
						System.out.print("--");
						localStack.push(null);
						localStack.push(null);
					}
					
					for(int i = 0; i <nBlank*2-2; i++){
						System.out.print(" ");
					}
				}
			}
			System.out.println();
			nBlank /= 2;
			while(!localStack.isEmpty()){
				globalStack.push(localStack.pop());
			}
			System.out.println();
		}
	}

}
