package bom.entity;

public enum StatusZgloszenia {
    STATUS_PRZYJETE("PRZYJĘTĘ"),
    STATUS_W_REALIZACJI("W REALIZACJI"),
    STATUS_WYKONANE("WYKONANE"),
    STATUS_NIEWYKONANE("NIEWYKONANE");

    private String status;

    StatusZgloszenia(String status) {
        this.status = status;
    }
}
