import java.util.Scanner;
import java.util.ArrayList; 

public class Message {
    public String sender;
    public String text;

    public Message(String sender, String message){
        this.sender = sender;
        this.text = message;
    }

    public static void sendMessage(User user, ArrayList<User> users){
        Scanner input = new Scanner(System.in);
        Scanner messageReceiver = new Scanner(System.in);
        messageReceiver.useDelimiter("\n");

        System.out.print("\n\nDestinatário (nickname): \n\n");
        String nameUser = input.next();

        System.out.print("\n\nMensagem: \n\n");
        String message = messageReceiver.next( );

        
        for(User i : users){
            if(i.nameUser.equals(nameUser)){  
                Message newMessage = new Message(user.name, message); 
                i.profile.messages.add(newMessage);
                System.out.print("\n\n Mensagem enviada! \n\n");
                return;
            } 
        }
        System.out.print("\n\n Usuário não encontrado! \n\n");
    }
}