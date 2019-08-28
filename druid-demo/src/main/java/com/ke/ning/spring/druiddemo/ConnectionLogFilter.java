package com.ke.ning.spring.druiddemo;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2019-08-28 09:55
 */
@Slf4j
public class ConnectionLogFilter extends FilterEventAdapter {

    @Override
    public void connection_connectBefore(FilterChain chain, Properties info) {
        log.info("before connection ...");
    }

    @Override
    public void connection_connectAfter(ConnectionProxy connection) {
        log.info("after connection ...");
    }
}
