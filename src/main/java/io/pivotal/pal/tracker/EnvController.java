package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class EnvController {

    private final String port;

    private final String mem_limit;

    private final String inst_indx;

    private final String inst_addr;

    public EnvController(@Value("${port:NOT SET}") String port,@Value("${memory.limit:NOT SET}") String mem_limit,@Value("${cf.instance.index:NOT SET}") String inst_indx,@Value("${cf.instance.addr:NOT SET}") String inst_addr) {
        this.port = port;
        this.mem_limit = mem_limit;
        this.inst_indx = inst_indx;
        this.inst_addr = inst_addr;
    }


    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> envVariableMap = new HashMap<String, String>();
        envVariableMap.put("PORT",port);
        envVariableMap.put("MEMORY_LIMIT",mem_limit);
        envVariableMap.put("CF_INSTANCE_INDEX",inst_indx);
        envVariableMap.put("CF_INSTANCE_ADDR",inst_addr);

        return envVariableMap;
    }
}
