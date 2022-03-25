package co.edu.umb.guide2be.application.request;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserRequest(
  String username,
  String password,
  Integer level) {
}
