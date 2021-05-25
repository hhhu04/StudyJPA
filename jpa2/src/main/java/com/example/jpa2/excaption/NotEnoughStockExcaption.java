package com.example.jpa2.excaption;

import lombok.AllArgsConstructor;

public class NotEnoughStockExcaption extends RuntimeException{

    public NotEnoughStockExcaption(){
        super();
    }
    
    public NotEnoughStockExcaption(String message){
        super(message);
    }
    public NotEnoughStockExcaption(String message,Throwable cause){
        super(message, cause);
    }
    
    public NotEnoughStockExcaption(Throwable cause){
        super(cause);
    }
    
}
