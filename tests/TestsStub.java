import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestsStub {


    //testes ao login
    @Test
    public void testAutenticacaoSucesso() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(200, funcionalidadesStub.autenticarUtilizador("admin@mail.com", "admin").getCodigo());
    }

    @Test
    public void testAutenticacaoCredenciaisInvalidas() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(400, funcionalidadesStub.autenticarUtilizador("admin@mail.com", "ireggreger").getCodigo());
    }

    @Test
    public void testAutenticacaoEmailNull() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(204, funcionalidadesStub.autenticarUtilizador(null, "admin").getCodigo());
    }

    @Test
    public void testAutenticacaoPasswordNull() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(204, funcionalidadesStub.autenticarUtilizador("admin@mail.com", null).getCodigo());
    }

    @Test
    public void testAutenticacaoEmailPasswordNull() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(204, funcionalidadesStub.autenticarUtilizador(null, null).getCodigo());
    }

    @Test
    public void testAutenticacaoEmailVazio() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(204, funcionalidadesStub.autenticarUtilizador("", "admin").getCodigo());
    }

    @Test
    public void testAutenticacaoPasswordVazia() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(204, funcionalidadesStub.autenticarUtilizador("admin@mail.com", "").getCodigo());
    }

    @Test
    public void testAutenticacaoEmailPasswordVazios() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(204, funcionalidadesStub.autenticarUtilizador("", "").getCodigo());
    }


    //testes ao registo
    @Test
    public void testRegistoSucesso() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(200, funcionalidadesStub.registarUtilizador("ruben@mail.com", "ruben").getCodigo());
    }

    @Test
    public void testRegistoUtilizadorNaoCriado() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(400, funcionalidadesStub.registarUtilizador("novo@mail.com", "novo").getCodigo());
    }

    @Test
    public void testRegistoUtilizadorJaRegistado() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(409, funcionalidadesStub.registarUtilizador("admin@mail.com", "admin").getCodigo());
    }

    @Test
    public void testRegistoEmailNull() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(204, funcionalidadesStub.registarUtilizador(null, "ruben").getCodigo());
    }

    @Test
    public void testRegistoPasswordNull() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(204, funcionalidadesStub.registarUtilizador("ruben@mail.com", null).getCodigo());
    }

    @Test
    public void testRegistoEmailPasswordNull() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(204, funcionalidadesStub.registarUtilizador(null, null).getCodigo());
    }

    @Test
    public void testRegistoEmailVazio() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(204, funcionalidadesStub.registarUtilizador("", "ruben").getCodigo());
    }

    @Test
    public void testRegistoPasswordVazia() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(204, funcionalidadesStub.registarUtilizador("ruben@mail.com", "").getCodigo());
    }

    @Test
    public void testRegistoEmailPasswordVazios() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(204, funcionalidadesStub.registarUtilizador("", "").getCodigo());
    }


    //testes ao criar utilizador
    @Test
    public void testCriarUtilizadorSucesso() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(201, funcionalidadesStub.criarUtilizador(new Utilizador("10", "novo@mail.com", "Novo", "Teste", "ewffewfewefw.jpg")).getCodigo());
    }

    @Test
    public void testCriarUtilizadorJaExistente() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(409, funcionalidadesStub.criarUtilizador(new Utilizador("10", "admin@mail.com", "Novo", "Teste", "ewffewfewefw.jpg")).getCodigo());
    }

    @Test
    public void testCriarUtilizadorFormatoInvalido() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(400, funcionalidadesStub.criarUtilizador(new Utilizador("10", "novomail.com", "Novo", "Teste", "ewffewfewefw.jpg")).getCodigo());
    }

    @Test
    public void testCriarUtilizadorNull() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(204, funcionalidadesStub.criarUtilizador(null).getCodigo());
    }

    @Test
    public void testCriarUtilizadorEmailVazio() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(204, funcionalidadesStub.criarUtilizador(new Utilizador("10", "", "Novo", "Teste", "ewffewfewefw.jpg")).getCodigo());
    }

    @Test
    public void testCriarUtilizadorEmailNull() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(204, funcionalidadesStub.criarUtilizador(new Utilizador("10", null, "Novo", "Teste", "ewffewfewefw.jpg")).getCodigo());
    }


    //testes listar utilizadores
    @Test
    public void testListarUtilizadoresSucesso(){
        FuncionalidadesStub funcionalidadesStub=new FuncionalidadesStub();
        assertEquals(200,funcionalidadesStub.listarUtilizadores().getCodigo());
    }


    //testes consultar utilizador
    @Test
    public void testConsultarUtilizadorSucesso() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(200, funcionalidadesStub.consultarDadosUtilizador("1").getCodigo());
        assertEquals(200, funcionalidadesStub.consultarDadosUtilizador("5").getCodigo());
    }

    @Test
    public void testConsultarUtilizadorInexistente(){
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(404, funcionalidadesStub.consultarDadosUtilizador("0").getCodigo());
        assertEquals(404, funcionalidadesStub.consultarDadosUtilizador("6").getCodigo());
    }

    @Test
    public void testConsultarUtilizadorIdVazio(){
        FuncionalidadesStub funcionalidadesStub=new FuncionalidadesStub();
        assertEquals(204,funcionalidadesStub.consultarDadosUtilizador("").getCodigo());
    }

    @Test
    public void testConsultarUtilizadorIdNull(){
        FuncionalidadesStub funcionalidadesStub=new FuncionalidadesStub();
        assertEquals(204,funcionalidadesStub.consultarDadosUtilizador(null).getCodigo());
    }



    //testes listar recursos
    @Test
    public void testListarRecursosSucesso(){
        FuncionalidadesStub funcionalidadesStub=new FuncionalidadesStub();
        assertEquals(200,funcionalidadesStub.listarRecursos().getCodigo());
    }


    //testes consultar recurso
    @Test
    public void testConsultarRecursoSucesso() {
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(200, funcionalidadesStub.consultarRecurso("1").getCodigo());
        assertEquals(200, funcionalidadesStub.consultarRecurso("4").getCodigo());
    }

    @Test
    public void testConsultarRecursoInexistente(){
        FuncionalidadesStub funcionalidadesStub = new FuncionalidadesStub();
        assertEquals(404, funcionalidadesStub.consultarRecurso("0").getCodigo());
        assertEquals(404, funcionalidadesStub.consultarRecurso("5").getCodigo());
    }

    @Test
    public void testConsultarRecursoIdVazio(){
        FuncionalidadesStub funcionalidadesStub=new FuncionalidadesStub();
        assertEquals(204,funcionalidadesStub.consultarRecurso("").getCodigo());
    }

    @Test
    public void testConsulultarRecursoIdNull(){
        FuncionalidadesStub funcionalidadesStub=new FuncionalidadesStub();
        assertEquals(204,funcionalidadesStub.consultarRecurso(null).getCodigo());
    }
}
