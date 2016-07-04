package Email;

import javax.mail.*;

public class MyAuthenticator extends Authenticator
{
	String userName = null;
	String password = null;

	public MyAuthenticator()
	{
	}

	public MyAuthenticator(String username, String password)
	{
		this.userName = username;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication()
	{
		return new PasswordAuthentication(userName, password);
	}

	public void SendEmail(String ToAddr, String Content)
	{

		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.qq.com");
		mailInfo.setMailServerPort("587");
		mailInfo.setValidate(true);
		mailInfo.setUserName("1063686790");
		mailInfo.setPassword("fz1123b");
		mailInfo.setFromAddress("1063686790@qq.com");
		mailInfo.setToAddress(ToAddr);
		mailInfo.setSubject("Item Sold");
		mailInfo.setContent(Content);

		SimpleMailSender sms = new SimpleMailSender();
		sms.sendTextMail(mailInfo);
		sms.sendHtmlMail(mailInfo);
	}
	
	public void ConfirmEmail(String username, String email, String type)
	{
		StringBuffer sb = new StringBuffer("Thanks for join Kiwi online bookstore\n");
		sb.append("Dear " + username + "\nPlease go to this url to confirm your registration:\n");
		sb.append("http://localhost:8080/MyBookStore/Confirmation.jsp?=");
		sb.append(username);
		sb.append("=");
		sb.append(email);
		sb.append("=");
		sb.append(type);
		sb.append("\"");
		String str = sb.toString();
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.qq.com");
		mailInfo.setMailServerPort("587");
		mailInfo.setValidate(true);
		mailInfo.setUserName("1063686790");
		mailInfo.setPassword("fz1123b");
		mailInfo.setFromAddress("1063686790@qq.com");
		mailInfo.setToAddress(email);
		mailInfo.setSubject("Thanks for join Kiwi online bookstore");
		mailInfo.setContent(str);

		SimpleMailSender sms = new SimpleMailSender();
		sms.sendTextMail(mailInfo);
		sms.sendHtmlMail(mailInfo);
	}


}
