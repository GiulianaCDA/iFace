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

    public static User editProfile(User user){

        System.out.print("\n-- O que você deseja alterar? --\n");

        System.out.print("\n[1] Nome \n");
        System.out.print("\n[2] Nome de usuário \n");
        System.out.print("\n[3] Senha \n");
        System.out.print("_________________________\n\n");
        System.out.print("Resposta [1-3]: ");

        Scanner input = new Scanner(System.in);
        int setOption = input.nextInt();

        if(setOption == 1){
            System.out.print("\nNovo nome: ");
            String name = input.next();
            user.setName(name);
        }
        else if(setOption == 2){
            System.out.print("\nNovo nome de usuário: ");
            String name_user = input.next();
            user.setNameUser(name_user);

        }
        else if(setOption == 3){
            System.out.print("\nNova senha: ");
            String password = input.next();
            user.setPassword(password);
        }
        else{
            System.out.print("\nOpção inválida\n");
        }

        System.out.print("\n- EDIÇÃO REALIZADA! -");

        return user;
    }
   
    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<User>();
        boolean run = true;
        boolean exists = false;
        User current_user = null;


        while(run){

            menu(exists);

            Scanner input = new Scanner(System.in);
            int option = input.nextInt();

            if(option == 1) {

                exists = true;
                User new_user = User.createUser();
                users.add(new_user);
                current_user = new_user;

                time();
            }

            else if(option == 2){
                if(exists){
                    current_user = editProfile(current_user);
                }
                else{
                    System.out.print("\n\n Ainda não há um usuário cadastrado \n\n");
                }

                time();
            }


            else if(option == 4){
                for(int i=0; i < users.size(); i++){
                    System.out.println(users.get(i).printUser());
                }
            }
        }
        
    }
       

}
