import java.util.Scanner;
import java.util.ArrayList; 

public class Community {
    public String manager;
    public String name;
    public String description;
    public  ArrayList<User> members = new ArrayList<User>();

    public Community(String name, String manager, String description) {
        this.name = name;
        this.manager = manager;
        this.description = description;
    }

    public static int menu(){
        System.out.print("\n-- O que você deseja fazer? --\n");
        System.out.print("\n[1] Criar comunidade \n");
        System.out.print("\n[2] Entrar em comunidade \n");
        System.out.print("_________________________\n\n");
        System.out.print("Resposta [1-2]: ");

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        return option;

    }

    public static Community createCommunity(User user) {
        Scanner input = new Scanner(System.in);
        Scanner text = new Scanner(System.in);
        text.useDelimiter("\n");

        System.out.print("\nNome da comunidade: ");
        String name = text.next();

        System.out.print("\nDescrição da comunidade: ");
        String description = text.next( );

        Community newCommunity = new Community(name, user.nameUser, description);

        System.out.print("\nSua comunidade foi criada!\n ");

        return newCommunity;
    }

    public static ArrayList<Community> enterCommunity(User user, ArrayList<Community> allCommunities) {

        if(allCommunities.size() != 0){

            System.out.print("\nEscolha uma comunidade para entrar: \n");
            System.out.print("_________________________\n\n");

            int j=1;
            for(Community i : allCommunities){
                System.out.println("["+j+"] " + i.name);
                j++;
            }
            System.out.print("_________________________\n\n");
            System.out.print("Resposta [1-2]: ");

            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            int index = option - 1;

            allCommunities.get(index).members.add(user);

            System.out.print("\nVocê entrou na comunidade " + allCommunities.get(index).name + "!\n\n");

        }
        else{
            System.out.print("\nNão há comunidades ainda.");
        }

        return allCommunities;

    }

}