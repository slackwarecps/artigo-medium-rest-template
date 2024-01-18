package br.com.fabioalvaro.app1.controller;

import br.com.fabioalvaro.app1.pojo.Piada;
import org.apache.hc.client5.http.utils.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.nio.charset.Charset;


@RestController
public class PrincipalController {

    private String URI ="https://piada-ruim.wiremockapi.cloud/piada";
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/teste")
    public Piada[] meuTeste() {
        String uri=URI;
        ResponseEntity<Piada[]> response1 =restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<Piada[]>(createHeaders("fabiao", "patinho123")), Piada[].class);
        Piada[] piadas = response1.getBody();
        return piadas;
    }

    @GetMapping("/teste2")
    public Piada[] meuTeste2() {
        String uri=URI;
        restTemplate.getInterceptors().add(
                new BasicAuthenticationInterceptor("fabiao", "peteca123"));
        //ResponseEntity<Piada[]> response1 =  restTemplate.getForEntity(   uri, Piada[].class);
        ResponseEntity<Piada[]> response1 =
        restTemplate.exchange(
                uri,
                HttpMethod.GET, null, Piada[].class);
        Piada[] piadas = response1.getBody();
        return piadas;
    }

    @GetMapping("/")
    public ResponseEntity<?> retornaJsonOla() {
        return ResponseEntity.ok().body(new Object() {
            public final String mensagem = "ola amigos!";
        });
    }

    HttpHeaders createHeaders(String username, String password){
        System.out.println("Criando o Contexto do header " );
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};

    }


}
