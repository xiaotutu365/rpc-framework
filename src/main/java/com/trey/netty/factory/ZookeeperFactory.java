package com.trey.netty.factory;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * zookeeper句柄，可使用该句柄操作zookeeper
 */
public class ZookeeperFactory {

    public static CuratorFramework client;

    public CuratorFramework create() {
        if (client == null) {
            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
            client = CuratorFrameworkFactory.newClient("localhost:2181", retryPolicy);
            client.start();
        }
        return client;
    }
}
