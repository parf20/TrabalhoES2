import org.junit.Test;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsApi {


    //   !!  o content type faz com que os testes falhem mesmo quando tudo esta correto


    //testes do login
    @Test
    public void testAutenticacaoSucesso() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

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
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

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

        assertEquals(401, status);
    }

    @Test
    public void testAutenticacaoEmailFormatoInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "testemail.com");
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
    public void testAutenticacaoEmailLimiteInferior() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "a@es.in");
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
    public void testAutenticacaoEmailLimiteSuperior() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "asdzxcqwsadertfgvbfcd@reqres.in");
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
    public void testAutenticacaoEmailLimiteMinimo() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "qwerty@reqres.in");
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
    public void testAutenticacaoEmailLimiteMaximo() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "asdzxcqwsadertfgvbfc@reqres.in");
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
    public void testAutenticacaoPasswordLimiteInferior() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "eve.holt@reqres.in");
        parameters.put("password", "12345");

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
    public void testAutenticacaoPasswordLimiteSuperior() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "eve.holt@reqres.in");
        parameters.put("password", "passwordtest123456789");

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
    public void testAutenticacaoPasswordLimiteMinimo() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "eve.holt@reqres.in");
        parameters.put("password", "123456");

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
    public void testAutenticacaoPasswordLimiteMaximo() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "eve.holt@reqres.in");
        parameters.put("password", "passwordtest12345678");

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
    public void testAutenticacaoEmailNull() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", null);
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
    public void testAutenticacaoPasswordNull() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "eve.holt@reqres.in");
        parameters.put("password", null);

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
    public void testAutenticacaoEmailPasswordNull() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", null);
        parameters.put("password", null);

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
    public void testAutenticacaoEmailVazio() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "");
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
    public void testAutenticacaoPasswordVazia() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "eve.holt@reqres.in");
        parameters.put("password", "");

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
    public void testAutenticacaoEmailPasswordVazios() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "");
        parameters.put("password", "");

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
    public void testAutenticacaoCampoEmailInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("emailx", "eve.holt@reqres.in");
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
    public void testAutenticacaoCampoPasswordInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "eve.holt@reqres.in");
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
    public void testAutenticacaoContentTypeInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/xml");

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

        assertEquals(400, status);
    }

    @Test
    public void testAutenticacaoMetodoGET() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/json");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(405, status);
    }

    @Test
    public void testAutenticacaoMetodoPUT() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty("Content-Type","application/json");

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

        assertEquals(405, status);
    }

    @Test
    public void testAutenticacaoMetodoDELETE() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("Content-Type","application/json");

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

        assertEquals(405, status);
    }







    //testes registo
    @Test
    public void testRegistoSucesso() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

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
    public void testRegistoEmailContaNaoCriada() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "test@reqres.in");
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
    public void testRegistoEmailContaJaRegistada() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

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

        assertEquals(409, status);
    }

    @Test
    public void testRegistoEmailFormatoInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "testemail.com");
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
    public void testRegistoEmailLimiteInferior() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "a@es.in");
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
    public void testRegistoEmailLimiteSuperior() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "asdzxcqwsadertfgvbfcd@reqres.in");
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
    public void testRegistoEmailLimiteMinimo() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "qwerty@reqres.in");
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
    public void testRegistoEmailLimiteMaximo() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "asdzxcqwsadertfgvbfc@reqres.in");
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
    public void testRegistoPasswordLimiteInferior() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "eve.holt@reqres.in");
        parameters.put("password", "12345");

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
    public void testRegistoPasswordLimiteSuperior() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "eve.holt@reqres.in");
        parameters.put("password", "passwordtest123456789");

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
    public void testRegistoPasswordLimiteMinimo() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "eve.holt@reqres.in");
        parameters.put("password", "123456");

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
    public void testRegistoPasswordLimiteMaximo() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "eve.holt@reqres.in");
        parameters.put("password", "passwordtest12345678");

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
    public void testRegistoEmailNull() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", null);
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
    public void testRegistoPasswordNull() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "eve.holt@reqres.in");
        parameters.put("password", null);

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
    public void testRegistoEmailPasswordNull() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", null);
        parameters.put("password", null);

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
    public void testRegistoEmailVazio() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "");
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
    public void testRegistoPasswordVazia() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "eve.holt@reqres.in");
        parameters.put("password", "");

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
    public void testRegistoEmailPasswordVazios() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "");
        parameters.put("password", "");

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
    public void testRegistoCampoEmailInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("emailx", "eve.holt@reqres.in");
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
    public void testRegistoCampoPasswordInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "eve.holt@reqres.in");
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
    public void testRegistoContentTypeInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/register");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/xml");

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

        assertEquals(400, status);
    }

    @Test
    public void testRegistoMetodoGET() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/json");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(405, status);
    }

    @Test
    public void testRegistoMetodoPUT() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty("Content-Type","application/json");

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

        assertEquals(405, status);
    }

    @Test
    public void testRegistoMetodoDELETE() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("Content-Type","application/json");

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

        assertEquals(405, status);
    }












    //testes criar utilizador
    @Test
    public void testCriarUtilizadorSucesso() throws IOException {
        URL url = new URL("https://reqres.in/api/users");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "test@reqres.in");
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");
        parameters.put("avatar", "rgergeegrerre.jpg");


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
    public void testCriarUtilizadorJaExistente() throws IOException {
        URL url = new URL("https://reqres.in/api/users");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "eve.holt@reqres.in");
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");
        parameters.put("avatar", "rgergeegrerre.jpg");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(409, status);
    }

    @Test
    public void testCriarUtilizadorEmailFormatoInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/users");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "testreqres.in");
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");
        parameters.put("avatar", "rgergeegrerre.jpg");

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
    public void testCriarUtilizadorEmailLimiteInferior() throws IOException {
        URL url = new URL("https://reqres.in/api/users");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "a@es.in");
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");
        parameters.put("avatar", "rgergeegrerre.jpg");

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
    public void testCriarUtilizadorEmailLimiteSuperior() throws IOException {
        URL url = new URL("https://reqres.in/api/users");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "asdzxcqwsadertfgvbfcd@reqres.in");
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");
        parameters.put("avatar", "rgergeegrerre.jpg");

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
    public void testCriarUtilizadorEmailLimiteMinimo() throws IOException {
        URL url = new URL("https://reqres.in/api/users");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "qwerty@reqres.in");
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");
        parameters.put("avatar", "rgergeegrerre.jpg");

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
    public void testCriarUtilizadorEmailLimiteMaximo() throws IOException {
        URL url = new URL("https://reqres.in/api/users");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "asdzxcqwsadertfgvbfc@reqres.in");
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");
        parameters.put("avatar", "rgergeegrerre.jpg");

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
    public void testCriarUtilizadorEmailVazio() throws IOException {
        URL url = new URL("https://reqres.in/api/users");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "");
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");
        parameters.put("avatar", "rgergeegrerre.jpg");

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
    public void testCriarUtilizadorEmailNull() throws IOException {
        URL url = new URL("https://reqres.in/api/users");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", null);
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");
        parameters.put("avatar", "rgergeegrerre.jpg");

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
    public void testCriarUtilizadorContentTypeInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/users");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/xml");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "test@reqres.in");
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");
        parameters.put("avatar", "rgergeegrerre.jpg");

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
    public void testCriarUtilizadorMetodoPUT() throws IOException {
        URL url = new URL("https://reqres.in/api/users");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "test@reqres.in");
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");
        parameters.put("avatar", "rgergeegrerre.jpg");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(405, status);
    }

    @Test
    public void testCriarUtilizadorMetodoDELETE() throws IOException {
        URL url = new URL("https://reqres.in/api/users");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "test@reqres.in");
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");
        parameters.put("avatar", "rgergeegrerre.jpg");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(405, status);
    }

    @Test
    public void testCriarUtilizadorTokenInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/usersx");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","a");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", "test@reqres.in");
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");
        parameters.put("avatar", "rgergeegrerre.jpg");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(401, status);
    }








    //testes atualizar utilizador
    @Test
    public void testAtualizarUtilizadorSucesso() throws IOException {
        URL url = new URL("https://reqres.in/api/users/5");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");

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
    public void testAtualizarUtilizadorLimiteMaximo() throws IOException {
        URL url = new URL("https://reqres.in/api/users/12");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");

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
    public void testAtualizarUtilizadorLimiteMinimo() throws IOException {
        URL url = new URL("https://reqres.in/api/users/1");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");

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
    public void testAtualizarUtilizadorLimiteSuperior() throws IOException {
        URL url = new URL("https://reqres.in/api/users/13");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(404, status);
    }

    @Test
    public void testAtualizarUtilizadoLimiteInferior() throws IOException {
        URL url = new URL("https://reqres.in/api/users/0");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(404, status);
    }

    @Test
    public void testAtualizarUtilizadorContentTypeInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/users/5");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty("Content-Type","application/xml");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");

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
    public void testAtualizarUtilizadorMetodoPOST() throws IOException {
        URL url = new URL("https://reqres.in/api/users/5");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(405, status);
    }

    @Test
    public void testAtualizarUtilizadorTokenInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/users/5");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","a");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("first_name", "John");
        parameters.put("last_name", "Doe");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(401, status);
    }











    //testes apagar atualizador
    @Test
    public void testApagarUtilizadorLimiteMaximo() throws IOException {
        URL url = new URL("https://reqres.in/api/users/12");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(204, status);
    }

    @Test
    public void testApagarUtilizadorLimiteMinimo() throws IOException {
        URL url = new URL("https://reqres.in/api/users/1");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(204, status);
    }

    @Test
    public void testApagarUtilizadorLimiteSuperior() throws IOException {
        URL url = new URL("https://reqres.in/api/users/13");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(404, status);
    }

    @Test
    public void testApagarUtilizadoLimiteInferior() throws IOException {
        URL url = new URL("https://reqres.in/api/users/0");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(404, status);
    }

    @Test
    public void testApagarUtilizadorContentTypeInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/users/2");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("Content-Type","application/xml");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(404, status);
    }

    @Test
    public void testApagarUtilizadorTokenInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/usersx/2");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","a");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(404, status);
    }










    //testes consultar utilizador
    @Test
    public void testConsultarUtilizadorLimiteMaximo() throws IOException {
        URL url = new URL("https://reqres.in/api/users/12");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(200, status);
    }

    @Test
    public void testConsultarUtilizadorLimiteMinimo() throws IOException {
        URL url = new URL("https://reqres.in/api/users/1");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(200, status);
    }

    @Test
    public void testConsultarUtilizadorLimiteSuperior() throws IOException {
        URL url = new URL("https://reqres.in/api/users/13");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(404, status);
    }

    @Test
    public void testConsultarUtilizadorLimiteInferior() throws IOException {
        URL url = new URL("https://reqres.in/api/users/0");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(404, status);
    }

    @Test
    public void testConsultarUtilizadorContentTypeInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/users/2");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/xml");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(400, status);
    }

    @Test
    public void testConsultarUtilizadorTokenInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/users/2");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","a");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(401, status);
    }









    //testes listar utilizadores
    @Test
    public void testListarUtilizadoresSucesso() throws IOException {
        URL url = new URL("https://reqres.in/api/users");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(200, status);
    }

    @Test
    public void testListarUtilizadoresContentTypeInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/users");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/xml");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(400, status);
    }

    @Test
    public void testListarUtilizadoresTokenInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/users");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","a");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(401, status);
    }








    //testes listar recursos
    @Test
    public void testListarRecursosSucesso() throws IOException {
        URL url = new URL("https://reqres.in/api/unknown");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(200, status);
    }

    @Test
    public void testListarRecursosContentTypeInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/unknown");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/xml");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(400, status);
    }

    @Test
    public void testListarRecursosMetodoPOST() throws IOException {
        URL url = new URL("https://reqres.in/api/unknown");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(405, status);
    }

    @Test
    public void testListarRecursosMetodoPUT() throws IOException {
        URL url = new URL("https://reqres.in/api/unknown");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(405, status);
    }

    @Test
    public void testListarRecursosMetodoDELETE() throws IOException {
        URL url = new URL("https://reqres.in/api/unknown");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(500, status);
    }

    @Test
    public void testListarRecursosTokenInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/unknown");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","a");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(401, status);
    }








    //testes consultar recurso
    @Test
    public void testConsultarRecursoLimiteMaximo() throws IOException {
        URL url = new URL("https://reqres.in/api/unknown/12");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(200, status);
    }

    @Test
    public void testConsultarRecursoLimiteMinimo() throws IOException {
        URL url = new URL("https://reqres.in/api/unknown/1");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(200, status);
    }

    @Test
    public void testConsultarRecursoLimiteSuperior() throws IOException {
        URL url = new URL("https://reqres.in/api/unknown/13");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(404, status);
    }

    @Test
    public void testConsultarRecursoLimiteInferior() throws IOException {
        URL url = new URL("https://reqres.in/api/unknown/0");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(404, status);
    }

    @Test
    public void testConsultarRecursoContentTypeInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/unknown/2");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/xml");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(400, status);
    }

    @Test
    public void testConsultarRecursosMetodoPOST() throws IOException {
        URL url = new URL("https://reqres.in/api/unknown/2");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(405, status);
    }

    @Test
    public void testConsultarRecursosMetodoPUT() throws IOException {
        URL url = new URL("https://reqres.in/api/unknown/2");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(405, status);
    }

    @Test
    public void testConsultarRecursosMetodoDELETE() throws IOException {
        URL url = new URL("https://reqres.in/api/users/2");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(405, status);
    }

    @Test
    public void testConsultarRecursoTokenInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/unknown/2");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","a");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(401, status);
    }




    //test endpoint invalido
    @Test
    public void testAPIEndpointInvalido() throws IOException {
        URL url = new URL("https://reqres.in/api/test");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization","QpwL5tke4Pnpja7X4");

        int status = con.getResponseCode();
        con.disconnect();

        assertEquals(404, status);
    }



}
