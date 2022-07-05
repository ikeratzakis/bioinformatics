/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5152;

/**
 *
 * @author Keratz
 */
public class NoStrings {

    static void state0() throws TerminateException{
        System.out.println("State 0");
        throw new TerminateException("Rejected");
    }
            
    static void state1() throws TerminateException{
        System.out.println("State 1");
                throw new TerminateException("Accepted");
    }
    public static void main(String[] args) {
        if (args.length == 0)
        {
            try
            {
            state1();
            }
            catch (TerminateException e)
            {
                //terminate execution
            }
        }
        else
        {
           try
           {
               state0();
           }
           catch(TerminateException e)
           {
               //terminate execution
           }
        }
          
        
    }
    
}
 class TerminateException extends Exception{
        public TerminateException(String message) {
            System.out.println(message);
        }
    }

