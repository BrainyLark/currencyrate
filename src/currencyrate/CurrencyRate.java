package currencyrate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author archer
 */
public class CurrencyRate {

    public static final int GOLOMT_BANK = 3;
    public static final int KHAAN_BANK = 6;
    public static final int KHAS_BANK = 5;
    public static final int CREDIT_BANK = 19;
    public static final int CAPITAL_BANK = 20;
    public static final int CAPITRON_BANK = 10;
    public static final int STATE_BANK = 8;
    
    public static final int USD_CODE = 1;
    public static final int CNY_CODE = 2;
    public static final int RUB_CODE = 3;
    public static final int EUR_CODE = 4;
    public static final int KRW_CODE = 5;
    public static final int GBR_CODE = 6;
    public static final int JPY_CODE = 7;
    
    private List<Valute> currencies;

    public CurrencyRate(int BANK_CODE) {
        try {
            currencies = new ArrayList();
            Document doc = Jsoup.connect("http://news.gogo.mn/exchange").get();
            Element e = doc.selectFirst("div[bank="+BANK_CODE+"]");
            e.select("tr[t]").forEach(el -> {
                int code = Integer.valueOf(el.attr("t"));
                double purchaseVal = Double.valueOf(el.selectFirst("td[class=vert_zeb valtd]").getElementsByClass("val").text().replace(",", ""));
                double sellVal = Double.valueOf(el.selectFirst("td[class=valtd]").getElementsByClass("val").text().replace(",", ""));
                
                currencies.add(new Valute(code, purchaseVal, sellVal));
            });
            System.out.println("Completed");
        } catch (IOException ex) {
            System.out.println("Error occured IOException " + ex.getMessage());
        }
    }

    public double getRate(int CURRENCY_CODE, boolean buy) {
        Valute valute = currencies.get(CURRENCY_CODE - 1);
        return (buy) ? valute.getPurchaseValue() : valute.getSellValue();
    }

    public double convert(int FROM_CURRENCY, int TO_CURRENCY, double value) {
        double ratio = (double) value * (currencies.get(FROM_CURRENCY-1).getSellValue() / currencies.get(TO_CURRENCY-1).getSellValue());
        return ratio;
    }
    
}
