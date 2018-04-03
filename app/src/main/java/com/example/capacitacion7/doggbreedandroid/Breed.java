package com.example.capacitacion7.doggbreedandroid;

/**
 * Created by capacitacion7 on 16-03-18.
 */

public class Breed {

    private String market_id;
    private String[] last_price;
    private String[] min_ask;
    private String[] max_bid;
    private String[] volume;
    private String price_variation_24h;
    private String price_variation_7d;

    /*public Breed(String market_id, String[] last_price, String[] min_ask, String[] max_bid, String[] volume, String price_variation_24h, String price_variation_7d) {
        this.market_id = market_id;
        this.last_price = last_price;
        this.min_ask = min_ask;
        this.max_bid = max_bid;
        this.volume = volume;
        this.price_variation_24h = price_variation_24h;
        this.price_variation_7d = price_variation_7d;
    }*/

    public String getPrice_variation_24h() {
        return price_variation_24h;
    }

    public void setPrice_variation_24h(String price_variation_24h) {
        this.price_variation_24h = price_variation_24h;
    }

    public String getMarket_id() {
        return market_id;
    }

    public void setMarket_id(String market_id) {
        this.market_id = market_id;
    }

    public String[] getLast_price() {
        return last_price;
    }

    public void setLast_price(String[] last_price) {
        this.last_price = last_price;
    }

    public String[] getMin_ask() {
        return min_ask;
    }

    public void setMin_ask(String[] min_ask) {
        this.min_ask = min_ask;
    }

    public String[] getMax_bid() {
        return max_bid;
    }

    public void setMax_bid(String[] max_bid) {
        this.max_bid = max_bid;
    }

    public String[] getVolume() {
        return volume;
    }

    public void setVolume(String[] volume) {
        this.volume = volume;
    }

    public String getPrice_variation_7d() {
        return price_variation_7d;
    }

    public void setPrice_variation_7d(String price_variation_7d) {
        this.price_variation_7d = price_variation_7d;
    }
}
