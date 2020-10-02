** Bài tập đã thực hiện: Bài 1 + Bài 2 + Bài 3
- Mã nguồn bao gồm 4 file:
  + BinaryTreeInterface.java
  + ArrayBinaryTree.java     : Implements BinaryTreeInterface using array: 1.1
  + LinkedBinaryTree.java    : Implements BinaryTreeInterface using linked: 1.2
  + BinaryTreeNode.java      : Design BinaryTree using Linked (Better than LinkedBinaryTree)
  + ExpressionTree.java      : Extends LinkedBinaryTree: 2.1
  + Expression.java			 : Class represion for a expression: 2.2 + 2.3 + 3
- Test được đặt ngay trong main của các class, 3 class implements có method printTree() để in cây nằm ngang(1.3)
- Algorithm:
  + 2.2:  -- Method public static String getExpression(BinaryTreeNode<String> tree) return 1 string expression
		  -- Sử dụng travel left - root - right và check node để thêm ngoặc phù hợp
  + 2.3:  -- Method public static double caculate(BinaryTreeNode<String> tree) return giá trị của expression
          -- Trvale Left - root - right và đệ quy tính (left (@) right : (@) là root đại diện cho toán tử)
  + 3:    -- Dựng cây qua 2 bước: Chuyển từ inner sang post fix và dựng cây.
          -- Method public static ArrayList<String> innerToPost(String[] tokens) return 1 ArrayList<String> chứa tokens dạng postfix
		  -- public static BinaryTreeNode<String> buildTree(String[] tokens) return 1 BinaryTreeNode là 1 cây đại diện cho 1 expression
  + Ngoài ra còn các method check valid Expression.. có thể tham khảo thêm nếu cần thiết
  + Bài làm có sử dụng regex 