package br.com.pameladilly.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PreferencesDTO {

    private Long idPessoa;
    private Long idMenu;

    @JsonProperty(value = "preferences")
    private List<ProductDTO> products;

}
