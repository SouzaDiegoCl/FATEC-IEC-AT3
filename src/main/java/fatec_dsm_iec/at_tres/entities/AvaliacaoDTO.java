package fatec_dsm_iec.at_tres.entities;

import jakarta.validation.constraints.NotNull;

public class AvaliacaoDTO {
    @NotNull(message = "Nota não pode ser nula")
    private Float nota;

    @NotNull(message = "Quantidade não pode ser nula")
    private Integer quantidade;

    public AvaliacaoDTO() {
    }

    public AvaliacaoDTO(Float nota, Integer quantidade) {
        this.nota = nota;
        this.quantidade = quantidade;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "AvaliacaoDTO{" +
                "nota=" + nota +
                ", quantidade=" + quantidade +
                '}';
    }
}
