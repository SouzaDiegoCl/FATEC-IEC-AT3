package fatec_dsm_iec.at_tres.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fatec_dsm_iec.at_tres.entities.ProdutoDTO;
import fatec_dsm_iec.at_tres.external.fakeStoreApi.entities.Produto;
import fatec_dsm_iec.at_tres.service.ProdutosService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @MockitoBean
    private ProdutosService service;

    @Test
    void shouldReturnAllProductsWithSuccess() throws Exception {
        when(service.buscarProdutos()).thenReturn(List.of(new ProdutoDTO()));

        mockMvc.perform(get("/produtos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    void shouldReturProductSearchedWithSuccess() throws Exception {
        final String TITULO_MOCK = "tituloMock";
        when(service.buscarProdutoPeloId(anyString())).thenReturn(new ProdutoDTO(TITULO_MOCK));

        mockMvc.perform(get("/produtos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value(TITULO_MOCK));
    }

    @Test
    void shouldReturnProductPersistedWithSuccess() throws Exception {
        final String TITULO_MOCK = "tituloMock";
        when(service.adicionarProduto(any(ProdutoDTO.class))).thenReturn(new ProdutoDTO(TITULO_MOCK));

        mockMvc.perform(post("/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new ProdutoDTO(TITULO_MOCK, Float.MAX_VALUE, "description", "imagemURL")))
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.titulo").value(TITULO_MOCK));
    }

}
