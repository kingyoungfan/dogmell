package com.yytec.dogmell.models;

import lombok.Data;

import java.io.Serializable;

/**
 * 01/09/2017 15:43
 *
 * @author yangqiankun
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private Permissions permissions;
}
