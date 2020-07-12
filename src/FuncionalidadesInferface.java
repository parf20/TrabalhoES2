import java.util.ArrayList;

public interface FuncionalidadesInferface {

   /*  public boolean criarUtilizador(Utilizador utilizador);
    public Utilizador consultarDadosUtilizador(String id);
    public ArrayList<Utilizador> listarUtilizadores();
    public boolean registarUtilizador(String email, String password);
    public boolean autenticarUtilizador(String email, String password);
    public ArrayList<Recurso> listarRecursos();
    public Recurso consultarRecurso(String id);   */


    public Resposta criarUtilizador(Utilizador utilizador) throws NullEmptyFieldException, InvalidEmailFormatException, UserExistingException;

    public Resposta consultarDadosUtilizador(String id) throws NullEmptyFieldException, UserNotFoundException;

    public Resposta listarUtilizadores();

    public Resposta registarUtilizador(String email, String password) throws NullEmptyFieldException, UserNotFoundException, UserExistingException, InvalidEmailFormatException, InvalidPasswordFormatException;

    public Resposta autenticarUtilizador(String email, String password) throws NullEmptyFieldException, InvalidCredentialsException, InvalidEmailFormatException, InvalidPasswordFormatException;

    public Resposta listarRecursos();

    public Resposta consultarRecurso(String id) throws NullEmptyFieldException, ResourceNotFoundException;

}
