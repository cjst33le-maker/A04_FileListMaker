import java.util.Scanner;
import java.util.ArrayList;

public class ListMaker {

    private static ArrayList<String> myArrList = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    static void main() {


        boolean done = false;

        do {
            System.out.println("\nListMaker Menu");
            print();
            System.out.println();
            System.out.println("A - Add an item");
            System.out.println("D - Delete an item");
            System.out.println("I - Insert an item");
            System.out.println("P - Print the list");
            System.out.println("Q - Quit");
            String choice = SafeInput.getRegExString(in, "Enter your choice", "[AaDdIiPpQq]");

            switch (choice.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    delete();
                    break;
                case "I":
                    insert();
                    break;
                case "P":
                    print();
                    break;
                case "Q":
                    done = quit();
                    break;
            }
        }
        while (!done);
    }
private static boolean quit()
{
    return SafeInput.getYNConfirm(in, "Are you sure you want to quit? y/n");
}
private static void addItem() {
        System.out.println("What would you like to add? ");
        String userInput = in.nextLine();
        myArrList.add(userInput);
}
private static void  print(){
        for (int i = 0; i < myArrList.size(); i++){
            System.out.println((i + 1) + " : " + myArrList.get(i));
        }
}
private static void delete(){
        if (myArrList.isEmpty()){
            System.out.println("The list is empty!");
            return;
        }
        int userInput = SafeInput.getRangedInt(in, "Pick which one to delete.", 1, myArrList.size());
        myArrList.remove(userInput - 1);
}
private static void insert(){
        System.out.println("What would you like to add? ");
        String userString = in.nextLine();
        int userInt = SafeInput.getRangedInt(in,"Pick where to insert", 1, myArrList.size() + 1);
        myArrList.add(userInt - 1, userString);

}
}
