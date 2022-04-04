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
        System.out.print("\n[3] Recuperar informações\n");
        System.out.print("\n[4] Login\n");
        System.out.print("\n[5] Logout\n");
        System.out.print("_________________________\n\n");
        System.out.print("Resposta [1-5]: ");
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

            else if(option == 2){
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
                    currentUser.printUser();
                    currentUser.profile.printProfile();
                }
                else{
                    System.out.print("\n\n Faça login. \n\n");
                }

                time();
            }

            else if(option == 4) {
                if(currentUser == null && exists == true){
                    User response = User.login(users);

                    if(response != null){
                        currentUser = response; 
                        System.out.println("Login realizado!"); 
                    }
                    else{
                        System.out.println("Usuário ou senha incorretos.");
                    }
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

            else if(option == 5) {
                currentUser = null;
                System.out.print("\n\n Logout feito! \n\n");
            }
        }
        
    }
       

}
