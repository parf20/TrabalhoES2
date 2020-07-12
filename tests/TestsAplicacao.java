import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class TestsAplicacao {


    //testes ao login
    @Test
    public void testAutenticacaoSucesso() throws IOException, InvalidCredentialsException, NullEmptyFieldException {
        assertDoesNotThrow(() -> {
            GestorUtilizadores.getInstance().autenticarUtilizador("eve.holt@reqres.in", "cityslicka");
        });
    }

    @Test
    public void testAutenticacaoCredenciaisInvalidas() throws IOException {
        assertThrows(InvalidCredentialsException.class, () -> {
            GestorUtilizadores.getInstance().autenticarUtilizador("test@mail.com", "egwegwgew");
        });
    }

    @Test
    public void testAutenticacaoEmailFormatoInvalido() {
        assertThrows(InvalidEmailFormatException.class, () -> {
            GestorUtilizadores.getInstance().autenticarUtilizador("testmail.com", "cityslicka");
        });
    }

    @Test
    public void testAutenticacaoEmailLimiteInferior() {
        assertThrows(InvalidEmailFormatException.class, () -> {
            GestorUtilizadores.getInstance().autenticarUtilizador("a@es.in", "cityslicka");
        });
    }

    @Test
    public void testAutenticacaoEmailLimiteSuperior() {
        assertThrows(InvalidEmailFormatException.class, () -> {
            GestorUtilizadores.getInstance().autenticarUtilizador("asdzxcqwsadertfgvbfcd@reqres.in", "cityslicka");
        });
    }

    @Test
    public void testAutenticacaoEmailLimiteMinimo() throws NullEmptyFieldException, InvalidEmailFormatException, InvalidCredentialsException, InvalidPasswordFormatException {
        assertDoesNotThrow(() -> {
            GestorUtilizadores.getInstance().autenticarUtilizador("qwerty@reqres.in", "123456");
        });
    }

    @Test
    public void testAutenticacaoEmailLimiteMaximo() throws NullEmptyFieldException, InvalidEmailFormatException, InvalidCredentialsException, InvalidPasswordFormatException {
        assertDoesNotThrow(() -> {
            GestorUtilizadores.getInstance().autenticarUtilizador("asdzxcqwsadertfgvbfc@reqres.in", "passwordtest12345678");
        });
    }

    @Test
    public void testAutenticacaoPasswordLimiteInferior() throws NullEmptyFieldException, InvalidEmailFormatException, InvalidCredentialsException, InvalidPasswordFormatException {
        assertThrows(InvalidPasswordFormatException.class, () -> {
            GestorUtilizadores.getInstance().autenticarUtilizador("eve.holt@reqres.in", "12345");
        });
    }

    @Test
    public void testAutenticacaoPasswordLimiteSuperior() throws NullEmptyFieldException, InvalidEmailFormatException, InvalidCredentialsException, InvalidPasswordFormatException {
        assertThrows(InvalidPasswordFormatException.class, () -> {
            GestorUtilizadores.getInstance().autenticarUtilizador("eve.holt@reqres.in", "passwordtest123456789");
        });
    }

    @Test
    public void testAutenticacaoPasswordLimiteMinimo() throws NullEmptyFieldException, InvalidEmailFormatException, InvalidCredentialsException, InvalidPasswordFormatException {
        assertDoesNotThrow(() -> {
            GestorUtilizadores.getInstance().autenticarUtilizador("qwerty@reqres.in", "123456");
        });
    }

    @Test
    public void testAutenticacaoPasswordLimiteMaximo() throws NullEmptyFieldException, InvalidEmailFormatException, InvalidCredentialsException, InvalidPasswordFormatException {
        assertDoesNotThrow(() -> {
            GestorUtilizadores.getInstance().autenticarUtilizador("asdzxcqwsadertfgvbfc@reqres.in", "passwordtest12345678");
        });
    }

    @Test
    public void testAutenticacaoEmailNull() throws IOException, InvalidCredentialsException, NullEmptyFieldException {
        assertThrows(NullEmptyFieldException.class, () -> {
            GestorUtilizadores.getInstance().autenticarUtilizador(null, "cityslicka");
        });
    }

    @Test
    public void testAutenticacaoPasswordNull() throws IOException, InvalidCredentialsException, NullEmptyFieldException {
        assertThrows(NullEmptyFieldException.class, () -> {
            GestorUtilizadores.getInstance().autenticarUtilizador("eve.holt@reqres.in", null);
        });
    }

    @Test
    public void testAutenticacaoEmailPasswordNull() throws IOException, InvalidCredentialsException, NullEmptyFieldException {
        assertThrows(NullEmptyFieldException.class, () -> {
            GestorUtilizadores.getInstance().autenticarUtilizador(null, null);
        });
    }

    @Test
    public void testAutenticacaoEmailVazio() throws IOException, InvalidCredentialsException, NullEmptyFieldException {
        assertThrows(NullEmptyFieldException.class, () -> {
            GestorUtilizadores.getInstance().autenticarUtilizador("", "cityslicka");
        });
    }

    @Test
    public void testAutenticacaoPasswordVazia() throws IOException, InvalidCredentialsException, NullEmptyFieldException {
        assertThrows(NullEmptyFieldException.class, () -> {
            GestorUtilizadores.getInstance().autenticarUtilizador("eve.holt@reqres.in", "");
        });
    }

    @Test
    public void testAutenticacaoEmailPasswordVazios() throws IOException, InvalidCredentialsException, NullEmptyFieldException {
        assertThrows(NullEmptyFieldException.class, () -> {
            GestorUtilizadores.getInstance().autenticarUtilizador("", "");
        });
    }


    //testes ao registo
    @Test
    public void testRegistoSucesso() throws IOException, UserNotFoundException, NullEmptyFieldException {
        assertDoesNotThrow(() -> {
            GestorUtilizadores.getInstance().registarUtilizador("george.bluth@reqres.in", "cityslicka");
        });
    }

    @Test
    public void testRegistoUtilizadorNaoCriado() throws IOException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(UserNotFoundException.class, () -> {
            GestorUtilizadores.getInstance().registarUtilizador("teste@mail.com", "cityslicka");
        });
    }

    @Test
    public void testRegistoUtilizadorJaRegistado() throws IOException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(UserExistingException.class, () -> {
            GestorUtilizadores.getInstance().registarUtilizador("eve.holt@reqres.in", "cityslicka");
        });
    }

    @Test
    public void testRegistoEmailFormatoInvalido() throws IOException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(InvalidEmailFormatException.class, () -> {
            GestorUtilizadores.getInstance().registarUtilizador("testemail.com", "cityslicka");
        });
    }

    @Test
    public void testRegistoEmailLimiteInferior() throws IOException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(InvalidEmailFormatException.class, () -> {
            GestorUtilizadores.getInstance().registarUtilizador("b@es.in", "cityslicka");
        });
    }

    @Test
    public void testRegistoEmailLimiteSuperior() throws IOException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(InvalidEmailFormatException.class, () -> {
            GestorUtilizadores.getInstance().registarUtilizador("asdzxcqwsadertfgvbfce@reqres.in", "cityslicka");
        });
    }

    @Test
    public void testRegistoEmailLimiteMinimo() throws IOException, UserNotFoundException, NullEmptyFieldException {
        assertDoesNotThrow(() -> {
            GestorUtilizadores.getInstance().registarUtilizador("qwertu@reqres.in", "cityslicka");
        });
    }

    @Test
    public void testRegistoEmailLimiteMaximo() throws IOException, UserNotFoundException, NullEmptyFieldException {
        assertDoesNotThrow(() -> {
            GestorUtilizadores.getInstance().registarUtilizador("asdxcqwsadertfgvbfce@reqres.in", "cityslicka");
        });
    }

    @Test
    public void testRegistoPasswordLimiteInferior() throws IOException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(InvalidPasswordFormatException.class, () -> {
            GestorUtilizadores.getInstance().registarUtilizador("george.edwards@reqres.in", "12345");
        });
    }

    @Test
    public void testRegistoPasswordLimiteSuperior() throws IOException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(InvalidPasswordFormatException.class, () -> {
            GestorUtilizadores.getInstance().registarUtilizador("george.edwards@reqres.in", "passwordtest123456789");
        });
    }

    @Test
    public void testRegistoPasswordLimiteMinimo() throws IOException, UserNotFoundException, NullEmptyFieldException {
        assertDoesNotThrow(() -> {
            GestorUtilizadores.getInstance().registarUtilizador("rachel.howell@reqres.in", "123456");
        });
    }

    @Test
    public void testRegistoPasswordLimiteMaximo() throws IOException, UserNotFoundException, NullEmptyFieldException {
        assertDoesNotThrow(() -> {
            GestorUtilizadores.getInstance().registarUtilizador("george.edwards@reqres.in", "passwordtest12345678");
        });
    }

    @Test
    public void testRegistoEmailNull() throws IOException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(NullEmptyFieldException.class, () -> {
            GestorUtilizadores.getInstance().registarUtilizador(null, "cityslicka");
        });
    }

    @Test
    public void testRegistoPasswordNull() throws IOException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(NullEmptyFieldException.class, () -> {
            GestorUtilizadores.getInstance().registarUtilizador("george.edwards@reqres.in", null);
        });
    }

    @Test
    public void testRegistoEmailPasswordNull() throws IOException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(NullEmptyFieldException.class, () -> {
            GestorUtilizadores.getInstance().registarUtilizador(null, null);
        });
    }

    @Test
    public void testRegistoEmailVazio() throws IOException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(NullEmptyFieldException.class, () -> {
            GestorUtilizadores.getInstance().registarUtilizador("", "cityslicka");
        });
    }

    @Test
    public void testRegistoPasswordVazia() throws IOException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(NullEmptyFieldException.class, () -> {
            GestorUtilizadores.getInstance().registarUtilizador("george.edwards@reqres.in", "");
        });
    }

    @Test
    public void testRegistoEmailPasswordVazios() throws IOException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(NullEmptyFieldException.class, () -> {
            GestorUtilizadores.getInstance().registarUtilizador("", "");
        });
    }


    //testes ao criar utilizador
    @Test
    public void testCriarUtilizadorSucesso() throws IOException, InvalidEmailFormatException, NullEmptyFieldException {
        assertDoesNotThrow(() -> {
            GestorUtilizadores.getInstance().criarUtilizador("13", "test@mail.com", "New", "Test", "eergrgegregreggergregre.jpg");
        });
    }

    @Test
    public void testCriarUtilizadorJaExistente() throws IOException, InvalidEmailFormatException, NullEmptyFieldException {
        assertThrows(UserExistingException.class, () -> {
            GestorUtilizadores.getInstance().criarUtilizador("13", "eve.holt@reqres.in", "New", "Test", "eergrgegregreggergregre.jpg");
        });
    }


    @Test
    public void testCrirUtilizadorEmailFormatoInvalido() throws IOException, InvalidEmailFormatException, NullEmptyFieldException {
        assertThrows(InvalidEmailFormatException.class, () -> {
            GestorUtilizadores.getInstance().criarUtilizador("13", "testmail.com", "New", "Test", "eergrgegregreggergregre.jpg");
        });
    }

    @Test
    public void testCriarUtilizadorEmailLimiteInferior() throws IOException, InvalidEmailFormatException, NullEmptyFieldException {
        assertThrows(InvalidEmailFormatException.class, () -> {
            GestorUtilizadores.getInstance().criarUtilizador("13", "b@es.in", "New", "Test", "eergrgegregreggergregre.jpg");
        });
    }

    @Test
    public void testCriarUtilizadorEmailLimiteSuperior() throws IOException, InvalidEmailFormatException, NullEmptyFieldException {
        assertThrows(InvalidEmailFormatException.class, () -> {
            GestorUtilizadores.getInstance().criarUtilizador("13", "asdzxcqwsadertfgvbfce@reqres.in", "New", "Test", "eergrgegregreggergregre.jpg");
        });
    }

    @Test
    public void testCriarUtilizadorEmailLimiteMinimo() throws IOException, InvalidEmailFormatException, NullEmptyFieldException {
        assertDoesNotThrow(() -> {
            GestorUtilizadores.getInstance().criarUtilizador("13", "ab@es.in", "New", "Test", "eergrgegregreggergregre.jpg");
        });
    }

    @Test
    public void testCriarUtilizadorEmailLimiteMaximo() throws IOException, InvalidEmailFormatException, NullEmptyFieldException {
        assertDoesNotThrow(() -> {
            GestorUtilizadores.getInstance().criarUtilizador("13", "asdzxcqwsadertgvbfce@reqres.in", "New", "Test", "eergrgegregreggergregre.jpg");
        });
    }

    @Test
    public void testCriarUtilizadorNull() throws IOException, InvalidEmailFormatException, NullEmptyFieldException {
        assertThrows(NullEmptyFieldException.class, () -> {
            GestorUtilizadores.getInstance().criarUtilizador("13", null, "New", "Test", "eergrgegregreggergregre.jpg");
        });
    }

    @Test
    public void testCriarUtilizadorEmailVazio() throws IOException, InvalidEmailFormatException, NullEmptyFieldException {
        assertThrows(NullEmptyFieldException.class, () -> {
            GestorUtilizadores.getInstance().criarUtilizador("13", "", "New", "Test", "eergrgegregreggergregre.jpg");
        });
    }

    @Test
    public void testCriarUtilizadorEmailNull() throws IOException, InvalidEmailFormatException, NullEmptyFieldException {
        assertThrows(NullEmptyFieldException.class, () -> {
            GestorUtilizadores.getInstance().criarUtilizador("13", null, "New", "Test", "eergrgegregreggergregre.jpg");
        });
    }









    //testes consultar utilizador
    @Test
    public void testConsultarUtilizadorLimiteMaximo() throws IOException, JSONException, UserNotFoundException, NullEmptyFieldException {
       assertDoesNotThrow(()->{
           GestorUtilizadores.getInstance().consultarDadosUtilizador("12");
       });
    }

    @Test
    public void testConsultarUtilizadorLimiteMinimo() throws IOException, JSONException, UserNotFoundException, NullEmptyFieldException {
        assertDoesNotThrow(()->{
            GestorUtilizadores.getInstance().consultarDadosUtilizador("1");
        });
    }

    @Test
    public void testConsultarUtilizadorLimiteSuperior() throws IOException, JSONException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(UserNotFoundException.class,()->{
            GestorUtilizadores.getInstance().consultarDadosUtilizador("13");
        });
    }

    @Test
    public void testConsultarUtilizadoLimiteInferior() throws IOException, JSONException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(UserNotFoundException.class,()->{
            GestorUtilizadores.getInstance().consultarDadosUtilizador("0");
        });
    }

    @Test
    public void testConsultarUtilizadorIdVazio() throws IOException, JSONException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(NullEmptyFieldException.class,()->{
            GestorUtilizadores.getInstance().consultarDadosUtilizador("");
        });
    }

    @Test
    public void testConsultarUtilizadorIdNull() throws IOException, JSONException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(NullEmptyFieldException.class,()->{
            GestorUtilizadores.getInstance().consultarDadosUtilizador(null);
        });
    }








    //testes listar utilizadores
    @Test
    public void testListarUtilizadoresSucesso() throws IOException, JSONException {
        assertDoesNotThrow(()->{
            GestorUtilizadores.getInstance().listarUtilizadores();
        });
    }



    //testes listar recursos
    @Test
    public void testListarRecursosSucesso() throws IOException, JSONException {
        assertDoesNotThrow(()->{
            GestorUtilizadores.getInstance().listarUtilizadores();
        });
    }




    //testes consultar recurso
    @Test
    public void testConsultarRecursoLimiteMaximo() throws IOException, JSONException, UserNotFoundException, NullEmptyFieldException {
        assertDoesNotThrow(()->{
            GestorUtilizadores.getInstance().consultarRecurso("12");
        });
    }

    @Test
    public void testConsultarRecursoLimiteMinimo() throws IOException, JSONException, UserNotFoundException, NullEmptyFieldException {
        assertDoesNotThrow(()->{
            GestorUtilizadores.getInstance().consultarRecurso("1");
        });
    }

    @Test
    public void testConsultarRecursoLimiteSuperior() throws IOException, JSONException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(ResourceNotFoundException.class,()->{
            GestorUtilizadores.getInstance().consultarRecurso("13");
        });
    }

    @Test
    public void testConsultarRecursoLimiteInferior() throws IOException, JSONException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(ResourceNotFoundException.class,()->{
            GestorUtilizadores.getInstance().consultarRecurso("0");
        });
    }

    @Test
    public void testConsultarRecursoIdVazio() throws IOException, JSONException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(NullEmptyFieldException.class,()->{
            GestorUtilizadores.getInstance().consultarRecurso("");
        });
    }

    @Test
    public void testConsultarRecursoIdNull() throws IOException, JSONException, UserNotFoundException, NullEmptyFieldException {
        assertThrows(NullEmptyFieldException.class,()->{
            GestorUtilizadores.getInstance().consultarRecurso(null);
        });
    }


}
