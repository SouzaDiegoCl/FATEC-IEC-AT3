package fatec_dsm_iec.at_tres.controller;

import fatec_dsm_iec.at_tres.entities.ProdutoDTO;
import fatec_dsm_iec.at_tres.service.ProdutosService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping
public class ProdutoController {

    private final ProdutosService service;

    public ProdutoController(ProdutosService service) {
        this.service = service;
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoDTO>> buscarProdutos() {
        List<ProdutoDTO> response = service.buscarProdutos();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/produtos/{id}")
    public ResponseEntity<ProdutoDTO> buscarProdutos(@PathVariable String id){
        try {
            ProdutoDTO response = service.buscarProdutoPeloId(id);
            return ResponseEntity.ok(response);
        }
        catch(BadRequestException exception){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }catch(NoSuchElementException exception){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/produtos")
    public ResponseEntity<ProdutoDTO> adicionarProduto(@RequestBody @Valid ProdutoDTO produtoDTO) {
        ProdutoDTO response = service.adicionarProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
