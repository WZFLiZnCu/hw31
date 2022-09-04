package com.hw31.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("brand")
public class Brand {
    @TableId("bid")
    private Integer bid;
    private String bname;
    private Integer classid;
}
