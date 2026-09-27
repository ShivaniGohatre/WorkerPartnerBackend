package com.workerpartner.home.register.verification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VerificationResponse {
 
	private boolean isVerified;
	private String message;
	
	
}
