/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyrate;

/**
 *
 * @author archer
 */
public class MainApp {

    
    public static void main(String[] args) {
        CurrencyRate cr = new CurrencyRate(CurrencyRate.STATE_BANK);
        System.out.println("Худалдах:" + cr.getRate(CurrencyRate.RUB_CODE, true));
        System.out.println("Зарах:" + cr.getRate(CurrencyRate.RUB_CODE, false));
        System.out.println("Ruble -> Dollar: " + cr.convert(CurrencyRate.RUB_CODE, CurrencyRate.USD_CODE, 550));
    }
}
