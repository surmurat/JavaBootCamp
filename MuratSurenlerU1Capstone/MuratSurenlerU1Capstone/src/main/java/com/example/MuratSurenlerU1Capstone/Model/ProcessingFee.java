package com.example.MuratSurenlerU1Capstone.Model;

import java.math.BigDecimal;
import java.util.Objects;

public class ProcessingFee {

    private String productType;
    private BigDecimal fee;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessingFee that = (ProcessingFee) o;
        return getFee() == that.getFee() &&
                Objects.equals(getProductType(), that.getProductType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFee(), getProductType());
    }
}
