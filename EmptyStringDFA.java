/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioinf5151;

/**
 *
 * @author Keratz
 */
public class EmptyStringDFA{
    String target; //target sequence
    
    public EmptyStringDFA(String s)
    {
        target= s;
        
    }
    void state0() throws TerminateException{
        
        
        {
            System.out.println("State 0");
            if(target.equals("")) state1();
            else throw new TerminateException("Rejected");
        }
    
    }
    void state1() throws TerminateException{
        System.out.println("State 1");
                throw new TerminateException("Accepted");
    }
     public static void main(String[] args)
    {
         if (args.length != 1)
            System.out.println("Usage:java StopDetector string");
        else
        {
            EmptyStringDFA sd = new EmptyStringDFA(args[0]);
            try
            {
                sd.state0();
            }
            catch(TerminateException e)
            {
                //end the execution
            }
        }
       
    }
    
}
class TerminateException extends Exception{
        public TerminateException(String message) {
            System.out.println(message);
        }
    }
