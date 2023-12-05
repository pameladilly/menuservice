package br.com.pameladilly.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class MenuDTOResponse {
    private String name;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ProductDTO> preferences;

    private List<ProductDTO> products;




    @Override
    public String toString() {
        return "MenuDTOResponse{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
