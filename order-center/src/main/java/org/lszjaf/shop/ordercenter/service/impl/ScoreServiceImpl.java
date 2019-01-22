package org.lszjaf.shop.ordercenter.service.impl;

import org.lszjaf.shop.ordercenter.common.ResponseDTO;
import org.lszjaf.shop.ordercenter.common.ReturnCode;
import org.lszjaf.shop.ordercenter.service.ScoreService;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {

    //熔断之后的请求操作就会调用这个方法，这里就可以对失败的请求进行进一步，具体的处理
    //比如做缓存，比如数据持久化，然后等被请求的服务好了之后，在做进一步的处理
    @Override
    public ResponseDTO noticeDealScore(String json) {
        ResponseDTO responseDTO = new ResponseDTO(ReturnCode.ACTIVE_FAILURE);
        return responseDTO;
    }
}
