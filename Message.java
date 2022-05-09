import java.util.Scanner;
import java.util.ArrayList; 

public class Message {
    public String sender;
    public String text;

    public Message(String sender, String message){
        this.sender = sender;
        this.text = message;
    }

    public static void sendFriendMessage(User user, ArrayList<User>users){
        Scanner input = new Scanner(System.in);
        Scanner messageReceiver = new Scanner(System.in);
        messageReceiver.useDelimiter("\n");

        System.out.print("\n\nDestinatário (nickname): \n\n");
        String nameUser = input.next();

        System.out.print("\n\nMensagem: \n\n");
        String message = messageReceiver.next( );

        for(User i : user.profile.friends){
            if(i.nameUser.equals(nameUser)){  
                Message newMessage = new Message(user.name, message); 
                i.profile.messages.add(newMessage);
                System.out.print("\n\n Mensagem enviada! \n\n");
                return;
            } 
        }
        System.out.print("\n\n Usuário não existe no iFace ou na sua lista de amigos \n\n");
    }

    public static void sendCommunityMessage(User user, ArrayList<User>users, ArrayList<Community> allcommunities){

        String nameUser = user.nameUser;
        ArrayList<Community> communities = new ArrayList<Community>();
f
        for(Community i : allcommunities){
            for(User j : i.members){
                if(j.nameUser == nameUser){
                   communities.add(i);
                }
            }
        }

        if(communities.size() > 0){
            System.out.print("\nEscolha uma comunidade: \n");
            System.out.print("_________________________\n\n");
            int j = 1;

            for(Community i : communities){
                System.out.println("["+j+"] " + i.name);
                j++;
            }
            System.out.print("_________________________\n\n");
            System.out.print("Resposta [1-2]: ");

            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            int index = option - 1;

            Scanner messageReceiver = new Scanner(System.in);
            messageReceiver.useDelimiter("\n");
            System.out.print("\n\nMensagem: \n\n");
            String message = messageReceiver.next( );

            Message newMessage = new Message(user.name, message); 
            allcommunities.get(index).messages.add(newMessage);

            System.out.print("\n\n Mensagem enviada! \n\n");
            return;
        }
        else{
            System.out.print("\n\n Você não faz parte de nenhuma comunidade \n\n");
        }

    }
    
    public static void sendMessage(User user, ArrayList<User> users, ArrayList<Community>allcommunities){
        Scanner input = new Scanner(System.in);

        System.out.print("\n-- Enviar mensagem para: --\n");
        System.out.print("\n[1] Um amigo ");
        System.out.print("\n[2] Uma comunidade\n");                                                  
        System.out.print("_________________________\n\n");
        System.out.print("Resposta [1-2]: ");
        int option = input.nextInt();

        switch(option){
            case 1:
                sendFriendMessage(user, users);
                break;
            case 2:
                sendCommunityMessage(user, users, allcommunities);
                break;
        }                                                                      
        
    }
}