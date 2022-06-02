import java.util.Scanner;
import java.util.ArrayList; 
import java.util.InputMismatchException; 

public class Exceptions {
    public static int optionValidator(int min, int max){
        Scanner input = new Scanner(System.in);
        int option = 0;

        while (option == 0) {
            try {
                option = input.nextInt();
                if(option < 1 || option > max){
                    System.out.println("\nDigite um valor entre ["+min+"-"+max+"]: ");
                    option = 0;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nOps... você digitou caracteres. Precisamos que digite apenas números.\n");
                System.out.print("Resposta ["+min+"-"+max+"]:");
            }
            input.nextLine();

        } 

        return option;
    }
}
