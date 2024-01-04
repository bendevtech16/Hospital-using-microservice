package uy1.inf331.patientservice.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix = "global.params")
@Data @AllArgsConstructor @NoArgsConstructor
public class GlobalConfig{
    private  int p1;
    private int p2;

}
