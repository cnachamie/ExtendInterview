package Extend.Interview.Entity.GetTransactionDetails;


import Extend.Interview.Entity.GetAllTransactions.Transactions;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionDetails extends Transactions {
    @JsonProperty("id")
    String transactionId;
    @JsonProperty("recipientId")
    String recipientId;
    @JsonProperty("nameOnCard")
    String nameOnCard;
    @JsonProperty("source")
    String source;
    @JsonProperty("vcnLast4")
    String vcnLast4;
    @JsonProperty("type")
    String type;
    @JsonProperty("authBillingCurrency")
    String authBillingCurrency;
    @JsonProperty("mccGroup")
    MccGroup mccGroup;
    @JsonProperty("mccDescription")
    String mccDescription;
    @JsonProperty("authedAt")
    String authedAt;

    public TransactionDetails(String id, Status status, long authBillingAmountCents, String merchantName, String transactionId, String recipientId, String nameOnCard, String source, String vcnLast4, String type, String authBillingCurrency, MccGroup mccGroup, String mccDescription, String authedAt) {
        super(id, status, authBillingAmountCents, merchantName);
        this.transactionId = transactionId;
        this.recipientId = recipientId;
        this.nameOnCard = nameOnCard;
        this.source = source;
        this.vcnLast4 = vcnLast4;
        this.type = type;
        this.authBillingCurrency = authBillingCurrency;
        this.mccGroup = mccGroup;
        this.mccDescription = mccDescription;
        this.authedAt = authedAt;
    }

    public TransactionDetails() {
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getVcnLast4() {
        return vcnLast4;
    }

    public void setVcnLast4(String vcnLast4) {
        this.vcnLast4 = vcnLast4;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthBillingCurrency() {
        return authBillingCurrency;
    }

    public void setAuthBillingCurrency(String authBillingCurrency) {
        this.authBillingCurrency = authBillingCurrency;
    }

    public MccGroup getMccGroup() {
        return mccGroup;
    }

    public void setMccGroup(MccGroup mccGroup) {
        this.mccGroup = mccGroup;
    }

    public String getMccDescription() {
        return mccDescription;
    }

    public void setMccDescription(String mccDescription) {
        this.mccDescription = mccDescription;
    }

    public String getAuthedAt() {
        return authedAt;
    }

    public void setAuthedAt(String authedAt) {
        this.authedAt = authedAt;
    }
}
