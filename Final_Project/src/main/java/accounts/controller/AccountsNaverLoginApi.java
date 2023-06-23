package accounts.controller;

import com.github.scribejava.core.builder.api.DefaultApi20;

public class AccountsNaverLoginApi extends DefaultApi20 {

	  protected AccountsNaverLoginApi(){
	    }
	 
	    private static class InstanceHolder{
	        private static final AccountsNaverLoginApi INSTANCE = new AccountsNaverLoginApi();
	    }
	 
	 
	    public static AccountsNaverLoginApi instance(){
	        return InstanceHolder.INSTANCE;
	    }
	 
	    @Override
	    public String getAccessTokenEndpoint() {
	        return "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code";
	    }                   
	 
	    @Override
	    protected String getAuthorizationBaseUrl() {
	        return "https://nid.naver.com/oauth2.0/authorize";
	    }   
	}
