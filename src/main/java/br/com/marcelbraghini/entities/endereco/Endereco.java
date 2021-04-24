package br.com.marcelbraghini.entities.endereco;

public class Endereco {

    private String cep;
    private String endereco;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;

    public Endereco(final String cep,
                    final String endereco,
                    final String complemento,
                    final String bairro,
                    final String cidade,
                    final String uf) {
        this.cep = cep;
        this.endereco = endereco;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getUf() {
        return uf;
    }

    public static class Builder {

        private String cep;
        private String endereco;
        private String complemento;
        private String bairro;
        private String cidade;
        private String uf;

        public Builder(String cep) {
            this.cep = cep;
        }

        public Builder withEndereco(String endereco) {
            this.endereco = endereco;
            return this;
        }

        public Builder withComplemento(String complemento) {
            this.complemento = complemento;
            return this;
        }

        public Builder withBairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public Builder withCidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public Builder withUf(String uf) {
            this.uf = uf;
            return this;
        }

        public Endereco build() {
            return new Endereco(this);
        }
    }

    private Endereco(Builder builder) {
        cep = builder.cep;
        endereco = builder.endereco;
        complemento = builder.complemento;
        bairro = builder.bairro;
        cidade = builder.cidade;
        uf = builder.uf;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", complemento='" + complemento + '\'' +
                ", end='" + endereco + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }

}
