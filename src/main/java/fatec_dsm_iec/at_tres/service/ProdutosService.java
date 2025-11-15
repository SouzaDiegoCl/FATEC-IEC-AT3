package fatec_dsm_iec.at_tres.service;

import fatec_dsm_iec.at_tres.entities.ProdutoDTO;
import fatec_dsm_iec.at_tres.external.fakeStoreApi.client.FakestoreApiClient;
import fatec_dsm_iec.at_tres.external.fakeStoreApi.entities.Produto;
import fatec_dsm_iec.at_tres.utils.conversor.ProdutoConversor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProdutosService {

    private final FakestoreApiClient client;

    public ProdutosService(FakestoreApiClient client) {
        this.client = client;
    }

    public List<ProdutoDTO> buscarProdutos() {
        return client.buscarProdutos().stream()
                .map(entity -> ProdutoConversor.toProdutoDto(entity)).toList();
    }

    public ProdutoDTO buscarProdutoPeloId(String id) throws BadRequestException, NoSuchElementException {
        try {
            Integer idFormatado = Integer.parseInt(id);
            Produto clientResponse = client.buscarProdutoPeloId(idFormatado);
            if (clientResponse == null) {
                throw new NoSuchElementException("Nenhum produto com o id Informado!");
            }
            return ProdutoConversor.toProdutoDto(clientResponse);
        } catch (NumberFormatException exception) {
            throw new BadRequestException("Id informado é inválido!");
        }
    }

    public ProdutoDTO adicionarProduto(ProdutoDTO produtoDTO) {
        var prod = ProdutoConversor.toProduto(produtoDTO);
        Produto produtoPersistido = client.adicionarProdutos(prod);
        return ProdutoConversor.toProdutoDto(produtoPersistido);
    }

}
