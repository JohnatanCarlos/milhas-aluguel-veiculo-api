package com.milhas.core.commons.interceptor;

import com.milhas.core.commons.dto.CustomResponseDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;

@ControllerAdvice
public class CustomResponse implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        // Aqui você pode adicionar lógica para determinar se deseja aplicar este conselho
        // a todas as respostas ou apenas a respostas específicas
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        if (body instanceof List<?>) {
            List<?> bodyList = (List<?>) body;
            CustomResponseDTO<Object> customResponse = new CustomResponseDTO<>((List<Object>) bodyList, bodyList.size());
            return customResponse;
        }
        return body;
    }
}
