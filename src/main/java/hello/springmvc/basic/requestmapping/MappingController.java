package hello.springmvc.basic.requestmapping;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping({"/hello-basic", "/hello-go"}) // 두개 넣어도 된다.
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value="/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mappingGetV2");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingGetV3(@PathVariable("userId") String data) {
        log.info("mappingGetV3 userId={}", data );
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingGetV4(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingGetV4 userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

//    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)// 요청헤더의 컨텐트 타입
    public String mappingConsume() {
        log.info("mappingConsume");
        return "ok";
    } // 요청 Content-Type이 application/json인 경우에 호출된다.

    /**
     * Accept 헤더 기반 Media Type Mapping
     * produces = "text/html"
     * Accept 헤더를 기반으로 미디어 타입으로 매핑한다.
     */
    @PostMapping(value = "/mapping-produce", produces = "text/html") // 요청헤더의 accept
    public String mappingProduce() {
        log.info("mappingProduce");
        return "ok";
    } // 응답 Content-Type이 text/html인 경우에 호출된다.

}
