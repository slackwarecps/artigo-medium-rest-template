package br.com.fabioalvaro.app1.pojo;
public class Piada  {
    public Long piadaId;
    public String pergunta;
    public String resposta;

    public Piada(Long piadaId, String pergunta, String resposta) {
        this.piadaId = piadaId;
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public Long getPiadaId() {
        return piadaId;
    }

    public void setPiadaId(Long piadaId) {
        this.piadaId = piadaId;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
