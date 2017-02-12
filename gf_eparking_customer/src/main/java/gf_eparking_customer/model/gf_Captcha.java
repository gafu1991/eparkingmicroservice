package gf_eparking_customer.model;

import nl.captcha.Captcha;

public class gf_Captcha {

private String captcha;
private Captcha session;
	
	public gf_Captcha(String captcha, Captcha session)
	{
		this.captcha = captcha;
		this.session = session;
	}
	
	public void setCaptcha(String captcha)
	{
		this.captcha = captcha;
	}
	
	public void setSession(Captcha session)
	{
		this.session = session;
	}
	
	public String getCaptcha()
	{
		return captcha;
	}
	
	public Captcha getSession()
	{
		return session;
	}
	
	
}
