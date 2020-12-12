package com.example.accessingdatamongodb.enums;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "包裹种类枚举类")
public enum ParcelType {
    Clothing /* 服饰 */,
    Sports /* 运动类 */,
    Sanitary /* 卫生用品 */,
    Adults /* 成人用品 */,
    Toy /* 玩具类 */,
    Cosmetics /* 化妆品 */,
    Digital /* 电子品 */,
    Electronic /* 电器类 */
}
