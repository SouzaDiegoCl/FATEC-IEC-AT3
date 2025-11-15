package fatec_dsm_iec.at_tres.utils.conversor;

import fatec_dsm_iec.at_tres.entities.ProdutoDTO;
import fatec_dsm_iec.at_tres.external.fakeStoreApi.entities.Produto;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class ProdutoConversor {

    public static ProdutoDTO toProdutoDto(Produto entity) {
        return new ProdutoDTO(
                entity.titulo(),
                entity.preco(),
                entity.descricao(),
                entity.imagemUrl(),
                entity.avaliacao() != null ? AvalicaoConversor.toAvaliacaoDTO(entity.avaliacao()) : null
        );
    }
    public static Produto toProduto(ProdutoDTO dto) {
        Random random = new Random();

        return new Produto(
                random.nextInt(),
                dto.getTitulo(),
                dto.getPreco(),
                dto.getDescricao(),
                dto.getImagemUrl(),
                AvalicaoConversor.toAvaliacao(dto.getAvaliacao())
        );
    }

}
