package fatec_dsm_iec.at_tres.external.fakeStoreApi.client;

import fatec_dsm_iec.at_tres.external.fakeStoreApi.entities.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "FakestoreApi", url = "${external.client.url}")
public interface FakestoreApiClient {

    @GetMapping("/products")
    List<Produto> buscarProdutos();

    @GetMapping("/products/{id}")
    Produto buscarProdutoPeloId(@PathVariable Integer id);

    @PostMapping("/products")
    Produto adicionarProdutos(@RequestBody Produto produto);

}
