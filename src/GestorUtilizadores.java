import java.util.ArrayList;
import java.util.HashMap;

public class GestorUtilizadores {

    private static FuncionalidadesStub funcionalidades;

    private static GestorUtilizadores instance = null;

    private ArrayList<Utilizador> utilizadores = new ArrayList<>();

    private GestorUtilizadores() {
    }

    public static GestorUtilizadores getInstance() {
        if (instance == null) {
            instance = new GestorUtilizadores();
            funcionalidades = new FuncionalidadesStub();
        }

        return instance;
    }


    public void criarUtilizador(String id, String email, String first_name, String last_name, String avatar) {
        Utilizador utilizador = new Utilizador(id, email, first_name, last_name, avatar);

        if (funcionalidades.criarUtilizador(utilizador)) {
            System.out.println("Utilizador criado com sucesso");
        } else {
            System.out.println("Erro ao criar utilizador");
        }
    }

    public void consultarDadosUtilizador(String id) {
        Utilizador utilizador = funcionalidades.consultarDadosUtilizador(id);

        if (utilizador != null) {
            System.out.println(utilizador.getFirst_name() + " " + utilizador.getLast_name());
        } else {
            System.out.println("Utilizador não encontrado");
        }
    }

    public void listarUtilizadores() {
        ArrayList<Utilizador> utilizadores = funcionalidades.listarUtilizadores();

        for (Utilizador utilizador : utilizadores) {
            System.out.println(utilizador.getFirst_name() + " " + utilizador.getLast_name());
        }
    }

    public void registarUtilizador(String email, String password) {
        if (funcionalidades.registarUtilizador(email, password))
            System.out.println("Utilizador registado com sucesso");
        else
            System.out.println("Erro ao registar utilizador");
    }

    public void autenticarUtilizador(String email, String password) {

        if (funcionalidades.autenticarUtilizador(email, password))
            System.out.println("Autenticado com sucesso");
        else
            System.out.println("Erro de autenticação");
    }


    public void consultarRecurso(String id) {
        Recurso recurso = funcionalidades.consultarRecurso(id);

        if (recurso != null) {
            System.out.println(recurso.getName() + " " + recurso.getYear());
        } else {
            System.out.println("Recurso não encontrado");
        }
    }

    public void listarRecursos() {
        ArrayList<Recurso> recursos = funcionalidades.listarRecursos();

        for (Recurso recurso : recursos) {
            System.out.println(recurso.getName() + " " + recurso.getYear());
        }

    }

}
