import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException; 


public class Profile implements Friends{

    private String hobbie;
    private String status; 
    private int age;

    public Feed feed = new Feed();
    public ArrayList<User> friends = new ArrayList<User>();
    private ArrayList<User> request = new ArrayList<User>();
    public ArrayList<Message> messages = new ArrayList<Message>();
    public ArrayList<Community> communities = new ArrayList<Community>();

    public Profile(){
        
    }

    public Profile(String hobbie, String status, int age) {
        this.hobbie = hobbie;
        this.status = status;
        this.age = age;
    }

    public static void menuEdit(){

        System.out.print("\n-- O que você deseja editar? --\n");

        System.out.print("\n[1] Nome ");
        System.out.print("\n[2] Nome de usuário ");
        System.out.print("\n[3] Hobbie ");
        System.out.print("\n[4] Estado civil");
        System.out.print("\n[5] Idade ");
        System.out.print("\n[6] Senha \n");
        System.out.print("_________________________\n\n");
        System.out.print("Resposta [1-6]: ");
    }

    public static User editProfile(User user){

        menuEdit();
        int option = Exceptions.optionValidator(1, 6);
        Scanner input = new Scanner(System.in);

        Scanner messageReceiver = new Scanner(System.in);
        messageReceiver.useDelimiter("\n");

        switch(option) {
            case 1:
                System.out.print("\nNovo nome: ");
                String name = messageReceiver.next( );
                user.setName(name);
                System.out.print("\nEdição feita com sucesso! \n");
                break;

            case 2:
                System.out.print("\nNovo nome de usuário: ");
                String nickName = input.next();
                user.setnickName(nickName);
                System.out.print("\nEdição feita com sucesso! \n");
                break;

            case 3:
                System.out.print("\nHobbie: ");
                String hobbie = messageReceiver.next( );
                user.profile.setHobbie(hobbie);
                System.out.print("\nEdição feita com sucesso! \n");
                break;

            case 4:
                System.out.print("\nNovo estado civil: ");
                String status = messageReceiver.next( );
                user.profile.setStatus(status);
                System.out.print("\nEdição feita com sucesso! \n");
                break;

            case 5:
                int age = 0;
                
                while(age == 0){
                    try {
                        System.out.print("\nNova idade: ");
                        age = input.nextInt();
                        if(age < 6 || age > 120){ 
                             System.out.println("\nÉ necessário ter entre 6 a 120 anos.\n");
                             age = 0;
                        }
                        
                    } catch (InputMismatchException e) {
                        System.out.println("\nOps... você digitou caracteres. Precisamos que digite apenas números.\n");
                    }
                    input.nextLine();
                }

                
                System.out.print("\nEdição feita com sucesso! \n");

                break;
            
            case 6:
                System.out.print("\nNova senha: ");
                String password = input.next();
                user.setPassword(password);
                System.out.print("\nEdição feita com sucesso! \n");
                break;
        }

        return user;
    }

    public void printProfile(){

        if(this.hobbie != null){
            System.out.println("Hobbie: " + this.hobbie);
        }
        else {
            System.out.println("Hobbie: não cadastrado");
        }

        if(this.status != null){
            System.out.println("Status: " + this.status);
        }
        else {
            System.out.println("Estado civil: não cadastrado");
        }

        if(this.age != 0){
            System.out.println("Idade: " + this.age);
        }
        else{
            System.out.println("Idade: não cadastrado");
        }

        if(friends.size() != 0){
            System.out.println("Amigos: ");
            for(User i : friends) {   
                System.out.println(i.name + " ");
            } 
        }
        else{
            System.out.println("Amigos: Não possui amigos ainda.");
        }

        if(messages.size() != 0){
            for(Message i : messages) {   
                System.out.println("\nMensagem de " + i.sender +":\n" + i.text + "\n");
            }   
        }
    }

    @Override
    public ArrayList<User> manageRequestFriend(ArrayList<User> users, User currentUser){   
        Friends.menuFriend();
        int option = Exceptions.optionValidator(1, 2);
        Scanner input = new Scanner(System.in);

        switch(option){
            case 1:
                System.out.print("\n\nEnviar solicitação para (nickname): \n\n");
                String nickName = input.next();
                
                User userFind = User.exists(users, nickName);

                if(nickName.equals(currentUser.nickName)){
                    System.out.print("\nOps...esse usuário é você!\n");
                    return users;
                }

                if(userFind != null){
                    userFind.profile.request.add(currentUser);
                    System.out.print("\nSolicitação enviada!\n");
                }
                else{
                    System.out.print("\nOps...usuário não encontrado!\n");
                }

                break;

            case 2:
                if(currentUser.profile.request.size() == 0) System.out.print("\nNão há nenhuma solicitação\n\n");
                for(User i : request){

                    System.out.print("\n" + i.name + " quer ser seu amigo\n");
                    System.out.print("\n[1] Aceitar");
                    System.out.print("\n[2] Recusar \n");
                    System.out.print("_________________________\n\n");
                    System.out.print("Resposta [1-2]: ");

                    option = Exceptions.optionValidator(1, 2);
                    if(option == 1){
                        friends.add(i);
                        i.profile.friends.add(currentUser);
                        
                        System.out.print("\nSolicitação aceita! \n");
                    } 
                    else{
                        System.out.print("\nSolicitação recusada! \n");
                    }
                }

                request.clear();
                
        }

        return users;

    }

    public void setHobbie(String newHobbie) {
        this.hobbie = newHobbie;
    }

    public void setStatus(String newStatus) {
        this.status = newStatus;
    }

    public void setAge(int newAge){
        this.age = newAge;
    }
}
