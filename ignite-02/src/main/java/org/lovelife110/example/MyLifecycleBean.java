package org.lovelife110.example;

import org.apache.ignite.Ignite;
import org.apache.ignite.lifecycle.LifecycleBean;
import org.apache.ignite.lifecycle.LifecycleEventType;
import org.apache.ignite.resources.IgniteInstanceResource;

public class MyLifecycleBean implements LifecycleBean {
    @IgniteInstanceResource
    public Ignite ignite;

    @Override
    public void onLifecycleEvent(LifecycleEventType evt) {
        if (evt == LifecycleEventType.BEFORE_NODE_START) {
            System.out.format("Ignite节点的启动程序初始化之前调用；\n");
        } else if (evt == LifecycleEventType.AFTER_NODE_START) {
            System.out.format("Ignite节点启动之后调用。\n");
            System.out.format("Ignite节点(consistentId = %s) 启动之后调用；\n", ignite.cluster().node().consistentId());
        } else if (evt == LifecycleEventType.BEFORE_NODE_STOP) {
            System.out.format("Ignite节点的停止程序初始化之前调用。\n");
        } else if (evt == LifecycleEventType.AFTER_NODE_STOP) {
            System.out.format("Ignite节点停止之后调用。\n");
        }
    }
}