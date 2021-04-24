package com.yhyy.quickrecy.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IceWolf on 2019/9/13.
 */
public class Contracts {
    public static final List<String> typeList = new ArrayList<String>() {//设置列表
        {
            add(new String("包含头部"));
            add(new String("包含尾部"));
            add(new String("包含头部底部"));
        }
    };
}
