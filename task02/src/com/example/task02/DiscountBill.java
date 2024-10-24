package com.example.task02;

public class DiscountBill extends Bill{

    private final double  discount;

    public DiscountBill(double discount){
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public long getAbsolutePrice(){
        return super.getPrice() - getPrice();
    }

    public long getPrice(){
        long price = super.getPrice();
        return (long) (price - price * (discount/100));
    }
}
