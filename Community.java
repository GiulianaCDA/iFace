import java.util.Scanner;
import java.util.ArrayList; 

public class Community {
    public String manager;
    public String name;
    public String description;
    public  ArrayList<String> members = new ArrayList<String>();

    public Community(String name, String manager, String description) {
        this.name = name;
        this.manager = manager;
        this.description = description;
    }

    public static Community createCommunity(User user) {
        Scanner input = new Scanner(System.in);
        Scanner text = new Scanner(System.in);
        text.useDelimiter("\n");

        System.out.print("\nNome da comunidade: ");
        String name = input.next();

        System.out.print("\nNome da comunidade: ");
        String description = text.next( );

        Community newCommunity = new Community(name, user.nameUser, description);

        return newCommunity;
    }

}