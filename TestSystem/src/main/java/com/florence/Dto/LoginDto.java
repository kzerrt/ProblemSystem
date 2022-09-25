package com.florence.Dto;

import com.florence.pojo.Count;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Florence
 * TODO: 2022/09/13
 */

@Data
public class LoginDto {

    private Count counts;

    private String type;
 }
