import java.util.Scanner;
import java.util.ArrayList; 

public interface Friends {

    public static int menuFriend(){
        System.out.print("\n-- O que você deseja fazer? --\n");

        System.out.print("\n[1] Enviar solicitação");
        System.out.print("\n[2] Verificar solitações \n");
        System.out.print("_________________________\n\n");
        System.out.print("Resposta [1-2]: ");

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        return option;
    }

    public ArrayList<User> manageRequestFriend(ArrayList<User> users, User currentUser);

    public static void removeFriendsList(User user, ArrayList<User> allusers){
        for(User u : allusers){
            u.profile.friends.remove(user);
        }
    }
}
