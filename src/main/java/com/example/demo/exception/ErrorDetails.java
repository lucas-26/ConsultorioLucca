package com.example.demo.exception;
import java.util.Date;

public class ErrorDetails {

	private Date timestamp;
	private String messagem;
	private String details;
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessagem() {
		return messagem;
	}
	public void setMessagem(String messagem) {
		this.messagem = messagem;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	public ErrorDetails(Date timestamp, String messagem, String details) {
		super();	
		this.timestamp = timestamp;
		this.messagem = messagem;
		this.details = details;
	}
	
	
	
}
