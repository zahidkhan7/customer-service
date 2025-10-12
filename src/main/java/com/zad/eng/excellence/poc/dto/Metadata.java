package com.zad.eng.excellence.poc.dto;

import java.time.LocalDateTime;

public class Metadata {
	
	  private LocalDateTime retrievedAt;
      private String source;

      
      public LocalDateTime getRetrievedAt() {
          return retrievedAt;
      }
      public void setRetrievedAt(LocalDateTime retrievedAt) {
          this.retrievedAt = retrievedAt;
      }

      public String getSource() {
          return source;
      }
      public void setSource(String source) {
          this.source = source;
      }

}
