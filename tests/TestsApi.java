import org.junit.Test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsApi {


    //testes do login
    @Test
    public void testAutenticacaoSucesso() throws IOException {
        URL url = new URL("https://reqres.in/api/login/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "eve.holt@reqres.in");
        parameters.put("password", "cityslicka");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(200, status);
    }

    @Test
    public void testAutenticacaoCredenciaisInvalidas() throws IOException {
        URL url = new URL("https://reqres.in/api/login/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "teste@mail.com");
        parameters.put("password", "cityslicka");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(400, status);
    }

    @Test
    public void testAutenticacaoSemCampos() throws IOException {
        URL url = new URL("https://reqres.in/api/login/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        Map<String, String> parameters = new HashMap<>();

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(400, status);
    }

    @Test
    public void testAutenticacaoSemEmail() throws IOException {
        URL url = new URL("https://reqres.in/api/login/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("password", "eve.holt@reqres.in");


        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(400, status);
    }

    @Test
    public void testAutenticacaoSemPassword() throws IOException {
        URL url = new URL("https://reqres.in/api/login/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "eve.holt@reqres.in");


        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(400, status);
    }

    @Test
    public void testAutenticacaoCamposNomesInvalidos() throws IOException {
        URL url = new URL("https://reqres.in/api/login/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("emailx", "eve.holt@reqres.in");
        parameters.put("passwordx", "cityslicka");


        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(400, status);
    }

    @Test
    public void testAutenticacaoParametrosGrandes() throws IOException {
        URL url = new URL("https://reqres.in/api/login/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        Map<String, String> parameters = new HashMap<>();
        String email = "";
        for (int i = 0; i < 99999; i++)
            email+=("eve.holt@reqres.in");
        parameters.put("email", "eve.holt@reqres.in");

        String password = "";
        for (int i = 0; i < 99999; i++)
            password+=("cityslicka");
        parameters.put("job", password);

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(413, status);
    }



    //testes registo
    @Test
    public void testRegistoSucesso() throws IOException {
        URL url = new URL("https://reqres.in/api/register/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "eve.holt@reqres.in");
        parameters.put("password", "pistol");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(200, status);
    }

    @Test
    public void testRegistoEmailNaoRegistado() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email","teste@mail.com");
        parameters.put("password", "pistol");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(400, status);
    }

    @Test
    public void testRegistoSemCampos() throws IOException {
        URL url = new URL("https://reqres.in/api/register/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        Map<String, String> parameters = new HashMap<>();

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(400, status);
    }

    @Test
    public void testRegistoSemEmail() throws IOException {
        URL url = new URL("https://reqres.in/api/register/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("password", "eve.holt@reqres.in");


        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(400, status);
    }

    @Test
    public void testRegistoSemPassword() throws IOException {
        URL url = new URL("https://reqres.in/api/register/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "eve.holt@reqres.in");


        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(400, status);
    }

    @Test
    public void testRegistoCamposNomesInvalidos() throws IOException {
        URL url = new URL("https://reqres.in/api/register/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("emailx", "eve.holt@reqres.in");
        parameters.put("passwordx", "cityslicka");


        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(400, status);
    }

    @Test
    public void testRegistoParametrosGrandes() throws IOException {
        URL url = new URL("https://reqres.in/api/register/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        Map<String, String> parameters = new HashMap<>();
        String email = "";
        for (int i = 0; i < 99999; i++)
            email+=("eve.holt@reqres.in");
        parameters.put("email", "eve.holt@reqres.in");

        String password = "";
        for (int i = 0; i < 99999; i++)
            password+=("cityslicka");
        parameters.put("job", password);

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(413, status);
    }



    //testes criar utilizador
    @Test
    public void testCriarUtilizadorSucesso() throws IOException {
        URL url = new URL("https://reqres.in/api/users/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("name", "morpheus");
        parameters.put("job", "leader");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(201, status);
    }

    @Test
    public void testCriarUtilizadorParametrosGrandes() throws IOException {
        URL url = new URL("https://reqres.in/api/users/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        Map<String, String> parameters = new HashMap<>();
        String name = "";
        for (int i = 0; i < 99999; i++)
            name+=("morpheus");
        parameters.put("name", name);

        String job = "";
        for (int i = 0; i < 99999; i++)
            job+=("leader");
        parameters.put("job", job);

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(413, status);
    }


    //testes atualizar utilizador
    @Test
    public void testAtualizarUtilizadorSucesso() throws IOException {
        //funciona mesmo sem enviar o id
        URL url = new URL("https://reqres.in/api/users/1");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("name", "morpheus");
        parameters.put("job", "leader");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(200, status);
    }

    @Test
    public void testAtualizarUtilizadorParametrosGrandes() throws IOException {
        //funciona mesmo sem enviar o id
        URL url = new URL("https://reqres.in/api/users/1");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");

        Map<String, String> parameters = new HashMap<>();
        String name = "";
        for (int i = 0; i < 99999; i++)
            name+=("morpheus");
        parameters.put("name", name);

        String job = "";
        for (int i = 0; i < 99999; i++)
            job+=("leader");
        parameters.put("job", job);

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(413, status);
    }


    //testes apagar atualizador
    @Test
    public void testApagarUtilizadorSucesso() throws IOException {
        URL url = new URL("https://reqres.in/api/users/2");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(204, status);
    }

    @Test
    public void testApagarUtilizadorIdGrande() throws IOException {
        String id="";
        for(int i=0;i<10000;i++)
            id+="1";
        URL url = new URL("https://reqres.in/api/users/"+id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(414, status);
    }


    //testes consultar utilizador
    @Test
    public void testConsultarUtilizadorSucesso() throws IOException {
        URL url1 = new URL("https://reqres.in/api/users/1");
        HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();
        con1.setRequestMethod("GET");

        int status1 = con1.getResponseCode();
        con1.disconnect();

        URL url2 = new URL("https://reqres.in/api/users/12");
        HttpURLConnection con2 = (HttpURLConnection) url2.openConnection();
        con2.setRequestMethod("GET");

        int status2 = con2.getResponseCode();
        con2.disconnect();

        assertEquals(200, status1);
        assertEquals(200, status2);
    }

    @Test
    public void testConsultarUtilizadorInexistente() throws IOException {
        URL url1 = new URL("https://reqres.in/api/users/0");
        HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();
        con1.setRequestMethod("GET");

        int status1 = con1.getResponseCode();
        con1.disconnect();

        URL url2 = new URL("https://reqres.in/api/users/13");
        HttpURLConnection con2 = (HttpURLConnection) url2.openConnection();
        con2.setRequestMethod("GET");

        int status2 = con2.getResponseCode();
        con2.disconnect();

        assertEquals(404, status1);
        assertEquals(404, status2);
    }

    @Test
    public void testConsultarUtilizadorIdGrande() throws IOException {
        String id="";
        for(int i=0;i<10000;i++)
            id+="1";

        URL url = new URL("https://reqres.in/api/users/"+id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(414, status);
    }


    //testes listar utilizadores
    @Test
    public void testListarUtilizadoresSucesso() throws IOException {
        URL url = new URL("https://reqres.in/api/users");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(200, status);
    }


    @Test
    public void testListarRecursosSucesso() throws IOException {
        URL url = new URL("https://reqres.in/api/unknown");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(200, status);
    }


    @Test
    public void testConsultarRecursoSucesso() throws IOException {
        URL url1 = new URL("https://reqres.in/api/unknown/1");
        HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();
        con1.setRequestMethod("GET");

        int status1 = con1.getResponseCode();
        con1.disconnect();

        URL url2 = new URL("https://reqres.in/api/unknown/12");
        HttpURLConnection con2 = (HttpURLConnection) url2.openConnection();
        con2.setRequestMethod("GET");

        int status2 = con2.getResponseCode();
        con2.disconnect();

        assertEquals(200, status1);
        assertEquals(200, status2);
    }

    @Test
    public void testConsultarRecursoInexistente() throws IOException {
        URL url1 = new URL("https://reqres.in/api/unknown/0");
        HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();
        con1.setRequestMethod("GET");

        int status1 = con1.getResponseCode();
        con1.disconnect();

        URL url2 = new URL("https://reqres.in/api/unknown/13");
        HttpURLConnection con2 = (HttpURLConnection) url2.openConnection();
        con2.setRequestMethod("GET");

        int status2 = con2.getResponseCode();
        con2.disconnect();

        assertEquals(404, status1);
        assertEquals(404, status2);
    }

    @Test
    public void testConsultarRecursoIdGrande() throws IOException {
        String id="";
        for(int i=0;i<10000;i++)
            id+="1";

        URL url = new URL("https://reqres.in/api/unknown/"+id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(414, status);
    }



    @Test
    public void testDelay() throws IOException {
        URL url = new URL("https://reqres.in/api/users?delay=3");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(200, status);
    }

}
