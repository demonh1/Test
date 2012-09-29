/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package B;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.*;

/**
 *
 * @author Admin
 */
public class BClass extends Agent {

    @Override
    protected void setup() {
System.out.println("Hello Agent"+getAID().getName()+" готов.");
addBehaviour(new CyclicBehaviour(this) {

public void action() {
ACLMessage msg = receive();
if (msg != null) {
System.out.println(" – " +
myAgent.getLocalName() +
" received: "
+ msg.getContent() );
//Вывод на экран локального имени агента и полученного сообщения
ACLMessage reply = msg.createReply();
reply.setPerformative( ACLMessage.INFORM );
reply.setContent( "Pong");
//Содержимое сообщения
send(reply); //отправляем сообщения
}
block();
}
});
}

}
