package com.example.task03;

public class Hours implements TimeUnit{

    private final long amount;

    public Hours(long amout){
        this.amount = amout;
    }

    @Override
    public long toMillis() {
        return (amount * 3600000);
    }

    @Override
    public long toSeconds() {
        return (amount * 3600);
    }

    @Override
    public long toMinutes() {
        return (amount * 60);
    }

    @Override
    public long toHours() {
        return amount;
    }

}
