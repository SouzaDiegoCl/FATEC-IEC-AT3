package fatec_dsm_iec.at_tres.entities;

import jakarta.validation.constraints.NotNull;

public class ProdutoDTO {
    @NotNull(message = "Titulo não pode ser nulo!")
    String titulo;

    @NotNull(message = "Preço não pode ser nulo!")
    Float preco;

    @NotNull(message = "Descrição não pode ser nulo!")
    String descricao;

    @NotNull(message = "URL de Imagem não pode ser nulo!")
    String imagemUrl;

    AvaliacaoDTO avaliacao;

    public ProdutoDTO() {
    }
    public ProdutoDTO(String titulo) {
        this.titulo = titulo;
    }

    public ProdutoDTO(String titulo, Float preco, String descricao, String imagemUrl) {
        this.titulo = titulo;
        this.preco = preco;
        this.descricao = descricao;
        this.imagemUrl = imagemUrl;
    }
    public ProdutoDTO(String titulo, Float preco, String descricao, String imagemUrl, AvaliacaoDTO avaliacao) {
        this.titulo = titulo;
        this.preco = preco;
        this.descricao = descricao;
        this.imagemUrl = imagemUrl;
        this.avaliacao = avaliacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public AvaliacaoDTO getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(AvaliacaoDTO avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return "ProdutoDTO{" +
                "titulo='" + titulo + '\'' +
                ", preco=" + preco +
                ", descricao='" + descricao + '\'' +
                ", imagemUrl='" + imagemUrl + '\'' +
                ", avaliacao=" + avaliacao +
                '}';
    }
}
