package com.fly.common.model;


/**
 * Created by jinxiaofei on 16/3/29.
 * role种类,管理员,库存,收银员,普通员工
 */

public enum RoleEnum implements EnumValue {
    ADMIN(1,"管理员"), STOCK_MANAGER(2,"库存管理员"), CASHIER(3,"收银员"), COMMON_STAFF(4,"普通员工");

    private final int value;
    private final String name;

    RoleEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name;
    }


    public static RoleEnum valueOf(int value) {
        RoleEnum[] values = RoleEnum.values();
        for (RoleEnum roleEnum : values) {
            if (roleEnum.getValue() == value) {
                return roleEnum;
            }
        }

        return null;
    }

}
