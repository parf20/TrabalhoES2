import java.util.ArrayList;

public class Resposta {

    int codigo;
    String erro="";
    ArrayList<Utilizador> utilizadoresDevolvidos = new ArrayList<>();
    ArrayList<Recurso> recursosDevolvidos = new ArrayList<>();

    //respostas

    //crirar utilizador que nao existia antes
    public Resposta criarUtilizadorSucesso() {
        Resposta resposta = new Resposta();
        resposta.setCodigo(201);
        return resposta;
    }

    //criar utilizador ja existente
    public Resposta criarUtilizadorExistente() {
        Resposta resposta = new Resposta();
        resposta.setCodigo(409);
        resposta.setErro("Utilizador já existente");
        return resposta;
    }

    public Resposta criarUtilizadorEmailFormatoInvalido(){
        Resposta resposta = new Resposta();
        resposta.setCodigo(400);
        resposta.setErro("Email com formato inválido");
        return resposta;
    }

    //criar utilizador nulo
    public Resposta criarUtilizadorNull() {
        Resposta resposta = new Resposta();
        resposta.setCodigo(204);
        resposta.setErro("Utilizador nulo");
        return resposta;
    }

    //criar utilizador email vazio ou nulo
    public Resposta criarUtilizadorEmailVazioNulo() {
        Resposta resposta = new Resposta();
        resposta.setCodigo(204);
        resposta.setErro("Email vazio ou nulo");
        return resposta;
    }

    //consultar dados utilizador existente
    public Resposta consultarDadosUtilizadorExistente(Utilizador utilizador) {
        Resposta resposta = new Resposta();
        resposta.setCodigo(200);
        ArrayList<Utilizador> utilizadorDevolvido = new ArrayList<>();
        utilizadorDevolvido.add(utilizador);
        resposta.setUtilizadoresDevolvidos(utilizadorDevolvido);
        return resposta;
    }

    //consultar dados utilizador inexistente
    public Resposta consultarDadosUtilizadorInexistente() {
        Resposta resposta = new Resposta();
        resposta.setCodigo(404);
        resposta.setErro("Utilizador não encontrado");
        return resposta;
    }

    //consultar dados id nulo ou inexistente
    public Resposta consultarDadosUtilizadorIdVazioNulo() {
        Resposta resposta = new Resposta();
        resposta.setCodigo(204);
        resposta.setErro("Id do utilizador vazio ou nulo");
        return resposta;
    }

    //listagem de utilizadores com sucesso
    public Resposta listarUtilizadoresSucesso(ArrayList<Utilizador> utilizadoresDevolvidos) {
        Resposta resposta = new Resposta();
        resposta.setCodigo(200);
        resposta.setUtilizadoresDevolvidos(utilizadoresDevolvidos);
        return resposta;
    }

    //utilizador registado com sucesso
    public Resposta registarUtilizadorSucesso() {
        Resposta resposta = new Resposta();
        resposta.setCodigo(200);
        return resposta;
    }

    //utilizador ja esta registado
    public Resposta registarUtilizadorJaRegistado() {
        Resposta resposta = new Resposta();
        resposta.setCodigo(409);
        resposta.setErro("Utilizador já registado");
        return resposta;
    }

    //utilizador nao registado porque nao foi criado
    public Resposta registarUtilizadorNaoCriado() {
        Resposta resposta = new Resposta();
        resposta.setCodigo(400);
        resposta.setErro("Utilizador não existente");
        return resposta;
    }

    //utilizador nao registado por campos vazios ou nulos
    public Resposta registarUtilizadorCredenciaisVazias() {
        Resposta resposta = new Resposta();
        resposta.setCodigo(204);
        resposta.setErro("Email ou palavra-passe vazios ou nulos");
        return resposta;
    }

    //utilizador autenticado com sucesso
    public Resposta autenticarUtilizadorSucesso() {
        Resposta resposta = new Resposta();
        resposta.setCodigo(200);
        return resposta;
    }

    //utilizador nao autenticado por credenciais invalidas
    public Resposta autenticarUtilizadorCredenciaisInvalidas() {
        Resposta resposta = new Resposta();
        resposta.setCodigo(400);
        resposta.setErro("Utilizador não encontrado ou corpo do pedido sem combinação campos de e-mail e/ou password");
        return resposta;
    }

    //utilizador nao autenticado por campos vazios ou nulos
    public Resposta autenticarUtilizadorCredenciaisVazias() {
        Resposta resposta = new Resposta();
        resposta.setCodigo(204);
        resposta.setErro("Email ou palavra-passe vazios ou nulos");
        return resposta;
    }



    //listagem de recursos com sucesso
    public Resposta listarRecursosSucesso(ArrayList<Recurso> recursosDevolvidos) {
        Resposta resposta = new Resposta();
        resposta.setCodigo(200);
        resposta.setRecursosDevolvidos(recursosDevolvidos);
        return resposta;
    }

    //consultar recurso existente
    public Resposta consultarRecursoExistente(Recurso recurso) {
        Resposta resposta = new Resposta();
        resposta.setCodigo(200);
        ArrayList<Recurso> recursoDevolvido = new ArrayList<>();
        recursoDevolvido.add(recurso);
        resposta.setRecursosDevolvidos(recursoDevolvido);
        return resposta;
    }

    //consultar recurso inexistente
    public Resposta consultarRecursoInexistente() {
        Resposta resposta = new Resposta();
        resposta.setCodigo(404);
        resposta.setErro("Recurso não encontrado");
        return resposta;
    }

    //consultar dados id nulo ou inexistente
    public Resposta consultarRecursoIdVazioNulo() {
        Resposta resposta = new Resposta();
        resposta.setCodigo(204);
        resposta.setErro("Id do recurso vazio ou nulo");
        return resposta;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
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
