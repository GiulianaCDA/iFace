import java.util.Scanner;
import java.util.ArrayList; 

public class Feed {

    public boolean locked;
    public ArrayList<Message> messages = new ArrayList<Message>(); 

    public Feed(){
        this.locked = false;
    }

    public static void menu(){
        System.out.print("\n\n-- Escolha uma ação --\n");
        System.out.print("\n[1] Fazer post");
        System.out.print("\n[2] Visualizar feed de usuário");
        System.out.print("\n[3] Controle de visualização");
        System.out.print("\n_________________________\n\n");
        System.out.print("Resposta [1-3]: ");
    }

    public void post(User user){
        Scanner messageReceiver = new Scanner(System.in);
        messageReceiver.useDelimiter("\n");

        System.out.print("\n\nEscreva algo para postar: \n\n");
        String message = messageReceiver.next( );

        Message newMessage = new Message(user.name, message); 
        messages.add(newMessage);

        System.out.print("\nMensagem publicada!\n\n");
        return;
    }

    public void viewFeed(User user, ArrayList<User> allusers){

        System.out.print("\n\nVisualizar o feed do usuário (nickname): \n\n");
        Scanner input = new Scanner(System.in);
        String nickName = input.next();
        User userFind = User.exists(allusers, nickName);

        if(userFind != null){
            User friendFind = User.exists(user.profile.friends, userFind.nickName);
            ArrayList<Message> messages = userFind.profile.feed.messages;

            if(userFind.profile.feed.locked == true){
                if(friendFind != null){
                    System.out.print("\n---- Feed de " + userFind.name + "-----\n\n");
                    Message.showMessages(messages);
                }
                else{
                    System.out.print("\nEsse feed é restrito à amigos\n");
                }
            }
            else{
                System.out.print("\n---- Feed de " + userFind.name + "-----\n\n");
                Message.showMessages(messages);
            }
        }
        else{
            System.out.print("\nUsuário não encontrado\n");
        }
        // if(user.nickName.equals(nickName)){
        //     System.out.print("\n---- Feed de " + user.name + "-----\n\n");
        //     for(Message m : user.profile.feed.messages){;
        //         System.out.print("-" + m.text + "\n" + "-");
        //     }
        //     return;
        // }

        // for(User i : allusers){
        //     if(i.nickName.equals(nickName)){
        //         System.out.print("\n---- Feed de " + i.name + "-----\n\n");
        //         if(i.profile.feed.locked == false){
        //             for(Message m : i.profile.feed.messages){
        //                 System.out.print(m.text + "\n");
        //             }
        //         }
        //         else{
        //             boolean find = false;
        //             for(User u : user.profile.friends){
        //                 if(u.nickName.equals(nickName)){
        //                     find = true;
        //                     for(Message m : u.profile.feed.messages){
        //                         System.out.print(m.text + "\n");
        //                     }
        //                     return;
        //                 }
        //             }

        //             if(find == false){
        //                 System.out.print("\nEsse usuário possui o feed privado ou não existe.\n");
        //             }
        //         }
        //         return;
        //     }
        // }

    }

    public void setControl(){
        System.out.print("\n\n-- Quem pode ver seu feed? --\n");
        System.out.print("\n[1] Somente amigos");
        System.out.print("\n[2] Todos\n");
        System.out.print("_________________________\n\n");
        System.out.print("Resposta [1-2]: ");

        int option = Exceptions.optionValidator(1, 2);

        switch(option){
            case 1:
                this.locked = true;
                System.out.print("\nAlteração feita!\n");
                break;
            case 2:
                this.locked = false;
                System.out.print("\nAlteração feita!\n");
                break;
        }
    }
}
