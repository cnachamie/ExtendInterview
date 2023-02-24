package Extend.Interview.Service;

import Extend.Interview.Entity.Exceptions.CustomException;
import Extend.Interview.Entity.GetAllTransactions.Transactions;
import Extend.Interview.Entity.GetTransactionDetails.TransactionDetails;
import Extend.Interview.Entity.GetVirtualCards.VirtualCard;

import java.util.List;
import java.util.Map;

public interface VirtualCardService {
    public List<VirtualCard> getAllVirtualCards(Map<String,String> headers);
    public List<Transactions> getAllTransactions(Map<String,String> headers, String cardId, String status) throws CustomException;
    public TransactionDetails getTransactionDetails(Map<String,String> headers, String transactionId);

}
