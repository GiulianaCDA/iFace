import java.util.Scanner;
import java.util.ArrayList; 


public class User {

    public String name;
    public String nickName;
    private String password;
    public Profile profile;

    public User(String name, String nickName, String password) {

        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.profile = new Profile();
    }

    public static User createUser(ArrayList<User> users){

        String name, nickName, password;
        Scanner input = new Scanner(System.in);
        Scanner messageReceiver = new Scanner(System.in);
        messageReceiver.useDelimiter("\n");

        System.out.print("\n\n-- CADASTRO DE USUÁRIO --\n");
        System.out.print("\nNome: ");
        name = messageReceiver.next( );

        System.out.print("Nome de usuário: ");
        nickName = input.next();

        System.out.print("Senha: ");
        password = input.next();

        User new_user = new User(name, nickName, password);

        User userFind = exists(users, new_user.nickName);

        if(userFind != null){
            System.out.print("\nOps..esse nome de usuário já existe\n");
            return null;
        } 
        else{
            users.add(new_user);
            System.out.print("\nUsuário cadastrado\n");
        }

        return new_user;
    }

    public void printUser(){

        System.out.println('\n');
        System.out.println("Nome: " + this.name);
        System.out.println("Nome de usuário: " + this.nickName);
        System.out.println("Senha: " + this.password);

    }

    public static User login(ArrayList<User> users){ 


        Scanner input = new Scanner(System.in);

        System.out.print("\nNome de usuário: ");
        String name = input.next();


        System.out.print("\nSenha: ");
        String password = input.next();


        for(User i : users) {   

            if((i.nickName.equals(name)) && (i.password.equals(password))){ 
                return i;
            } 
        }  

        return null;
    }
    
    public void setName(String newName){
        this.name = newName;
    }

    public void setnickName(String newnickName){
        this.nickName = newnickName;
    }

    public void setPassword(String newPassword){
        this.password = newPassword;
    }
    
    public static User exists(ArrayList<User> users, String nickName){

        for(User u : users){
            if(u.nickName.equals(nickName)){
                return u;
            }
        }
        return null;
    }
   
    public static ArrayList<User> removeUser(ArrayList<User> users, User currentUser){

        users.remove(currentUser);

        return users;
    }
}