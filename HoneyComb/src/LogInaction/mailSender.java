package LogInaction;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class mailSender {

	public int emailSender(String mail) throws MessagingException{
        // ���� ���� ����
        String host = "smtp.gmail.com";
        String username = "honeycomb0727@gmail.com";
        String password = "honeycombo123";
        //���� �Լ� i(������ȣ)
        int i = (int)(Math.random()*999999)+1;
        // ���� ����
        String recipient = mail;//�̸����ּ�
        String subject = "�������� ����� �߼� �׽�Ʈ�Դϴ�."; //����
        String j = String.valueOf(i);
        String body = "�̰��� ����� �̸��Ͽ� �´� ������ȣ�� ã�� ���� �̸��� �Դϴ� \n ������ȣ "+j+"�� �Է����ּ���";	
         System.out.println(i);
        //properties ����
        Properties props = new Properties();
        props.put("mail.smtps.auth", "true");
        // ���� ����
        Session session = Session.getDefaultInstance(props);
        MimeMessage msg = new MimeMessage(session);
 
        // ���� ����
        msg.setSubject(subject);
        msg.setText(body);
        msg.setFrom(new InternetAddress(username));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
 
        // �߼� ó��
        Transport transport = session.getTransport("smtps");
        transport.connect(host, username, password);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();    
        return i;
    }
}