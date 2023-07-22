package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
    //private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "spring";

        //application.properties    //logging.level.hello.springmvc=trace
        //trace -> debug -> info -> warn 내림차순으로 적용됨
        //배포할 때 개발 서버는 debug , 운영 서버는 info, 로컬 서버에서는 trace로 설정하는 등 각 서버마다 로그레벨을 설정하여 사용할 수 있다.
        log.trace("trace log={}",name);
        log.debug("debug log ={}", name);
        log.info("info log = {}", name);
        log.error("error log = {}", name);
        log.warn("warn log = {}", name);


        // 현재 로그 레벨 설정 = debug 이기 때문에 출력되지는 않는다. 하지만 ' + ' 연산이 실행됨에 따라 불필요한 자원 소모가 발생하니 주의 !!
        log.trace("trace log = {}" +name);
        return "ok";


    }


}
