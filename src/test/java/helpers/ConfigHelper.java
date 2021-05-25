package helpers;

import config.ApiConfig;
import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {
    private static final ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());

    public static String getApiBaseURL() {
        return apiConfig.apiBaseURL();
    }

    public static String getApiBasePath() {
        return apiConfig.apiBasePath();
    }
}
