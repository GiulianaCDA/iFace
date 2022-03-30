
public class User {
    private String name;
    private String name_user;
    private String password;

    public User(String name, String name_user, String password) {

        this.name = name;
        this.name_user = name_user;
        this.password = password;
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