package bom.entity;

import lombok.Getter;

@Getter
public enum StatusZgloszenia {
    STATUS_PRZYJETE("PRZYJĘTĘ"),
    STATUS_W_REALIZACJI("W REALIZACJI"),
    STATUS_WYKONANE("WYKONANE"),
    STATUS_NIEWYKONANE("NIEWYKONANE");

    private String statusName;

    StatusZgloszenia(String statusName) {
        this.statusName = statusName;
    }
}
