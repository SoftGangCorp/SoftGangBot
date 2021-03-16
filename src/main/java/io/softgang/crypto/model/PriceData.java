package io.softgang.crypto.model;

public class PriceData {
    private String disclaimer;
    private BitcoinIndexData bpi;

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public BitcoinIndexData getBpi() {
        return bpi;
    }

    public void setBpi(BitcoinIndexData bpi) {
        this.bpi = bpi;
    }
}
