package com.epam.probation.configuration.property;

import com.epam.probation.model.DTO.ExceptionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "exceptions")
public class ExceptionProperties {

    private Map<String, ExceptionDTO> exceptionMap;
}
