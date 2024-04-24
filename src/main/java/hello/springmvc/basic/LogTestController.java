package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass()); // lombok을 사용하면 이렇게 사용할 필요가 없다.
//    SLF4J를 사용하면 위의 코드를 쓸 필요가 없다.

    @GetMapping("/log-test")
    public String logTest() {
        String name = "Spring";
        System.out.println("name = " + name);// 무조건 출력 되기 때문에. 성능에 영향을 줄 수 있다.
        // log level: trace -> debug -> info -> warn -> error
        // 기본은 info
        //log.trace("trace log="+ name);// 이렇게 하면 연산을 해버리기 때문에 메모리를 사용하고, 성능이 저하된다.

        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);
        return "ok";
    }
}
