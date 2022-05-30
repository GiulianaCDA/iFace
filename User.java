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

    public static User createUser(ArrayList<User> users){

        String name, nameUser, password;
        boolean exists;
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

        exists = exists(users, new_user.nameUser);

        if(exists){
            System.out.print("\n- Ops..esse nome de usuário já existe -\n");
            return null;
        } 
        else{
            users.add(new_user);
            System.out.print("\n- Usuário cadastrado! -\n");
        }

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
    
    public static boolean exists(ArrayList<User> users, String nameUser){

        for(User u : users){
            if(u.nameUser.equals(nameUser)){
                return true;
            }
        }
        return false;
    }
   
    public static ArrayList<User> removeUser(ArrayList<User> users, User currentUser){

        users.remove(currentUser);

        return users;
    }
}