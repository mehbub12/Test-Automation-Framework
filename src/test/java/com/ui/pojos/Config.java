package com.ui.pojos;

import java.util.HashMap;
import java.util.Map;

public class Config {

	
		Map<String,Environment> environments;

		public Map<String, Environment> getEnvrionments() {
			return environments;
		}

		public void setEnvrionments(Map<String, Environment> envrionments) {
			this.environments = envrionments;
		}
		

}
