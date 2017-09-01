package com.yytec.dogmell.models;

import lombok.Data;

import java.io.Serializable;

/**
 * 01/09/2017 15:46
 *
 * @author yangqiankun
 */
@Data
public class Permissions implements Serializable {
    private String role;
    private String[] visit;

}
