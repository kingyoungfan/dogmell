package com.yytec.dogmell.models;

import lombok.Data;

import java.io.Serializable;

/**
 * 01/09/2017 16:52
 *
 * @author yangqiankun
 */
@Data
public class Menu implements Serializable {
    private String id;
    private String icon;
    private String name;
    private String route;
    private String bpid;
}
