package com.lrostech.challenge.aws_file_manager.domain.contract.infra;

public interface ITokenManagement {
    String generateToken(String username);
    boolean validateToken(String token);
    String getUsernameFromToken(String token);
}
