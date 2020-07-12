import org.json.JSONException;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, JSONException, ResourceNotFoundException, NullEmptyFieldException, UserNotFoundException, InvalidEmailFormatException, InvalidCredentialsException, UserExistingException, InvalidPasswordFormatException {


        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nAplicação de gestão de utilizadores\n");
        System.out.println("1-Efetuar autenticação");
        System.out.println("2-Efetuar registo");


        String selecao = "";
        while (true) {
            selecao = scanner.nextLine();
            if (selecao.equals("1") || selecao.equals("2")) {
                break;
            } else
                System.out.println("Por favor insira um número de funcionalidade válido");
        }


        if (selecao.equals("1")) {
            System.out.println("Insira o email");
            String emailLogin = scanner.nextLine();
            System.out.println("Insira a palavra-passe");
            String passwordLogin = scanner.nextLine();
            GestorUtilizadores.getInstance().autenticarUtilizador(emailLogin, passwordLogin);
            System.out.println("\n\nAutenticado com sucesso!");
        } else {
            System.out.println("Insira o email");
            String emailRegister = scanner.nextLine();
            System.out.println("Insira a palavra-passe");
            String passwordregister = scanner.nextLine();
            GestorUtilizadores.getInstance().registarUtilizador(emailRegister, passwordregister);
            System.out.println("\n\nRegistado com sucesso!");
        }


        while (true) {

            System.out.println("\n\nAplicação de gestão de utilizadores\n");

            System.out.println("1-Criar utilizador");
            System.out.println("2-Consultar dados de um utilizador");
            System.out.println("3-Listar utilizadores");
            System.out.println("4-Registar utilizador");
            System.out.println("5-Autenticar utilizador");
            System.out.println("6-Listar recursos");
            System.out.println("7-Consultar recurso");
            System.out.println("8-Sair");


            String escolha = "";
            while (true) {
                escolha = scanner.nextLine();
                if (escolha.equals("1") || escolha.equals("2") || escolha.equals("3") || escolha.equals("4") || escolha.equals("5") || escolha.equals("6") || escolha.equals("7") || escolha.equals("8")) {
                    break;
                } else
                    System.out.println("Por favor insira um número de funcionalidade válido");
            }


            switch (escolha) {
                case "1":
                    System.out.println("Insira o id do utilizador");
                    String id = scanner.nextLine();
                    System.out.println("Insira o email do utilizador");
                    String email = scanner.nextLine();
                    System.out.println("Insira o primeiro nome do utilizador");
                    String firstName = scanner.nextLine();
                    System.out.println("Insira o ultimo nome do utilizador");
                    String lastName = scanner.nextLine();
                    System.out.println("Insira o avatar do utilizador");
                    String avatar = scanner.nextLine();
                    GestorUtilizadores.getInstance().criarUtilizador(id, email, firstName, lastName, avatar);
                    break;
                case "2":
                    System.out.println("Insira o id do utilizador");
                    GestorUtilizadores.getInstance().consultarDadosUtilizador(scanner.nextLine());
                    break;
                case "3":
                    GestorUtilizadores.getInstance().listarUtilizadores();
                    break;
                case "4":
                    System.out.println("Insira o email");
                    String emailRegister = scanner.nextLine();
                    System.out.println("Insira a palavra-passe");
                    String passwordregister = scanner.nextLine();
                    GestorUtilizadores.getInstance().registarUtilizador(emailRegister, passwordregister);
                    break;
                case "5":
                    System.out.println("Insira o email");
                    String emailLogin = scanner.nextLine();
                    System.out.println("Insira a palavra-passe");
                    String passwordLogin = scanner.nextLine();
                    GestorUtilizadores.getInstance().autenticarUtilizador(emailLogin, passwordLogin);

                    break;
                case "6":
                    GestorUtilizadores.getInstance().listarRecursos();
                    break;
                case "7":
                    System.out.println("Insira o id do recurso");
                    GestorUtilizadores.getInstance().consultarRecurso(scanner.nextLine());
                    break;
                case "8":
                    return;
            }


        }


    }
}
