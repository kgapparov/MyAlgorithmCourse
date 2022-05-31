package lessons_from_class.problem5;


import java.util.List;

public class BSTSort extends MyBST{
    public List<Integer> getList(){
        return super.getSortedArray();
    }
    public static void main(String[] args) {
        BSTSort bst = new BSTSort();
        for (int i = 15; i >= 0; --i) {
            bst.insert(new Integer(2 * i));
            bst.insert(new Integer(2 * i - 5));
        }
        List<Integer> list = bst.getSortedArray();
        System.out.println(list);
    }
}
