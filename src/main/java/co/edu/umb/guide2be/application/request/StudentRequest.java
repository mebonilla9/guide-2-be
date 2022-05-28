package co.edu.umb.guide2be.application.request;

public record StudentRequest(
  Integer id,
  String firstName,
  String lastName,
  String program,
  Boolean enable) {
}
