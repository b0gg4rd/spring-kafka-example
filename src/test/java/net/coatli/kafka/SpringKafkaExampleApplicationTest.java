package net.coatli.kafka;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringKafkaExampleApplicationTest {

  @Autowired
  private Sender sender;

  @Autowired
  private Receiver receiver;

	@Test
	public void thatReceiveMessageWorks()
	    throws InterruptedException {
	  // given
	  sender.sendMessage("example.t", "Hello Spring Kafka!");

	  // when
	  receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);

	  // then
	  assertTrue(receiver.getLatch().getCount() == 0);

	}

}
