import java.util.Scanner;
import java.util.ArrayList; 


public class Profile {

    private String hobbie;
    private String status; 
    private int age;

    public Feed feed = new Feed();
    public ArrayList<User> friends = new ArrayList<User>();
    public ArrayList<User> request = new ArrayList<User>();
    public ArrayList<Message> messages = new ArrayList<Message>();
    public ArrayList<Community> communities = new ArrayList<Community>();

    public Profile(){
        
    }

    public Profile(String hobbie, String status, int age) {
        this.hobbie = hobbie;
        this.status = status;
        this.age = age;
    }

    public static int menuEdit(){

        System.out.print("\n-- O que você deseja editar? --\n");

        System.out.print("\n[1] Nome \n");
        System.out.print("\n[2] Nome de usuário \n");
        System.out.print("\n[3] Hobbie \n");
        System.out.print("\n[4] Estado civil \n");
        System.out.print("\n[5] Idade \n");
        System.out.print("\n[6] Senha \n");
        System.out.print("_________________________\n\n");
        System.out.print("Resposta [1-6]: ");

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        return option;
    }

    public static int menuFriend(){

        System.out.print("\n-- O que você deseja fazer? --\n");

        System.out.print("\n[1] Enviar solicitação \n");
        System.out.print("\n[2] Verificar solitações \n");
        System.out.print("_________________________\n\n");
        System.out.print("Resposta [1-2]: ");

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        return option;
    }

    public static User editProfile(User user){

        int option = menuEdit();
        Scanner input = new Scanner(System.in);

        switch(option) {
            case 1:
                System.out.print("\nNovo nome: ");
                String name = input.next();
                user.setName(name);
                System.out.print("\nEdição feita com sucesso! \n");
                break;

            case 2:
                System.out.print("\nNovo nome de usuário: ");
                String nameUser = input.next();
                user.setNameUser(nameUser);
                System.out.print("\nEdição feita com sucesso! \n");
                break;

            case 3:
                System.out.print("\nHobbie: ");
                String hobbie = input.next();
                user.profile.setHobbie(hobbie);
                System.out.print("\nEdição feita com sucesso! \n");
                break;

            case 4:
                System.out.print("\nNovo estado civil: ");
                String status = input.next();
                user.profile.setStatus(status);
                System.out.print("\nEdição feita com sucesso! \n");
                break;

            case 5:
                System.out.print("\nNova idade: ");
                int age = input.nextInt();
                user.profile.setAge(age);
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
            System.out.println("Hobbie: cadastrado");
        }

        if(this.status != null){
            System.out.println("Status: " + this.status);
        }
        else {
            System.out.println("Status: não cadastrado");
        }

        if(this.age != 0){
            System.out.println("Idade: " + this.age);
        }
        else{
            System.out.println("Idade: não cadastrado");
        }

        if(friends.size() != 0){
            System.out.println("Amigos: ");
            for(User i : request) {   
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

    public ArrayList<User> Friend(ArrayList<User> users, User currentUser){   

        int option = menuFriend(); 
        Scanner input = new Scanner(System.in);

        switch(option){
            case 1:
                System.out.print("\n\nEnviar solicitação para (nickname): \n\n");
                String nameUser = input.next();
                
                for(User i : users) {   
        
                    if(i.nameUser.equals(nameUser)){ 
                        i.profile.request.add(currentUser);
                    } 
                }  
                System.out.print("\nSolicitação enviada!\n");

            case 2:
                for(User i : request){

                    System.out.print("\n" + i.name + " quer ser seu amigo\n");
                    System.out.print("\n[1] Aceitar \n");
                    System.out.print("\n[2] Recusar \n");
                    System.out.print("_________________________\n\n");
                    System.out.print("Resposta [1-2]: ");

                    option = input.nextInt();
                    if(option == 1){
                        friends.add(i);
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
