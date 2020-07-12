import java.util.ArrayList;

public class Resposta {

    String mensagem="";
    ArrayList<Utilizador> utilizadoresDevolvidos = new ArrayList<>();
    ArrayList<Recurso> recursosDevolvidos = new ArrayList<>();

    //respostas

    //crirar utilizador que nao existia antes
    public Resposta criarUtilizadorSucesso() {
        Resposta resposta = new Resposta();
        resposta.setMensagem("OK");
        return resposta;
    }


    //consultar dados utilizador existente
    public Resposta consultarDadosUtilizadorExistente(Utilizador utilizador) {
        Resposta resposta = new Resposta();
        resposta.setMensagem("OK");
        ArrayList<Utilizador> utilizadorDevolvido = new ArrayList<>();
        utilizadorDevolvido.add(utilizador);
        resposta.setUtilizadoresDevolvidos(utilizadorDevolvido);
        return resposta;
    }


    //listagem de utilizadores com sucesso
    public Resposta listarUtilizadoresSucesso(ArrayList<Utilizador> utilizadoresDevolvidos) {
        Resposta resposta = new Resposta();
        resposta.setMensagem("OK");
        resposta.setUtilizadoresDevolvidos(utilizadoresDevolvidos);
        return resposta;
    }

    //utilizador registado com sucesso
    public Resposta registarUtilizadorSucesso() {
        Resposta resposta = new Resposta();
        resposta.setMensagem("OK");
        return resposta;
    }


    //utilizador autenticado com sucesso
    public Resposta autenticarUtilizadorSucesso() {
        Resposta resposta = new Resposta();
        resposta.setMensagem("OK");
        return resposta;
    }


    //listagem de recursos com sucesso
    public Resposta listarRecursosSucesso(ArrayList<Recurso> recursosDevolvidos) {
        Resposta resposta = new Resposta();
        resposta.setMensagem("OK");
        resposta.setRecursosDevolvidos(recursosDevolvidos);
        return resposta;
    }

    //consultar recurso existente
    public Resposta consultarRecursoExistente(Recurso recurso) {
        Resposta resposta = new Resposta();
        resposta.setMensagem("OK");
        ArrayList<Recurso> recursoDevolvido = new ArrayList<>();
        recursoDevolvido.add(recurso);
        resposta.setRecursosDevolvidos(recursoDevolvido);
        return resposta;
    }


    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public ArrayList<Utilizador> getUtilizadoresDevolvidos() {
        return utilizadoresDevolvidos;
    }

    public void setUtilizadoresDevolvidos(ArrayList<Utilizador> utilizadoresDevolvidos) {
        this.utilizadoresDevolvidos = utilizadoresDevolvidos;
    }

    public ArrayList<Recurso> getRecursosDevolvidos() {
        return recursosDevolvidos;
    }

    public void setRecursosDevolvidos(ArrayList<Recurso> recursosDevolvidos) {
        this.recursosDevolvidos = recursosDevolvidos;
    }


}
