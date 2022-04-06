import java.util.Scanner;
import java.util.ArrayList; 


public class Main {

    public static void menu(boolean exists){

        if(!exists){
            System.out.print("\n----- BEM VINDO AO IFACE! -----\n");
        }

        System.out.print("\n\n-- Escolha uma ação --\n");
        System.out.print("\n[1] Cadastrar usuário\n");
        System.out.print("\n[2] Editar perfil\n");
        System.out.print("\n[3] Adicionar/aceitar amigo\n");
        System.out.print("\n[4] Enviar mensagem\n");
        System.out.print("\n[5] Recuperar informações\n");
        System.out.print("\n[6] Comunidades\n");
        System.out.print("\n[7] Feed de notícias\n");
        System.out.print("\n[8] Login\n");
        System.out.print("\n[9] Logout\n");
        System.out.print("_________________________\n\n");
        System.out.print("Resposta [1-7]: ");
    }

    public static void time(){

        try{
            Thread.sleep(1000);
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }

   
    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<User>();
        ArrayList<Community> allCommunities = new ArrayList<Community>();

        boolean run = true;
        boolean exists = false;
        User currentUser = null;


        while(run){

            menu(exists);

            Scanner input = new Scanner(System.in);
            int option = input.nextInt();

                
            if(option == 1) {

                exists = true;
                User newUser = User.createUser();
                users.add(newUser);
                currentUser = newUser;

                time();
            }

            else if(option == 2) {
                if(currentUser != null){
                    currentUser = Profile.editProfile(currentUser);
                }
                else{
                    System.out.print("\n\n Faça login. \n\n");
                }

                time();
            }

            else if(option == 3) {  
                if(currentUser != null){
                    users = currentUser.profile.Friend(users, currentUser);
                }
                else{
                    System.out.print("\n\n Faça login. \n\n");
                }

                time();
            }

            else if(option == 4){
                if(currentUser != null){
                    Message.sendMessage(currentUser, users, allCommunities);
                }
                else{
                    System.out.print("\n\n Faça login. \n\n");
                }

                time();
            }

            else if(option == 5) {
                if(currentUser != null){
                    currentUser.printUser();
                    currentUser.profile.printProfile();
                    Community.printMessages(currentUser, allCommunities);
                }
                else{
                    System.out.print("\n\n Faça login. \n\n");
                }

                time();
            }

            else if(option == 6) {
                if(currentUser != null){
                    int choice = Community.menu();

                    switch(choice){
                        case 1:
                            allCommunities = Community.createCommunity(currentUser, allCommunities);
                            break;
                        case 2:
                            allCommunities = Community.enterCommunity(currentUser, allCommunities);
                            break;
                    }
                }
                else{
                    System.out.print("\n\n Faça login. \n\n");
                }

                time();
            }
            else if(option == 7){
                if(currentUser != null){
                    int feedChoice = Feed.menu();

                    switch(feedChoice){
                        case 1:
                            currentUser.profile.feed.post(currentUser);
                            break;
                        case 2:
                            currentUser.profile.feed.viewFeed(users);
                            break;
                        case 3:
                            currentUser.profile.feed.setControl();
                    }

                    time();
                }
                else{
                    System.out.print("\n\n Faça login. \n\n");

                }
                
                time();
            }

            else if(option == 8) {
                if(currentUser == null && exists == true){
                    User response = User.login(users);

                    if(response != null){
                        currentUser = response; 
                        System.out.println("\nLogin realizado!"); 
                    }
                    else{
                        System.out.println("\nUsuário ou senha incorretos.");
                    }

                    time();
                }
                else if(exists == false){
                    System.out.println("\n\n Não há usuários cadastrados \n\n"); 
                }
                else{
                    System.out.println("\n\n Faça logout \n\n"); 
                    time();
                }

                time();
            }

            else if(option == 9) {
                currentUser = null;
                System.out.print("\n\n Logout feito! \n\n");
                time();
            }
        }
        
    }
       

}
