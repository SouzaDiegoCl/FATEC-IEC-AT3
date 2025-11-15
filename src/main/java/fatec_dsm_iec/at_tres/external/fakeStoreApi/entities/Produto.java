package fatec_dsm_iec.at_tres.external.fakeStoreApi.entities;

import com.fasterxml.jackson.annotation.JsonProperty;


public record Produto(
        @JsonProperty("id")
        Integer id,
        @JsonProperty("title")
        String titulo,
        @JsonProperty("price")
        Float preco,
        @JsonProperty("description")
        String descricao,
        @JsonProperty("image")
        String imagemUrl,
        @JsonProperty("rating")
        Avaliacao avaliacao
) {
}
