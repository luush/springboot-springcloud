package org.lszjaf.shop.servicezuul.connfig;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;

public class CheckHealthHandler implements HealthCheckHandler {
    @Override
    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus instanceStatus) {
        return null;
    }
}
