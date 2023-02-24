package Extend.Interview.Entity.GetVirtualCards;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.text.NumberFormat;
import java.util.Locale;
@JsonPropertyOrder({
        "id",
        "status",
        "recipient",
        "expires",
        "currency",
        "limitCents",
        "spentCents",
        "balanceCents",
        "remainingBalanceDollars",
        "last4"
})
public class VirtualCard {

    @JsonProperty("id")
    String id;
    @JsonProperty("status")
    String status;
    @JsonProperty("recipient")
    Recipient recipient;
    @JsonProperty("expires")
    String expires;
    @JsonProperty("currency")
    String currency;
    @JsonProperty("limitCents")
    long limitCents;
    @JsonProperty("balanceCents")
    long balanceCents;
    @JsonProperty("spentCents")
    long spentCents;
    @JsonProperty("last4")
    String last4;

    String remainingBalanceDollars;
    NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);

    public VirtualCard(String id, String status, Recipient recipient, String expires, String currency, long limitCents, long balanceCents, long spentCents, String last4) {
        this.id = id;
        this.status = status;
        this.recipient = recipient;
        this.expires = expires;
        this.currency = currency;
        this.limitCents = limitCents;
        this.balanceCents = balanceCents;
        this.spentCents = spentCents;
        this.last4 = last4;
        this.remainingBalanceDollars = nf.format(balanceCents / 100.00);
    }

    public VirtualCard() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getLimitCents() {
        return limitCents;
    }

    public void setLimitCents(long limitCents) {
        this.limitCents = limitCents;
    }

    public long getBalanceCents() {
        return balanceCents;
    }

    public void setBalanceCents(long balanceCents) {
        this.balanceCents = balanceCents;
    }

    public long getSpentCents() {
        return spentCents;
    }

    public void setSpentCents(long spentCents) {
        this.spentCents = spentCents;
    }

    public String getLast4() {
        return last4;
    }

    public void setLast4(String last4) {
        this.last4 = last4;
    }

    public String getRemainingBalanceDollars() {
        return remainingBalanceDollars = nf.format(balanceCents / 100.00);
    }

    public void setRemainingBalanceDollars() {
        this.remainingBalanceDollars = remainingBalanceDollars;
    }
}
