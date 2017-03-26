package ru.iemz.adwords.auth;

/**
 * Created by Vladimir Aseev on 13.03.2017.
 *
 * DTO для хранения
 * авторизационных данных Google.Adwords
 */
public class Credentials {

    private final String clientId;
    private final String clientSecret;
    private final String clientCustomerId;
    private final String refreshToken;
    private final String developerToken;


    public Credentials(String clientId,
                       String clientSecret,
                       String clientCustomerId,
                       String refreshToken,
                       String developerToken) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.clientCustomerId = clientCustomerId;
        this.refreshToken = refreshToken;
        this.developerToken = developerToken;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getClientCustomerId() {
        return clientCustomerId;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getDeveloperToken() {
        return developerToken;
    }
}
