import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


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
                    System.out.println("Por favor escolha uma escolha válida");
            }


            switch (escolha) {
                case "1":
                    System.out.println("Insiro o id do utilizador");
                    String id = scanner.nextLine();
                    System.out.println("Insiro o email do utilizador");
                    String email = scanner.nextLine();
                    System.out.println("Insiro o primeiro nome do utilizador");
                    String firstName = scanner.nextLine();
                    System.out.println("Insiro o ultimo nome do utilizador");
                    String lastName = scanner.nextLine();
                    System.out.println("Insiro o avatar do utilizador");
                    String avatar = scanner.nextLine();
                    GestorUtilizadores.getInstance().criarUtilizador(id, email, firstName, lastName, avatar);
                    break;
                case "2":
                    System.out.println("Insiro o id do utilizador");
                    GestorUtilizadores.getInstance().consultarDadosUtilizador(scanner.nextLine());
                    break;
                case "3":
                    GestorUtilizadores.getInstance().listarUtilizadores();
                    break;
                case "4":
                    System.out.println("Insiro o email");
                    String emailRegister = scanner.nextLine();
                    System.out.println("Insiro a palavra-passe");
                    String passwordregister = scanner.nextLine();
                    GestorUtilizadores.getInstance().registarUtilizador(emailRegister, passwordregister);
                    break;
                case "5":
                    System.out.println("Insiro o email");
                    String emailLogin = scanner.nextLine();
                    System.out.println("Insiro a palavra-passe");
                    String passwordLogin = scanner.nextLine();
                    GestorUtilizadores.getInstance().autenticarUtilizador(emailLogin, passwordLogin);

                    break;
                case "6":
                    GestorUtilizadores.getInstance().listarRecursos();
                    break;
                case "7":
                    System.out.println("Insiro o id do recurso");
                    GestorUtilizadores.getInstance().consultarRecurso(scanner.nextLine());
                    break;
                case "8":
                    return;
            }


        }


    }
}