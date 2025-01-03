package com.milhas.core.agency.app.dto.request;

import com.milhas.core.agency.app.dto.response.AddressResponseDTO;
import lombok.Data;
import java.util.List;

@Data
public class AgencyRequestDTO {
    private String name;
    private String code;
    private String phone;
    private List<AddressResponseDTO> address;
}
