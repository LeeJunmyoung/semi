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
        // 메일 관련 정보
        String host = "smtp.gmail.com";
        String username = "honeycomb0727@gmail.com";
        String password = "honeycombo123";
        //랜덤 함수 i(인증번호)
        int i = (int)(Math.random()*999999)+1;
        // 메일 내용
        String recipient = mail;//이메일주소
        String subject = "지메일을 사용한 발송 테스트입니다."; //내용
        String j = String.valueOf(i);
        String body = "이것은 당신의 이메일에 맞는 인증번호를 찾기 위한 이메일 입니다 \n 인증번호 "+j+"를 입력해주세요";	
         System.out.println(i);
        //properties 설정
        Properties props = new Properties();
        props.put("mail.smtps.auth", "true");
        // 메일 세션
        Session session = Session.getDefaultInstance(props);
        MimeMessage msg = new MimeMessage(session);
 
        // 메일 관련
        msg.setSubject(subject);
        msg.setText(body);
        msg.setFrom(new InternetAddress(username));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
 
        // 발송 처리
        Transport transport = session.getTransport("smtps");
        transport.connect(host, username, password);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();    
        return i;
    }
}