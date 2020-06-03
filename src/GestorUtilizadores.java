import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;


public class GestorUtilizadores {

    private static FuncionalidadesStub funcionalidades;

    private static GestorUtilizadores instance = null;

    private GestorUtilizadores() {
    }

    public static GestorUtilizadores getInstance() {
        if (instance == null) {
            instance = new GestorUtilizadores();
            funcionalidades = new FuncionalidadesStub();
        }

        return instance;
    }


    //código para utilizar stub

/*
    public void criarUtilizador(String id, String email, String first_name, String last_name, String avatar) {
        Utilizador utilizador = new Utilizador(id, email, first_name, last_name, avatar);

        Resposta resposta = funcionalidades.criarUtilizador(utilizador);

        if (resposta.getErro().isEmpty()) {
            System.out.println("Utilizador criado com sucesso");
        } else {
            System.out.println("Erro ao criar utilizador: " + resposta.getErro());
        }
    }

    public void consultarDadosUtilizador(String id) {
        Resposta resposta = funcionalidades.consultarDadosUtilizador(id);

        if (resposta.getErro().isEmpty()) {
            System.out.println(resposta.getUtilizadoresDevolvidos().get(0).getFirst_name() + " " + resposta.getUtilizadoresDevolvidos().get(0).getLast_name());
        } else {
            System.out.println("Erro ao consultar dados de utilizador: " + resposta.getErro());
        }
    }

    public void listarUtilizadores() {
        ArrayList<Utilizador> utilizadores = funcionalidades.listarUtilizadores().getUtilizadoresDevolvidos();

        for (Utilizador utilizador : utilizadores) {
            System.out.println(utilizador.getFirst_name() + " " + utilizador.getLast_name());
        }
    }

    public void registarUtilizador(String email, String password) {
        Resposta resposta = funcionalidades.registarUtilizador(email, password);

        if (resposta.getErro().isEmpty())
            System.out.println("Utilizador registado com sucesso");
        else
            System.out.println("Erro ao registar utilizador: " + resposta.getErro());
    }

    public void autenticarUtilizador(String email, String password) {
        Resposta resposta = funcionalidades.autenticarUtilizador(email, password);

        if (resposta.getErro().isEmpty())
            System.out.println("Utilizador registado com sucesso");
        else
            System.out.println("Erro ao autenticar utilizador: " + resposta.getErro());
    }


    public void consultarRecurso(String id) {
        Resposta resposta = funcionalidades.consultarRecurso(id);

        if (resposta.getErro().isEmpty()) {
            System.out.println(resposta.getRecursosDevolvidos().get(0).getName() + " " + resposta.getRecursosDevolvidos().get(0).getYear());
        } else {
            System.out.println("Erro ao consultar recurso: " + resposta.getErro());
        }
    }

    public void listarRecursos() {
        ArrayList<Recurso> recursos = funcionalidades.listarRecursos().getRecursosDevolvidos();

        for (Recurso recurso : recursos) {
            System.out.println(recurso.getName() + " " + recurso.getYear());
        }

    }
*/


//código com a aplicação integrada

    public void criarUtilizador(String id, String email, String first_name, String last_name, String avatar) throws IOException {
        Utilizador utilizador = new Utilizador(id, email, first_name, last_name, avatar);

        Resposta resposta = Funcoes.criarUtilizador(utilizador);

        if (resposta.getErro().isEmpty()) {
            System.out.println("Utilizador criado com sucesso");
        } else {
            System.out.println("Erro ao criar utilizador: " + resposta.getErro());
        }
    }


    public void consultarDadosUtilizador(String id) throws IOException, JSONException {
        Resposta resposta = Funcoes.consultarDadosUtilizador(id);

        if (resposta.getErro().isEmpty()) {
            System.out.println(resposta.getUtilizadoresDevolvidos().get(0).getFirst_name() + " " + resposta.getUtilizadoresDevolvidos().get(0).getLast_name());
        } else {
            System.out.println("Erro ao consultar dados de utilizador: " + resposta.getErro());
        }
    }

    public void listarUtilizadores() throws IOException, JSONException {
        ArrayList<Utilizador> utilizadores = Funcoes.listarUtilizadores().getUtilizadoresDevolvidos();

        for (Utilizador utilizador : utilizadores) {
            System.out.println(utilizador.getFirst_name() + " " + utilizador.getLast_name());
        }

    }


    public void registarUtilizador(String email, String password) throws IOException {
        Resposta resposta = Funcoes.registarUtilizador(email, password);

        if (resposta.getErro().isEmpty())
            System.out.println("Utilizador registado com sucesso");
        else
            System.out.println("Erro ao registar utilizador: " + resposta.getErro());
    }

    public void autenticarUtilizador(String email, String password) throws IOException {
        Resposta resposta = Funcoes.autenticarUtilizador(email, password);

        if (resposta.getErro().isEmpty())
            System.out.println("Utilizador autenticado com sucesso");
        else
            System.out.println("Erro ao autenticar utilizador: " + resposta.getErro());
    }


    public void consultarRecurso(String id) throws IOException, JSONException {
        Resposta resposta = funcionalidades.consultarRecurso(id);

        if (resposta.getErro().isEmpty()) {
            System.out.println(resposta.getRecursosDevolvidos().get(0).getName() + " " + resposta.getRecursosDevolvidos().get(0).getYear());
        } else {
            System.out.println("Erro ao consultar recurso: " + resposta.getErro());
        }
    }

    public void listarRecursos() throws IOException, JSONException {
        ArrayList<Recurso> recursos = Funcoes.listarRecursos().getRecursosDevolvidos();

        for (Recurso recurso : recursos) {
            System.out.println(recurso.getName() + " " + recurso.getYear());
        }

    }
}
