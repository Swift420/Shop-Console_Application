/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java6;

/**
 *
 * @author Apollos
 */
public interface IObservable {
    void register(BobCard c); // Registers the bobcard to be used for transactions
    void deregister(BobCard c); //de registers the bobcard that was used for transactions when it is done being used.
    void notify1(Double price); //Notifies the Csutomer Account to call the update method when a transcation has been complete, so subtract money from the balance of the account
}
