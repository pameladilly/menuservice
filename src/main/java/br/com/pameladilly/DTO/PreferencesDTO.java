package br.com.pameladilly.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PreferencesDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long idPessoa;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long idMenu;

    @JsonProperty(value = "preferences")
    private List<ProductDTO> products;

}
