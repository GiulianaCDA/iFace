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
        System.out.print("\n[4] Verificar dados\n");
        System.out.print("_________________________\n\n");
        System.out.print("Resposta [1-4]: ");
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
                if(exists){
                    System.out.print("\n\n iremos editar. \n\n");
                    currentUser = Profile.editProfile(currentUser);
                }
                else{
                    System.out.print("\n\n Ainda não há um usuário cadastrado. \n\n");
                }

                time();
            }


            else if(option == 4){
                currentUser.printUser();
                currentUser.profile.printProfile();
                time();
            }
        }
        
    }
       

}
