package fatec_dsm_iec.at_tres.utils.conversor;

import fatec_dsm_iec.at_tres.entities.AvaliacaoDTO;
import fatec_dsm_iec.at_tres.external.fakeStoreApi.entities.Avaliacao;

public class AvalicaoConversor {

    public static AvaliacaoDTO toAvaliacaoDTO(Avaliacao entity){
        return new AvaliacaoDTO(
                entity.nota(),
                entity.quantidade()
        );
    }
    public static Avaliacao toAvaliacao(AvaliacaoDTO dto){
        return new Avaliacao(
                dto.getNota(),
                dto.getQuantidade()
        );
    }
}
