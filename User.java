import java.util.Scanner;

public class User {
    private String name;
    private String name_user;
    private String password;
    private Profile profile;

    public User(String name, String name_user, String password) {

        this.name = name;
        this.name_user = name_user;
        this.password = password;
        this.profile = new Profile();
    }

    public static User createUser(){

        String name, name_user, password;
        Scanner input = new Scanner(System.in);

        System.out.print("\n\n-- CADASTRO DE USUÁRIO --\n");
        System.out.print("\nDigite seu primeiro nome: ");
        name = input.next();

        System.out.print("Digite seu nome de usuário: ");
        name_user = input.next();

        System.out.print("Digite uma senha forte: ");
        password = input.next();

        User new_user = new User(name, name_user, password);

        System.out.print("\n- USUÁRIO CADASTRADO! -");

        return new_user;
    }

    public String printUser(){
        return "nome: " + this.name +
                "\n nome de usuário: " + this.name_user +
                "\n senha: " + this.password;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNameUser(String name_user){
        this.name_user = name_user;
    }

    public void setPassword(String password){
        this.password = password;
    }
    
}