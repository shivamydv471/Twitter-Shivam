package Config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TwitterConfiguration extends Configuration {

    private Oauth oauth;

    @JsonProperty
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("oauth")
    public Oauth getOauth() {
        return oauth;
    }

    @JsonProperty("oauth")
    public void setOauth(Oauth oauth) {
        this.oauth = oauth;
    }

    public class Oauth {
        @NotEmpty
        private String consumerKey;

        @NotEmpty
        private String consumerSecret;

        @NotEmpty
        private String accessToken;

        @NotEmpty
        private String accessTokenSecret;

        @JsonProperty("consumerSecret")
        public String getConsumerSecret() {
            return consumerSecret;
        }

        @JsonProperty("consumerSecret")
        public void setConsumerSecret(String consumerSecret) {
            this.consumerSecret = consumerSecret;
        }

        @JsonProperty("consumerKey")
        public String getConsumerKey() {
            return consumerKey;
        }

        @JsonProperty("consumerKey")
        public void setConsumerKey(String consumerKey) {
            this.consumerKey = consumerKey;
        }

        @JsonProperty("accessToken")
        public String getAccessToken() {
            return accessToken;
        }

        @JsonProperty("accessToken")
        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        @JsonProperty("accessTokenSecret")
        public String getAccessTokenSecret() {
            return accessTokenSecret;
        }

        @JsonProperty("accessTokenSecret")
        public void setAccessTokenSecret(String accessTokenSecret) {
            this.accessTokenSecret = accessTokenSecret;
        }


    }

}
