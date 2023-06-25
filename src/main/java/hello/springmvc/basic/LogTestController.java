package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

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


        return "ok";


    }


}
