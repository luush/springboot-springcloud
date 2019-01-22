package org.lszjaf.shop.ordercenter.service.impl;

import org.lszjaf.shop.ordercenter.common.ResponseDTO;
import org.lszjaf.shop.ordercenter.common.ReturnCode;
import org.lszjaf.shop.ordercenter.service.DeliverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("deliverService")
public class DeliverServiceImpl implements DeliverService {
    @Autowired
    private DeliverService deliverService;

    private List<String> rePush = new ArrayList<>(16);

    //熔断之后的请求操作就会调用这个方法，这里就可以对失败的请求进行进一步，具体的处理
    //比如做缓存，比如数据持久化，然后等被请求的服务好了之后，在做进一步的处理
    @Override
    public ResponseDTO noticeDeliver(String json) {
        if (!rePush.contains(json)) {
            rePush.add(json);
        }
        ResponseDTO responseDTO = new ResponseDTO(ReturnCode.ACTIVE_FAILURE);
        return responseDTO;
    }

    @Scheduled(fixedDelay = 180000)
    public void sentFailResult() {
        System.out.println("开启了定时任务");
        if (rePush.isEmpty()) {
            return;
        }
        for (String s : rePush) {
            deliverService.noticeDeliver(s);
        }
        System.out.println("定时任务执行完了。。");
    }
}
