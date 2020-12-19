package com.dc.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VoInfo implements Serializable {
    private String avatar;
    private String introduction;
    private String name;
    private List roles;

}
