import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Funcoes {

    public static Resposta criarUtilizador(Utilizador utilizador) throws IOException {

        if (utilizador == null)
            return new Resposta().criarUtilizadorNull();

        if (utilizador.getEmail() == null)
            return new Resposta().criarUtilizadorEmailVazioNulo();

        if (utilizador.getEmail().isEmpty())
            return new Resposta().criarUtilizadorEmailVazioNulo();

        if (!utilizador.getEmail().contains("@"))
            return new Resposta().criarUtilizadorEmailFormatoInvalido();

        URL url = new URL("https://reqres.in/api/users/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", utilizador.getId());
        parameters.put("email", utilizador.getEmail());
        parameters.put("first_name", utilizador.getFirst_name());
        parameters.put("last_name", utilizador.getLast_name());
        parameters.put("avatar", utilizador.getAvatar());

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();

        StringBuffer content = new StringBuffer();
        InputStream inputStream = con.getErrorStream();
        if (inputStream == null) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
        }
        con.disconnect();


        return new Resposta().criarUtilizadorSucesso();


    }

    public static Resposta consultarDadosUtilizador(String id) throws IOException, JSONException {
        if (id == null)
            return new Resposta().consultarDadosUtilizadorIdVazioNulo();

        if (id.isEmpty())
            return new Resposta().consultarDadosUtilizadorIdVazioNulo();


        URL url = new URL("https://reqres.in/api/users/" + id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();

        JSONObject object = null;
        JSONObject data = null;
        StringBuffer content = new StringBuffer();
        InputStream inputStream = con.getErrorStream();
        if (inputStream == null) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            object = new JSONObject(content.toString());
            data = object.getJSONObject("data");
            in.close();
        }
        con.disconnect();

        if (status == 200) {
            Utilizador utilizador = new Utilizador(String.valueOf(data.getString("id")), data.getString("email"), data.getString("first_name"), data.getString("last_name"), data.getString("avatar"));
            return new Resposta().consultarDadosUtilizadorExistente(utilizador);
        }

        return new Resposta().consultarDadosUtilizadorInexistente();

    }

    public static Resposta listarUtilizadores() throws IOException, JSONException {
        URL url = new URL("https://reqres.in/api/users");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        JSONObject object = new JSONObject(content.toString());
        JSONArray array = object.getJSONArray("data");

        ArrayList<Utilizador> utilizadores = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            utilizadores.add(new Utilizador(String.valueOf(array.getJSONObject(i).getInt("id")), array.getJSONObject(i).getString("email"), array.getJSONObject(i).getString("first_name"), array.getJSONObject(i).getString("last_name"), array.getJSONObject(i).getString("avatar")));
        }

        return new Resposta().listarUtilizadoresSucesso(utilizadores);
    }


    public static Resposta registarUtilizador(String email, String password) throws IOException {

        if (email == null || password == null)
            return new Resposta().registarUtilizadorCredenciaisVazias();

        if (email.isEmpty() || password.isEmpty())
            return new Resposta().registarUtilizadorCredenciaisVazias();

        URL url = new URL("https://reqres.in/api/register/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", email);
        parameters.put("password", password);

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();

        StringBuffer content = new StringBuffer();
        InputStream inputStream = con.getErrorStream();
        if (inputStream == null) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
        }
        con.disconnect();

        if (status == 200)
            return new Resposta().registarUtilizadorSucesso();
        return new Resposta().registarUtilizadorNaoCriado();

    }


    public static Resposta autenticarUtilizador(String email, String password) throws IOException {

        if (email == null || password == null)
            return new Resposta().autenticarUtilizadorCredenciaisVazias();

        if (email.isEmpty() || password.isEmpty())
            return new Resposta().autenticarUtilizadorCredenciaisVazias();

        URL url = new URL("https://reqres.in/api/login/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("email", email);
        parameters.put("password", password);

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        int status = con.getResponseCode();

        StringBuffer content = new StringBuffer();
        InputStream inputStream = con.getErrorStream();
        if (inputStream == null) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
        }
        con.disconnect();

        if (status == 200)
            return new Resposta().autenticarUtilizadorSucesso();

        return new Resposta().autenticarUtilizadorCredenciaisInvalidas();

    }


    public static Resposta consultarRecurso(String id) throws IOException, JSONException {

        if (id == null)
            return new Resposta().consultarRecursoIdVazioNulo();

        if (id.isEmpty())
            return new Resposta().consultarRecursoIdVazioNulo();

        URL url = new URL("https://reqres.in/api/unknown/" + id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();

        JSONObject object = null;
        JSONObject data = null;
        StringBuffer content = new StringBuffer();
        InputStream inputStream = con.getErrorStream();
        if (inputStream == null) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            object = new JSONObject(content.toString());
            data = object.getJSONObject("data");
        }
        con.disconnect();


        if (status == 200) {
            Recurso recurso = new Recurso(String.valueOf(data.getInt("id")), data.getString("name"), data.getString("year"), data.getString("color"), data.getString("pantone_value"));
            return new Resposta().consultarRecursoExistente(recurso);
        }

        return new Resposta().consultarRecursoInexistente();
    }

    public static Resposta listarRecursos() throws IOException, JSONException {
        URL url = new URL("https://reqres.in/api/unknown");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        JSONObject object = new JSONObject(content.toString());
        JSONArray array = object.getJSONArray("data");

        ArrayList<Recurso> recursos = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            recursos.add(new Recurso(String.valueOf(array.getJSONObject(i).getInt("id")), array.getJSONObject(i).getString("name"), array.getJSONObject(i).getString("year"), array.getJSONObject(i).getString("color"), array.getJSONObject(i).getString("pantone_value")));
        }

        return new Resposta().listarRecursosSucesso(recursos);
    }

}
