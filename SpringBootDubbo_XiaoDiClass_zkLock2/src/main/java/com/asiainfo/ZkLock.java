package com.asiainfo;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.stereotype.Component;

/**
 * 基于zookeeper的分布式锁
 *
 */
@Component
public class ZkLock {
	private static ZooKeeper zookeeper = null;
	private String path = "/lock";

	static {
		try {
			zookeeper = new ZooKeeper("192.168.14.82:2181,192.168.181.167:2181,192.168.181.168:2181", 5000, new Watcher() {
				@Override
				public void process(WatchedEvent event) {
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void lock() {
		try {
			zookeeper.create(path, "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			while (true) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				try {
					zookeeper.create(path, "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
					break;
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
					continue;
				}
			}
		}
		System.out.println("	zkLock_2获得了分布式锁");
	}

	public void unlock() {
		try {
			zookeeper.delete(path, -1);// version为-1代表不校验version
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
