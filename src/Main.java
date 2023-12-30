//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
      LinkedList<Integer> list=new LinkedList<>();
      list.addNode(6);
      list.addNode(3);
      list.addNode(9);
      System.out.println("Original Linked List");
      list.display();
      list.revList();
      System.out.println("Reversed Linked List");
      list.display();
    }
}