import java.util.ArrayList;
import java.util.HashMap;

public class FuncionalidadesStub implements FuncionalidadesInferface {

    private ArrayList<Utilizador> utilizadores = new ArrayList<>();
    private ArrayList<Recurso> recursos = new ArrayList<>();

    private HashMap<String, String> credenciais = new HashMap<>() {{
        put("admin@mail.com", "admin");
    }};


    FuncionalidadesStub() {
        utilizadores.add(new Utilizador("1", "ruben@mail.com", "Ruben", "Almeida", "regerger.jpg"));
        utilizadores.add(new Utilizador("2", "teste2@mail.com", "Francisco", "Morais", "regerger.jpg"));
        utilizadores.add(new Utilizador("3", "teste3@mail.com", "Pedro", "Vieira", "regerger.jpg"));
        utilizadores.add(new Utilizador("4", "teste4@mail.com", "Alexandre", "Roberto", "regerger.jpg"));
        utilizadores.add(new Utilizador("5", "admin@mail.com", "Admin", "Admin", "regerger.jpg"));


        recursos.add(new Recurso("1", "recurso 1", "2020", "#dddddd", "17-2031"));
        recursos.add(new Recurso("2", "recurso 2", "2020", "#aaaaaa", "17-2032"));
        recursos.add(new Recurso("3", "recurso 3", "2020", "#bbbbbb", "17-2033"));
        recursos.add(new Recurso("4", "recurso 4", "2020", "#cccccc", "17-2034"));

    }

    @Override
    public Resposta criarUtilizador(Utilizador utilizador) {

        if (utilizador == null)
            return new Resposta().criarUtilizadorNull();

        if (utilizador.getEmail() == null)
            return new Resposta().criarUtilizadorEmailVazioNulo();

        if (utilizador.getEmail().isEmpty())
            return new Resposta().criarUtilizadorEmailVazioNulo();

        if (!utilizador.getEmail().contains("@"))
            return new Resposta().criarUtilizadorEmailFormatoInvalido();

        for (Utilizador utilizador1 : utilizadores) {
            if (utilizador1.getEmail().equals(utilizador.getEmail()))
                return new Resposta().criarUtilizadorExistente();
        }
        return new Resposta().criarUtilizadorSucesso();

    }

    @Override
    public Resposta consultarDadosUtilizador(String id) {

        if (id == null)
            return new Resposta().consultarDadosUtilizadorIdVazioNulo();

        if (id.isEmpty())
            return new Resposta().consultarDadosUtilizadorIdVazioNulo();

        for (Utilizador utilizador : utilizadores) {
            if (utilizador.getId().equals(id))
                return new Resposta().consultarDadosUtilizadorExistente(utilizador);
        }
        return new Resposta().consultarDadosUtilizadorInexistente();
    }

    @Override
    public Resposta listarUtilizadores() {
        return new Resposta().listarUtilizadoresSucesso(utilizadores);
    }

    @Override
    public Resposta registarUtilizador(String email, String password) {

        if (email == null || password == null)
            return new Resposta().registarUtilizadorCredenciaisVazias();

        if (email.isEmpty() || password.isEmpty())
            return new Resposta().registarUtilizadorCredenciaisVazias();

        boolean existe = false;
        for (Utilizador utilizador : utilizadores) {
            if (utilizador.getEmail().equals(email)) {
                existe = true;
                break;
            }
        }
        if (!existe)
            return new Resposta().registarUtilizadorNaoCriado();

        if (credenciais.containsKey(email))
            return new Resposta().registarUtilizadorJaRegistado();
        else {
            credenciais.put(email, password);
            return new Resposta().registarUtilizadorSucesso();
        }

    }

    @Override
    public Resposta autenticarUtilizador(String email, String password) {

        if (email == null || password == null)
            return new Resposta().autenticarUtilizadorCredenciaisVazias();

        if (email.isEmpty() || password.isEmpty())
            return new Resposta().autenticarUtilizadorCredenciaisVazias();

        if (credenciais.containsKey(email) && credenciais.get(email).equals(password)) {
            return new Resposta().autenticarUtilizadorSucesso();
        }
        return new Resposta().autenticarUtilizadorCredenciaisInvalidas();
    }

    @Override
    public Resposta listarRecursos() {
        return new Resposta().listagemRecursosSucesso(recursos);
    }

    @Override
    public Resposta consultarRecurso(String id) {
        if (id == null)
            return new Resposta().consultarRecursoIdVazioNulo();

        if (id.isEmpty())
            return new Resposta().consultarRecursoIdVazioNulo();

        for (Recurso recurso : recursos) {
            if (recurso.getId().equals(id))
                return new Resposta().consultarRecursoExistente(recurso);
        }
        return new Resposta().consultarRecursoInexistente();
    }
}
