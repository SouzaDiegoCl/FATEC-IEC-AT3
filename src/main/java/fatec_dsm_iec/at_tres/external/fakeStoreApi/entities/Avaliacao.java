package fatec_dsm_iec.at_tres.external.fakeStoreApi.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public record Avaliacao(
        @JsonProperty("rate")
        Float nota,
        @JsonProperty("count")
        Integer quantidade) {
}
