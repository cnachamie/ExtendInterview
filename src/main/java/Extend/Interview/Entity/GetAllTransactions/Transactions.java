package Extend.Interview.Entity.GetAllTransactions;

import Extend.Interview.Entity.GetTransactionDetails.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.text.NumberFormat;
import java.util.Locale;
@JsonPropertyOrder({
        "id",
        "status",
        "authBillingAmountCents",
        "billingAmountDollars",
        "merchantName"
})
public class Transactions {
    @JsonProperty("id")
    String id;
    @JsonProperty("status")
    Status status;
    @JsonProperty("authBillingAmountCents")
    long authBillingAmountCents;
    @JsonProperty("merchantName")
    String merchantName;

    String billingAmountDollars;
    NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);

    public Transactions(String id, Status status, long authBillingAmountCents, String merchantName) {
        this.id = id;
        this.status = status;
        this.authBillingAmountCents = authBillingAmountCents;
        this.merchantName = merchantName;
        this.billingAmountDollars = nf.format(authBillingAmountCents / 100.00);
    }

    public Transactions() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getAuthBillingAmountCents() {
        return authBillingAmountCents;
    }

    public void setAuthBillingAmountCents(long authBillingAmountCents) {
        this.authBillingAmountCents = authBillingAmountCents;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }


    public void setBillingAmountDollars() {
        this.billingAmountDollars = billingAmountDollars;
    }

    public String getBillingAmountDollars() {
        return nf.format(authBillingAmountCents / 100.00);
    }
}
