package projectClass;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;

public class HelloWorld {

	@Resource(lookup="jms/ConnectionFactory")
	private static ConnectionFactory cf;
	@Resource(lookup = "jms/Queue")
	private static Queue queue;
	
	public static void print() {
		try {
		Connection con = cf.createConnection();
		Session  s =con.createSession();
		s.createProducer(queue);
		MessageConsumer consumer= s.createConsumer(null);
		consumer.receive();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
