package geektime.spring.mongodemo.converter;

import org.bson.Document;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2020-02-03 09:31
 */
public class MoneyReadConverter implements Converter<Document, Money> {
    @Override
    public Money convert(Document source) {

        Document money = (Document) source.get("money");
        double amount = Double.parseDouble(money.getString("amount"));
        String currency = ((Document) money.get("currency")).getString("code");
        return Money.of(CurrencyUnit.of(currency), amount);
    }
}
