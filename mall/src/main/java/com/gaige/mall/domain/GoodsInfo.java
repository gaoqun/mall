package com.gaige.mall.domain;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

/**
 * Created by gaige on 2017/9/12.
 */
public class GoodsInfo {
    private String name;
    private String desc;
    private Integer count;
    private BigDecimal price;
    private MultipartFile pic;

    public MultipartFile getPic() {
        return pic;
    }

    public void setPic(MultipartFile pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", fileName=" + pic.getOriginalFilename() +
                '}';
    }
}
