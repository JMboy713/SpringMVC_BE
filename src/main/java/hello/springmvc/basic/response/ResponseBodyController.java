package hello.springmvc.basic.response;


import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

/**
 ResponseBody를 class 레벨에 두어도 된다.
 responseBody + Controller = RestController
 */

@Slf4j
@Controller
public class ResponseBodyController {
    @GetMapping("/response-body-string-v1")
    public void responseBodyStringV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }
    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyStringV2() throws IOException {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @GetMapping("/response-body-string-v3")
    public String responseBodyStringV3() throws IOException {
        return "ok";
    }

    @ResponseBody
    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);
        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)// 동적으로 바꿀 수는 없다.
    @ResponseBody
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);
        return helloData;
    }








}
