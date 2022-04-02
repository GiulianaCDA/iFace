import java.util.Scanner;
import java.util.ArrayList; 


public class Main {

    public static void time(){

        try{
            Thread.sleep(1000);
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }

    public static User createUser(){

        String name, name_user, password;
        Scanner input = new Scanner(System.in);

        System.out.print("\n\n-- CADASTRO DE USUÁRIO --\n");
        System.out.print("\nDigite seu nome: ");
        name = input.next();

        System.out.print("Digite seu nome de usuário: ");
        name_user = input.next();

        System.out.print("Digite uma senha forte: ");
        password = input.next();

        System.out.print("\n- USUÁRIO CADASTRADO! -");

        User new_user = new User(name, name_user, password);

        return new_user;
    }
    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<User>();
        boolean run = true;
        boolean exists = false;
        User current_user = null;

        System.out.print("\n----- BEM VINDO AO IFACE! -----\n");

        while(run){
            System.out.print("\n\n-- Escolha uma ação --\n");
            System.out.print("\n[1] Cadastrar usuário\n");
            System.out.print("\n[2] Editar perfil\n");
            System.out.print("\n[3] Recuperar informações\n");
            System.out.print("\n[4] Verificar dados\n");
            System.out.print("_________________________\n\n");
            System.out.print("Resposta [1-4]: ");

            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
    
            if(option == 1) {

                exists = true;
                User new_user = createUser();

                users.add(new_user);
                current_user = new_user;

                time();

            }

            else if(option == 2 && exists){

                System.out.print("\n-- O que você deseja alterar? --\n");

                System.out.print("\n [1] Nome \n");
                System.out.print("\n [2] Nome de usuário \n");
                System.out.print("\n [3] Senha \n");
                System.out.print("_________________________\n\n");
                System.out.print("Resposta [1-3]: ");

                int setOption = input.nextInt();

                if(setOption == 1){
                    System.out.print("\nNovo nome: ");
                    String name = input.next();
                    current_user.setName(name);
                }
                else if(setOption == 2){
                    System.out.print("\nNovo nome de usuário: ");
                    String name_user = input.next();
                    current_user.setNameUser(name_user);

                }
                else if(setOption == 3){
                    System.out.print("\nNova senha: ");
                    String password = input.next();
                    current_user.setPassword(password);
                }
                else{
                    System.out.print("\nOpção inválida\n");
                }

                System.out.print("\n- EDIÇÃO REALIZADA! -");

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
