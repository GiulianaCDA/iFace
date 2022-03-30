import java.util.Scanner;
import java.util.ArrayList; 


public class Main {

    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<User>();
        boolean run = true;
        boolean exists = false;

        System.out.print("\n\n------- BEM VINDO AO IFACE! -------\n");

        while(run){
            System.out.print("\n-- Escolha uma ação: --\n");
            System.out.print("\n[1] Cadastrar usuário\n");
            System.out.print("\n[2] Editar perfil\n");
            System.out.print("\n[3] Recuperar informações\n");
            System.out.print("\n[4] Verificar dados\n\n");
            
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            int size = users.size() - 1;
            User current_user = users.get(size);
    
            if(option == 1) {
                exists = true;
                String name, name_user, password;
    
                System.out.print("\nDigite seu nome: \n");
                name = input.next();
        
                System.out.print("\nDigite seu nome de usuário:\n");
                name_user = input.next();
        
                System.out.print("\nDigite uma senha forte: \n");
                password = input.next();
    
                User new_user = new User(name, name_user, password);
                users.add(new_user);

                current_user = new_user;
                System.out.print(current_user);

            }

            else if(option == 2){

                System.out.print("\n O que você deseja alterar? \n");

                System.out.print("\n [1] Nome \n");
                System.out.print("\n [2] Nome de usuário \n");
                System.out.print("\n [3] Senha \n");

                int setOption = input.nextInt();

                if(setOption == 1){
                    System.out.print("\n Digite seu novo nome: \n");
                    String name = input.next();
                    current_user.setName(name);
                }
                else if(setOption == 2){
                    System.out.print("\n Digite seu novo nome de usuário: \n");
                    String name_user = input.next();
                    current_user.setNameUser(name_user);
                }
                else if(setOption == 3){
                    System.out.print("\n Digite sua nova senha: \n");
                    String password = input.next();
                    current_user.setPassword(password);
                }
                else{
                    System.out.print("\nOpção inválida\n");
                }

            }

            else if(option == 4){
                for(int i=0; i < users.size(); i++){
                    System.out.println(users.get(i).printUser());
                }
            }
        }
        
    }
       

}
