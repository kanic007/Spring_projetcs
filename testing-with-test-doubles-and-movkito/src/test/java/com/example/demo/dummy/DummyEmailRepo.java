package com.example.demo.dummy;

public class DummyEmailRepo implements EmailRepository {

	@Override
	public String sendMessage(String messag) {
	
		throw new AssertionError("un Implemented");
	}

}
