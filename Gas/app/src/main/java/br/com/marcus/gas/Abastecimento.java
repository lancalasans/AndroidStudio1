package br.com.marcus.gas;

public class Abastecimento {
   private String posto;
   private long litros;
   private long quilometragem;
   private double preco;
   private String atendimento;

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public long getLitros() {
        return litros;
    }

    public void setLitros(long litros) {
        this.litros = litros;
    }

    public long getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(long quilometragem) {
        this.quilometragem = quilometragem;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(String atendimento) {
        this.atendimento = atendimento;
    }
}
