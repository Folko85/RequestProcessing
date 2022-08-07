package ru.gpbi.requestprocessing.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "links.request")
public class LimitProperties {

		private Integer tag;

}
