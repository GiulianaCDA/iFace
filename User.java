import java.util.Scanner;
import java.util.ArrayList; 


public class User {

    public String name;
    public String nameUser;
    private String password;
    public Profile profile;

    public User(String name, String nameUser, String password) {

        this.name = name;
        this.nameUser = nameUser;
        this.password = password;
        this.profile = new Profile();
    }

    public static User createUser(){

        String name, nameUser, password;
        Scanner input = new Scanner(System.in);
        Scanner messageReceiver = new Scanner(System.in);
        messageReceiver.useDelimiter("\n");

        System.out.print("\n\n-- CADASTRO DE USUÁRIO --\n");
        System.out.print("\nNome: ");
        name = messageReceiver.next( );

        System.out.print("Nome de usuário: ");
        nameUser = input.next();

        System.out.print("Senha: ");
        password = input.next();

        User new_user = new User(name, nameUser, password);

        System.out.print("\n- USUÁRIO CADASTRADO! -");

        return new_user;
    }

    public void printUser(){

        System.out.println('\n');
        System.out.println("Nome: " + this.name);
        System.out.println("Nome de usuário: " + this.nameUser);
        System.out.println("Senha: " + this.password);

    }

    public static User login(ArrayList<User> users){ 


        Scanner input = new Scanner(System.in);

        System.out.print("\nNome de usuário: ");
        String name = input.next();


        System.out.print("\nSenha: ");
        String password = input.next();


        for(User i : users) {   

            if((i.nameUser.equals(name)) && (i.password.equals(password))){ 
                return i;
            } 
        }  

        return null;
    }
    
    public void setName(String newName){
        this.name = newName;
    }

    public void setNameUser(String newNameUser){
        this.nameUser = newNameUser;
    }

    public void setPassword(String newPassword){
        this.password = newPassword;
    }
    
}