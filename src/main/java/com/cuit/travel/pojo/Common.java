package com.cuit.travel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true) //链式调用开启
public class Common {
    private String name;
    private String id;
    private String common;
    private String area;
    private String commonDate;
    private long cIndex;
    private String emotionRate;
}
