/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.zahtev;

import java.io.Serializable;

/**
 *
 * @author Stefan
 */
public class RequestObject implements Serializable{
    private int operation;
    private Object data;

    public RequestObject(int operation, Object data) {
        this.operation = operation;
        this.data = data;
    }

    public RequestObject() {
    }
    

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    
}
