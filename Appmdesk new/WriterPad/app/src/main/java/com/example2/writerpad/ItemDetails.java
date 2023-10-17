package com.example2.writerpad;

public class ItemDetails {


    private String buyerMark;
    private String lotQuantity;
    private String lotName;
    private String bidQuantity;
    private  String packageName;

    public ItemDetails(String buyerMark, String lotQuantity, String lotName, String bidQuantity, String pakageName) {
        this.buyerMark = buyerMark;
        this.lotQuantity = lotQuantity;
        this.lotName = lotName;
        this.bidQuantity = bidQuantity;
        this.packageName = pakageName;
    }

    public String getBuyerMark() {
        return buyerMark;
    }

    public String getLotQuantity() {
        return lotQuantity;
    }

    public String getLotName() {
        return lotName;
    }

    public String getBidQuantity() {
        return bidQuantity;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setBuyerMark(String buyerMark) {
        this.buyerMark = buyerMark;
    }

    public void setLotQuantity(String lotQuantity) {
        this.lotQuantity = lotQuantity;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    public void setBidQuantity(String bidQuantity) {
        this.bidQuantity = bidQuantity;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
