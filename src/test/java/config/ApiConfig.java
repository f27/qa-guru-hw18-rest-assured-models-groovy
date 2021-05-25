package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/api.properties"
})
public interface ApiConfig extends Config{
    @Key("api.base.url")
    String apiBaseURL();

    @Key("api.base.path")
    String apiBasePath();
}
