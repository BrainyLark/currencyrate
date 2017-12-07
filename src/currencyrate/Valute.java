package currencyrate;

public class Valute {
    private int code;
    private double purchaseValue;
    private double sellValue;

    public Valute(int code, double purchaseValue, double sellValue) {
        this.code = code;
        this.purchaseValue = purchaseValue;
        this.sellValue = sellValue;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    
    public void setPurchaseValue(double purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    public void setSellValue(double sellValue) {
        this.sellValue = sellValue;
    }

    public double getPurchaseValue() {
        return purchaseValue;
    }

    public double getSellValue() {
        return sellValue;
    }
    
    
}
