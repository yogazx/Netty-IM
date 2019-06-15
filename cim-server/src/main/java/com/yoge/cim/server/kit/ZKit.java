package com.yoge.cim.server.kit;

import com.yoge.cim.server.config.AppConfiguration;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ZKit {

    @Autowired
    private ZkClient zkClient;

    @Autowired
    private AppConfiguration appConfiguration;

    public void createRootNode() {
        boolean exists = zkClient.exists(appConfiguration.getZkRoot());
        if (exists)
            return;
        // 创建root
        zkClient.createPersistent(appConfiguration.getZkRoot());
    }
}
