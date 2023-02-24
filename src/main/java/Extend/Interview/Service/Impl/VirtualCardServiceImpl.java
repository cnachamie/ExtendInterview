package Extend.Interview.Service.Impl;

import Extend.Interview.Entity.Exceptions.CustomException;
import Extend.Interview.Entity.Exceptions.CustomExceptionReturnObject;
import Extend.Interview.Entity.GetAllTransactions.Transactions;
import Extend.Interview.Entity.GetTransactionDetails.Status;
import Extend.Interview.Entity.GetTransactionDetails.TransactionDetails;
import Extend.Interview.Entity.GetVirtualCards.AllVirtualCards;
import Extend.Interview.Entity.GetVirtualCards.VirtualCard;
import Extend.Interview.Service.VirtualCardService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class VirtualCardServiceImpl implements VirtualCardService {

    String baseUrl = "https://api.paywithextend.com";
    String authorization = "authorization";
    String accept = "accept";
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<VirtualCard> getAllVirtualCards(Map<String,String> headers) {
        String uri = baseUrl + "/virtualcards";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(accept, headers.get(accept));
        httpHeaders.set(authorization, headers.get(authorization));
        HttpEntity<Void> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<AllVirtualCards> cards = restTemplate.exchange(uri, HttpMethod.GET, entity, AllVirtualCards.class);

        return Objects.requireNonNull(cards.getBody()).getVirtualCards();
    }

    @Override
    public List<Transactions> getAllTransactions(Map<String,String> headers, String cardId, String status) throws CustomException {
        String uri = baseUrl + "/virtualcards/"+cardId+"/transactions";
        if (status != null) {
            uri = validateStatus(status, uri);
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(accept, headers.get(accept));
        httpHeaders.set(authorization, headers.get(authorization));
        HttpEntity<Void> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<Map<String, List<Transactions>>> transactions = restTemplate.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<>() {});

        return Objects.requireNonNull(transactions.getBody()).get("transactions");
    }

    public String validateStatus(String status, String url) throws CustomException {
        if(Arrays.stream(Status.values()).anyMatch(st -> st.name().equals(status))) {
            url = url + "?status=" + status;
        }
        else {
            throw new CustomException("Status value is not valid, has to be one of: PENDING, CLEARED, DECLINED (Case Sensitive)");
        }
        return url;
    }


    @Override
    public TransactionDetails getTransactionDetails(Map<String,String> headers, String transactionId) {
        String uri = baseUrl + "/transactions/" + transactionId;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(accept, headers.get(accept));
        httpHeaders.set(authorization, headers.get(authorization));
        HttpEntity<Void> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<TransactionDetails> transactionDetails = restTemplate.exchange(uri, HttpMethod.GET, entity, TransactionDetails.class);

        return transactionDetails.getBody();
    }
}
