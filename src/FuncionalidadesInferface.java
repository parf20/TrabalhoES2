import java.util.ArrayList;

public interface FuncionalidadesInferface {

    public boolean criarUtilizador(Utilizador utilizador);
    public Utilizador consultarDadosUtilizador(String id);
    public ArrayList<Utilizador> listarUtilizadores();
    public boolean registarUtilizador(String email, String password);
    public boolean autenticarUtilizador(String email, String password);
    public ArrayList<Recurso> listarRecursos();
    public Recurso consultarRecurso(String id);

}
