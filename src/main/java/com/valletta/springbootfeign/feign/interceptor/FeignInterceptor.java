package com.valletta.springbootfeign.feign.interceptor;

import feign.Request.HttpMethod;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
@RequiredArgsConstructor(staticName = "of")
public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {

        // get 요청일 경우
        if (Objects.equals(template.method(), HttpMethod.GET.name())) {
            log.info("[GET] [FeignInterceptor] queries: {}", template.queries());
            return;
        }

        // post 요청일 경우
        String encodedRequestBody = StringUtils.toEncodedString(template.body(), StandardCharsets.UTF_8);
        log.info("[POST] [FeignInterceptor] requestBody: {}", encodedRequestBody);

        // 추가적으로 필요한 로직을 추가
        String convertRequestBody = encodedRequestBody;
        template.body(convertRequestBody);
    }
}
