package hw5_18001142;

public class ExpressionTree<E, T> extends LinkedBinaryTree<E, T> {
	public void preorderPrint(Node p) {
		if (p != null) {
			System.out.println(p.element);
			
			inorderPrint(p.right);

			inorderPrint(p.left);
		}
	}

	public void postorderPrint(Node p) {
		if (p != null) {
			inorderPrint(p.left);

			inorderPrint(p.right);
			
			System.out.println(p.element);
		}
	}

	public void inorderPrint(Node p) {
		if (p != null) {
			inorderPrint(p.right);

			System.out.println(p.element);

			inorderPrint(p.left);
		}
	}
}
