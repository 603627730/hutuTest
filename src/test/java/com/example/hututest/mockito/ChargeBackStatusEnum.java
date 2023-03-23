package com.example.hututest.mockito;

/**
 * @author wanghuaixian
 * @date 2022年07月28日 13:26
 */
public enum ChargeBackStatusEnum {
    open(0, "open"), closed(1, "closed"), won(2, "won"), lost(3,"lost"),
//    warning_needs_response(0, "warning_needs_response"),
//    warning_under_review(0, "warning_under_review"),
//    warning_closed(0 , "warning_closed"),
//    needs_response(0, "needs_response"),
//    under_review(0, "under_review"),
//    charge_refunded(1, "charge_refunded"),
    ;

    private int code;
    private String msg;


    ChargeBackStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ChargeBackStatusEnum find(String status) {
        for (ChargeBackStatusEnum value : ChargeBackStatusEnum.values()) {
            if (value.equals(status))
                return ChargeBackStatusEnum.valueOf(status);
        }
        return open;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
