package Extend.Interview.Controller;

import Extend.Interview.Entity.Exceptions.CustomExceptionReturnObject;
import Extend.Interview.Entity.Exceptions.CustomException;
import Extend.Interview.Entity.GetAllTransactions.Transactions;
import Extend.Interview.Entity.GetTransactionDetails.TransactionDetails;
import Extend.Interview.Entity.GetVirtualCards.VirtualCard;
import Extend.Interview.Service.VirtualCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/virtualCards")
public class VirtualCardController {

    @Autowired
    VirtualCardService virtualCardService;

    @GetMapping("/getAllCards")
    public ResponseEntity<Object> getAllVirtualCardsForUser(
            @RequestHeader Map<String,String> headers) {
        List<VirtualCard> list = null;
        try {
            list = virtualCardService.getAllVirtualCards(headers);
        } catch (Exception e) {
            return handleGenericException(e);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{cardId}/getAllTransactions")
    public ResponseEntity<Object> getTransactions(
            @RequestHeader Map<String,String> headers,
            @PathVariable("cardId") String cardId,
            @RequestParam(value = "status", required = false) String status) {
        List<Transactions> list = null;
        try {
            list = virtualCardService.getAllTransactions(headers, cardId, status);
        } catch (CustomException ce) {
            return handleCustomException(ce);
        } catch (Exception e) {
            return handleGenericException(e);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping("/getTransaction")
    public ResponseEntity<Object> getTransactionDetail(
            @RequestHeader Map<String,String> headers,
            @RequestParam(value = "transactionId") String transactionId) {
        TransactionDetails transactionDetails = null;
        try {
            transactionDetails = virtualCardService.getTransactionDetails(headers, transactionId);
        } catch (Exception e) {
            return handleGenericException(e);
        }
        return new ResponseEntity<>(transactionDetails, HttpStatus.OK);
    }

    private ResponseEntity<Object> handleGenericException(Exception e) {
        if(e.getMessage().contains("401")) {
            return new ResponseEntity<>(new CustomExceptionReturnObject("Authorization is missing or has expired"), HttpStatus.UNAUTHORIZED);
        }
        else if(e.getMessage().contains("406")) {
            return new ResponseEntity<>(new CustomExceptionReturnObject("Accept header is missing or is invalid, need to include API version"), HttpStatus.NOT_ACCEPTABLE);
        }
        else {
            return new ResponseEntity<>(new CustomExceptionReturnObject("Something is wrong with your request"), HttpStatus.BAD_REQUEST);
        }
    }

    private ResponseEntity<Object> handleCustomException(CustomException ce) {
        return new ResponseEntity<>(new CustomExceptionReturnObject(ce.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
