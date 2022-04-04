import java.util.Scanner;
import java.util.Dictionary;
import java.util.Hashtable;

public class Profile {

    private String hobbie;
    private String status; 
    private int age;

    public Profile(){
        
    }

    public Profile(String hobbie, String status, int age) {
        this.hobbie = hobbie;
        this.status = status;
        this.age = age;
    }

    public static int menu(){

        System.out.print("\n-- O que você deseja editar? --\n");

        System.out.print("\n[1] Nome \n");
        System.out.print("\n[2] Nome de usuário \n");
        System.out.print("\n[3] Hobbie \n");
        System.out.print("\n[4] Estado civil \n");
        System.out.print("\n[5] Idade \n");
        System.out.print("\n[6] Senha \n");
        System.out.print("_________________________\n\n");
        System.out.print("Resposta [1-6]: ");

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        return option;
    }

    public static User editProfile(User user){

        int option = menu();
        Scanner input = new Scanner(System.in);

        switch(option) {
            case 1:
                System.out.print("\nNovo nome: ");
                String name = input.next();
                user.setName(name);
                System.out.print("\nEdição feita com sucesso! \n");
                break;

            case 2:
                System.out.print("\nNovo nome de usuário: ");
                String nameUser = input.next();
                user.setNameUser(nameUser);
                System.out.print("\nEdição feita com sucesso! \n");
                break;

            case 3:
                System.out.print("\nHobbie: ");
                String hobbie = input.next();
                user.profile.setHobbie(hobbie);
                System.out.print("\nEdição feita com sucesso! \n");
                break;

            case 4:
                System.out.print("\nNovo estado civil: ");
                String status = input.next();
                user.profile.setStatus(status);
                System.out.print("\nEdição feita com sucesso! \n");
                break;

            case 5:
                System.out.print("\nNova idade: ");
                int age = input.nextInt();
                user.profile.setAge(age);
                System.out.print("\nEdição feita com sucesso! \n");
                break;
            
            case 6:
                System.out.print("\nNova senha: ");
                String password = input.next();
                user.setPassword(password);
                System.out.print("\nEdição feita com sucesso! \n");
                break;
        }

        return user;
    }

    public void printProfile(){

        if(this.hobbie != null){
            System.out.println("Hobbie: " + this.hobbie);
        }
        else {
            System.out.println("Hobbie: não existe");
        }

        if(this.status != null){
            System.out.println("Status: " + this.status);
        }
        else {
            System.out.println("Status: não existe");
        }

        if(this.age != 0){
            System.out.println("Idade: " + this.age);
        }
        else{
            System.out.println("Idade: não existe");
        }

    }

    public void setHobbie(String newHobbie) {
        this.hobbie = newHobbie;
    }

    public void setStatus(String newStatus) {
        this.status = newStatus;
    }

    public void setAge(int newAge){
        this.age = newAge;
    }
}