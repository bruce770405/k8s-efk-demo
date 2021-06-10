package tw.com.bruce.demo.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author brucehsu
 * @Date 2021/5/27 1:03 下午
 * @Version 1.0
 **/
@Component
@Slf4j
public class DemoLogScheduler {

    @Scheduled(fixedRate = 5000)
    public void log() {
        log.info("This is \na multiline\n\n\nlog");
    }
}
