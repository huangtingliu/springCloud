package com.huangtl.gateway.config;

import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.init.InitFunc;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * @Description 这是sentinel连接nacos存储规则的第二种方式，第一种方式查看application-sentinel.yml文件
 * @Author huangtl
 * @Date 2020/9/24 16:37
 **/
public class SentinelDataSourceInitFunc implements InitFunc {

    @Override
    public void init() throws Exception {
        final String remoteAddress = "192.168.67.129";
        final String groupId = "Sentinel:Demo";
        final String dataId = "sentinel";

        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>(remoteAddress, groupId, dataId,
                source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {}));
        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());
    }

}
