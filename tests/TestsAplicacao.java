import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsAplicacao {


    //testes ao login
    @Test
    public void testAutenticacaoSucesso() throws IOException {
        assertEquals(200, Funcoes.autenticarUtilizador("eve.holt@reqres.in", "cityslicka").getCodigo());
    }

    @Test
    public void testAutenticacaoCredenciaisInvalidas() throws IOException {
        assertEquals(400, Funcoes.autenticarUtilizador("test@mail.com", "egwegwgew").getCodigo());
    }

    @Test
    public void testAutenticacaoEmailNull() throws IOException {
        assertEquals(204, Funcoes.autenticarUtilizador(null, "rereher").getCodigo());
    }

    @Test
    public void testAutenticacaoPasswordNull() throws IOException {
        assertEquals(204, Funcoes.autenticarUtilizador("test@mail.com", null).getCodigo());
    }

    @Test
    public void testAutenticacaoEmailPasswordNull() throws IOException {
        assertEquals(204, Funcoes.autenticarUtilizador(null, null).getCodigo());
    }

    @Test
    public void testAutenticacaoEmailVazio() throws IOException {
        assertEquals(204, Funcoes.autenticarUtilizador("", "ergererheh").getCodigo());
    }

    @Test
    public void testAutenticacaoPasswordVazia() throws IOException {
        assertEquals(204, Funcoes.autenticarUtilizador("test@mail.com", "").getCodigo());
    }

    @Test
    public void testAutenticacaoEmailPasswordVazios() throws IOException {
        assertEquals(204, Funcoes.autenticarUtilizador("", "").getCodigo());
    }


    //testes ao registo
    @Test
    public void testRegistoSucesso() throws IOException {
        assertEquals(200, Funcoes.registarUtilizador("eve.holt@reqres.in", "pistol").getCodigo());
    }

    @Test
    public void testRegistoUtilizadorNaoCriado() throws IOException {
        assertEquals(400, Funcoes.registarUtilizador("test@mail.com", "test").getCodigo());
    }

    @Test
    public void testRegistoEmailNull() throws IOException {
        assertEquals(204, Funcoes.registarUtilizador(null, "test").getCodigo());
    }

    @Test
    public void testRegistoPasswordNull() throws IOException {
        assertEquals(204, Funcoes.registarUtilizador("test@mail.com", null).getCodigo());
    }

    @Test
    public void testRegistoEmailPasswordNull() throws IOException {
        assertEquals(204, Funcoes.registarUtilizador(null, null).getCodigo());
    }

    @Test
    public void testRegistoEmailVazio() throws IOException {
        assertEquals(204, Funcoes.registarUtilizador("", "test").getCodigo());
    }

    @Test
    public void testRegistoPasswordVazia() throws IOException {
        assertEquals(204, Funcoes.registarUtilizador("test@mail.com", "").getCodigo());
    }

    @Test
    public void testRegistoEmailPasswordVazios() throws IOException {
        assertEquals(204, Funcoes.registarUtilizador("", "").getCodigo());
    }


    //testes ao criar utilizador
    @Test
    public void testCriarUtilizadorSucesso() throws IOException {
        assertEquals(201, Funcoes.criarUtilizador(new Utilizador("13", "test@mail.com", "New", "Test", "eergrgegregreggergregre.jpg")).getCodigo());
    }

    @Test
    public void testCriRUtilizadorEmailFormatoInvalido() throws IOException {
        assertEquals(400, Funcoes.criarUtilizador(new Utilizador("13", "test.com", "New", "Test", "eergrgegregreggergregre.jpg")).getCodigo());
    }

    @Test
    public void testCriarUtilizadorNull() throws IOException {
        assertEquals(204, Funcoes.criarUtilizador(null).getCodigo());
    }

    @Test
    public void testCriarUtilizadorEmailVazio() throws IOException {
        assertEquals(204, Funcoes.criarUtilizador(new Utilizador("13", "", "New", "Test", "eergrgegregreggergregre.jpg")).getCodigo());
    }

    @Test
    public void testCriarUtilizadorEmailNull() throws IOException {
        assertEquals(204, Funcoes.criarUtilizador(new Utilizador("13", null, "New", "Test", "eergrgegregreggergregre.jpg")).getCodigo());
    }


    //testes listar utilizadores
    @Test
    public void testListarUtilizadoresSucesso() throws IOException, JSONException {
        assertEquals(200, Funcoes.listarUtilizadores().getCodigo());
    }


    //testes consultar utilizador
    @Test
    public void testConsultarUtilizadorSucesso() throws IOException, JSONException {
        assertEquals(200, Funcoes.consultarDadosUtilizador("1").getCodigo());
        assertEquals(200, Funcoes.consultarDadosUtilizador("12").getCodigo());
    }

    @Test
    public void testConsultarUtilizadorInexistente() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(404, funcionalidadesStub.consultarDadosUtilizador("0").getCodigo());
        assertEquals(404, funcionalidadesStub.consultarDadosUtilizador("13").getCodigo());
    }

    @Test
    public void testConsultarUtilizadorIdVazio() throws IOException, JSONException {
        assertEquals(204, Funcoes.consultarDadosUtilizador("").getCodigo());
    }

    @Test
    public void testConsultarUtilizadorIdNull() throws IOException, JSONException {
        assertEquals(204, Funcoes.consultarDadosUtilizador(null).getCodigo());
    }


    //testes consultar recurso
    @Test
    public void testConsultarRecursoSucesso() throws IOException, JSONException {
        assertEquals(200, Funcoes.consultarRecurso("1").getCodigo());
        assertEquals(200, Funcoes.consultarRecurso("12").getCodigo());
    }

    @Test
    public void testConsultarRecursoInexistente() throws IOException, JSONException {
        assertEquals(404, Funcoes.consultarRecurso("0").getCodigo());
        assertEquals(404, Funcoes.consultarRecurso("13").getCodigo());
    }

    @Test
    public void testConsultarRecursoIdVazio() throws IOException, JSONException {
        assertEquals(204, Funcoes.consultarRecurso("").getCodigo());
    }

    @Test
    public void testConsulultarRecursoIdNull() throws IOException, JSONException {
        assertEquals(204, Funcoes.consultarRecurso(null).getCodigo());
    }

}
