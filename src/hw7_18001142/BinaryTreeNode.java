package hw7_18001142;

public class BinaryTreeNode<E extends Comparable<E>> {
	private E element;
	private BinaryTreeNode<E> parent;
	private BinaryTreeNode<E> left;
	private BinaryTreeNode<E> right;

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public BinaryTreeNode<E> getParent() {
		return parent;
	}

	public void setParent(BinaryTreeNode<E> parent) {
		this.parent = parent;
	}

	public BinaryTreeNode<E> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<E> left) {
		this.left = left;
	}

	public BinaryTreeNode<E> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<E> right) {
		this.right = right;
	}

	public BinaryTreeNode(E element) {
		this.element = element;
		this.parent = null;
		this.left = null;
		this.right = null;
	}

	private BinaryTreeNode(E element, BinaryTreeNode<E> parent) {
		this.element = element;
		this.parent = parent;
	}
	
	public E findMin(BinaryTreeNode<E> treeNode) {
		if(treeNode == null) {
			return null;
		}
		while(treeNode.left != null) {
			treeNode = treeNode.left;
		}
		
		return treeNode.element;
	}
	
	public BinaryTreeNode<E> search(E item, BinaryTreeNode<E> treeNode){
		while(treeNode != null) {
			if(item.compareTo(treeNode.element) == 0) {
				return treeNode;
			}
			else if(item.compareTo(treeNode.element) < 0) {
				treeNode = treeNode.left;
			}
			else {
				treeNode = treeNode.right;
			}
		}
		return null;
	}
	
	public BinaryTreeNode<E> insert(E item, BinaryTreeNode<E> treeNode) {
		if(treeNode == null) {
			return new BinaryTreeNode<E>(item);
		}
		else if(item.compareTo(treeNode.element) < 0) {
			treeNode.left = insert(item, treeNode.left);
		}
		else if(item.compareTo(treeNode.element) > 0) {
			treeNode.left = insert(item, treeNode.right);
		}
		
		return treeNode;
	}
	
	public BinaryTreeNode<E> delete(E item, BinaryTreeNode<E> treeNode) {
		if(treeNode.left == null && treeNode.right == null) {
			if(item.compareTo(treeNode.element) == 0) {
				treeNode.element = null;
				return treeNode;
			}
			else {
				return null;
			}
		}
		else if(treeNode.left != null && treeNode.right == null) {
			if(item.compareTo(treeNode.element) == 0) {
				return treeNode.left;
			}
			else {
				treeNode.left = delete(item, treeNode.left);
			}
		}
		else if(treeNode.left == null && treeNode.right != null) {
			if(item.compareTo(treeNode.element) == 0) {
				return treeNode.right;
			}
			else {
				treeNode.right = delete(item, treeNode.right);
			}
		}
		else {
			if(item.compareTo(treeNode.element) == 0) {
				treeNode.element = findMin(treeNode);
				treeNode.right = delete(item, treeNode);
			}
			else if(item.compareTo(treeNode.element) > 0) {
				treeNode.left = delete(item, treeNode.left);
			}
			else {
				treeNode.right = delete(item, treeNode.right);
			}
		}
		return treeNode;
	}
}
