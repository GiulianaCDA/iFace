import java.util.Scanner;
import java.util.ArrayList; 

public class Feed {

    public boolean locked;
    public ArrayList<Message> messages = new ArrayList<Message>(); 

    public Feed(){
        this.locked = false;
    }

    public static int menu(){
        System.out.print("\n\n-- Escolha uma ação --\n");
        System.out.print("\n[1] Fazer post\n");
        System.out.print("\n[2] Visualizar feed de usuário\n");
        System.out.print("\n[3] Controle de visualização\n");
        System.out.print("_________________________\n\n");
        System.out.print("Resposta [1-3]: ");

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        return option;
    }

    public void post(User user){
        Scanner messageReceiver = new Scanner(System.in);
        messageReceiver.useDelimiter("\n");

        System.out.print("\n\nEscreva algo para postar: \n\n");
        String message = messageReceiver.next( );

        Message newMessage = new Message(user.name, message); 
        messages.add(newMessage);

        System.out.print("\nMensagem publicada!\n");
        return;
    }

    public void viewFeed(ArrayList<User> users){

        System.out.print("\n\nVisualizar o feed do usuário (nickname): \n\n");
        Scanner input = new Scanner(System.in);
        String nameUser = input.next();

        for(User i : users){
            if(i.nameUser.equals(nameUser)){
                System.out.print("\n---- Feed de " + i.name + "-----\n");
                if(i.profile.feed.locked == false){
                    for(Message m : i.profile.feed.messages){
                        System.out.print(m.text + "\n");
                    }
                }
                else{
                    if(i.profile.friends.contains(nameUser)){ 
                        for(Message m : i.profile.feed.messages){
                            System.out.print(m.text + "\n");
                        }   
                    }
                    else{
                        System.out.print("\nEsse feed é privado.\n");
                    }
                }
                return;
            }
        }
        System.out.print("\nUsuário não encontrado. \n");

    }

    public void setControl(){
        System.out.print("\n\n-- Quem pode ver seu feed? --\n");
        System.out.print("\n[1] Somendo amigos\n");
        System.out.print("\n[2] Todos\n");
        System.out.print("_________________________\n\n");
        System.out.print("Resposta [1-2]: ");

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        switch(option){
            case 1:
                this.locked = true;
                break;
            case 2:
                this.locked = false;
                break;
        }
    }
}
