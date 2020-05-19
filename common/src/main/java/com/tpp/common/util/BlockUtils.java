package com.tpp.common.util;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * Created by smlz on 2020/2/13.
 */
public class BlockUtils {


    public static String testHelloSentinelV3BlockMethod(BlockException e){
        System.out.println("testHelloSentinelV3方法被流控了");
        return "testHelloSentinelV3方法被流控了";
    }
}
