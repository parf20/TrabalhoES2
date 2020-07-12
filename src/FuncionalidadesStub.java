import java.util.ArrayList;
import java.util.HashMap;

public class FuncionalidadesStub implements FuncionalidadesInferface {

    private ArrayList<Utilizador> utilizadores = new ArrayList<>();
    private ArrayList<Recurso> recursos = new ArrayList<>();

    private HashMap<String, String> credenciais = new HashMap<>() {{
        put("asdzxcqwsadertfgvbfc@reqres.in", "passwordtest12345678");
        put("qwerty@reqres.in", "123456");
        put("eve.holt@reqres.in", "cityslicka");
    }};


    FuncionalidadesStub() {
        utilizadores.add(new Utilizador("1", "asdzxcqwsadertfgvbfc@reqres.in", "John", "Doe", "regerger.jpg"));
        utilizadores.add(new Utilizador("2", "qwerty@reqres.in", "Lorem", "Ipsum", "regerger.jpg"));
        utilizadores.add(new Utilizador("3", "qwertu@reqres.in", "Lindsay", "Ferguson", "regerger.jpg"));
        utilizadores.add(new Utilizador("4", "asdxcqwsadertfgvbfce@reqres.in", "Tobias", "Funke", "regerger.jpg"));
        utilizadores.add(new Utilizador("5", "byron.fields@reqres.in", "Byron", "Fields", "regerger.jpg"));
        utilizadores.add(new Utilizador("6", "george.edwards@reqres.in", "George", "Edwards", "regerger.jpg"));
        utilizadores.add(new Utilizador("7", "rachel.howell@reqres.in", "Rachel", "Howell", "regerger.jpg"));
        utilizadores.add(new Utilizador("8", "george.bluth@reqres.in", "George", "Bluth", "regerger.jpg"));
        utilizadores.add(new Utilizador("9", "emma.wong@reqres.in", "Emma", "Wong", "regerger.jpg"));
        utilizadores.add(new Utilizador("10", "janet.weaver@reqres.in", "Janet", "weaver", "regerger.jpg"));
        utilizadores.add(new Utilizador("11", "jeve.holt@reqres.in", "Jane", "Holt", "regerger.jpg"));
        utilizadores.add(new Utilizador("12", "eve.holt@reqres.in", "Eve", "Holt", "regerger.jpg"));


        recursos.add(new Recurso("1", "cerulean", "2000", "#98B2D1", "15-4020"));
        recursos.add(new Recurso("2", "uchsia rose", "2001", "#C74375", "17-2031"));
        recursos.add(new Recurso("3", "true red", "2002", "#BF1932", "19-1664"));
        recursos.add(new Recurso("4", "aqua sky", "2003", "#98B2D1", "15-4020"));
        recursos.add(new Recurso("5", "tigerlily", "2004", "#E2583E", "15-4020"));
        recursos.add(new Recurso("6", "blue turquoise", "2005", "#53B0AE", "15-4020"));
        recursos.add(new Recurso("7", "sand dollar", "2006", "#DECDBE", "15-4020"));
        recursos.add(new Recurso("8", "chili pepper", "2007", "#5A5B9F", "15-4020"));
        recursos.add(new Recurso("9", "blue iris", "2008", "#F0C05A", "15-4020"));
        recursos.add(new Recurso("10", "mimosa", "2009", "#45B5AA", "15-4020"));
        recursos.add(new Recurso("11", "turquoise", "2010", "#D94F70", "15-4020"));
        recursos.add(new Recurso("12", "honeysuckle", "2011", "#98B2D1", "18-2120"));


    }

    @Override
    public Resposta criarUtilizador(Utilizador utilizador) throws NullEmptyFieldException, InvalidEmailFormatException, UserExistingException {

        if (utilizador.getEmail() == null || utilizador.getEmail().isEmpty())
            throw new NullEmptyFieldException();

        if (!utilizador.getEmail().contains("@") || !utilizador.getEmail().contains("."))
            throw new InvalidEmailFormatException();

        if (!(utilizador.getEmail().length() >= 8 && utilizador.getEmail().length() <= 30))
            throw new InvalidEmailFormatException();

        for (Utilizador utilizador1 : utilizadores) {
            if (utilizador1.getEmail().equals(utilizador.getEmail()))
                throw new UserExistingException();
        }
        return new Resposta().criarUtilizadorSucesso();

    }

    @Override
    public Resposta registarUtilizador(String email, String password) throws NullEmptyFieldException, UserNotFoundException, UserExistingException, InvalidEmailFormatException, InvalidPasswordFormatException {

        if (email == null || password == null)
            throw new NullEmptyFieldException();

        if (email.isEmpty() || password.isEmpty())
            throw new NullEmptyFieldException();

        if (!email.contains("@") || !email.contains("."))
            throw new InvalidEmailFormatException();

        if (!(email.length() >= 8 && email.length() <= 30))
            throw new InvalidEmailFormatException();

        if (!(password.length() >= 6 && password.length() <= 20))
            throw new InvalidPasswordFormatException();

        boolean existe = false;
        for (Utilizador utilizador : utilizadores) {
            if (utilizador.getEmail().equals(email)) {
                existe = true;
                break;
            }
        }
        if (!existe)
            throw new UserNotFoundException();

        if (credenciais.containsKey(email))
            throw new UserExistingException();
        else {
            credenciais.put(email, password);
            return new Resposta().registarUtilizadorSucesso();
        }

    }

    @Override
    public Resposta autenticarUtilizador(String email, String password) throws NullEmptyFieldException, InvalidCredentialsException, InvalidEmailFormatException, InvalidPasswordFormatException {

        if (email == null || password == null)
            throw new NullEmptyFieldException();

        if (email.isEmpty() || password.isEmpty())
            throw new NullEmptyFieldException();

        if (!email.contains("@") || !email.contains("."))
            throw new InvalidEmailFormatException();

        if (!(email.length() >= 8 && email.length() <= 30))
            throw new InvalidEmailFormatException();

        if (!(password.length() >= 6 && password.length() <= 20))
            throw new InvalidPasswordFormatException();

        if (credenciais.containsKey(email) && credenciais.get(email).equals(password)) {
            return new Resposta().autenticarUtilizadorSucesso();
        }

        throw new InvalidCredentialsException();
    }


    @Override
    public Resposta consultarDadosUtilizador(String id) throws NullEmptyFieldException, UserNotFoundException {

        if (id == null || id.isEmpty())
            throw new NullEmptyFieldException();

        for (Utilizador utilizador : utilizadores) {
            if (utilizador.getId().equals(id))
                return new Resposta().consultarDadosUtilizadorExistente(utilizador);
        }
        throw new UserNotFoundException();
    }

    @Override
    public Resposta listarUtilizadores() {
        return new Resposta().listarUtilizadoresSucesso(utilizadores);
    }

    @Override
    public Resposta listarRecursos() {
        return new Resposta().listarRecursosSucesso(recursos);
    }

    @Override
    public Resposta consultarRecurso(String id) throws NullEmptyFieldException, ResourceNotFoundException {
        if (id == null || id.isEmpty())
            throw new NullEmptyFieldException();

        for (Recurso recurso : recursos) {
            if (recurso.getId().equals(id))
                return new Resposta().consultarRecursoExistente(recurso);
        }
        throw new ResourceNotFoundException();
    }
}
