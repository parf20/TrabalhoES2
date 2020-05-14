import java.util.ArrayList;
import java.util.HashMap;

public class FuncionalidadesStub implements FuncionalidadesInferface {

    private ArrayList<Utilizador> utilizadores = new ArrayList<>();
    private ArrayList<Recurso> recursos = new ArrayList<>();

    private HashMap<String, String> credenciais = new HashMap<>() {{
        put("admin@test.com", "admin");
    }};


    FuncionalidadesStub() {
        utilizadores.add(new Utilizador("1", "teste@mail.com", "Ruben", "Almeida", "regerger.jpg"));
        utilizadores.add(new Utilizador("2", "teste2@mail.com", "Francisco", "Morais", "regerger.jpg"));
        utilizadores.add(new Utilizador("3", "teste3@mail.com", "Pedro", "Vieira", "regerger.jpg"));
        utilizadores.add(new Utilizador("4", "teste4@mail.com", "Alexandre", "Roberto", "regerger.jpg"));

        recursos.add(new Recurso("1", "recurso 1", "2020", "#dddddd", "17-2031"));
        recursos.add(new Recurso("2", "recurso 2", "2020", "#aaaaaa", "17-2032"));
        recursos.add(new Recurso("3", "recurso 3", "2020", "#bbbbbb", "17-2033"));
        recursos.add(new Recurso("4", "recurso 4", "2020", "#cccccc", "17-2034"));

    }

    @Override
    public boolean criarUtilizador(Utilizador utilizador) {
        utilizadores.add(utilizador);
        return true;
    }

    @Override
    public Utilizador consultarDadosUtilizador(String id) {
        for (Utilizador utilizador : utilizadores) {
            if (utilizador.getId().equals(id))
                return utilizador;
        }
        return null;
    }

    @Override
    public ArrayList<Utilizador> listarUtilizadores() {
        return utilizadores;
    }

    @Override
    public boolean registarUtilizador(String email, String password) {
        if (credenciais.containsKey(email))
            return false;

        for (Utilizador utilizador : utilizadores) {
            if (utilizador.getEmail().equals(email)) {
                credenciais.put(email, password);
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean autenticarUtilizador(String email, String password) {
        if (credenciais.containsKey((email))) {
            return credenciais.get(email).equals(password);
        }
        return false;
    }

    @Override
    public ArrayList<Recurso> listarRecursos() {
        return recursos;
    }

    @Override
    public Recurso consultarRecurso(String id) {
        for (Recurso recurso : recursos) {
            if (recurso.getId().equals(id))
                return recurso;
        }
        return null;
    }
}
