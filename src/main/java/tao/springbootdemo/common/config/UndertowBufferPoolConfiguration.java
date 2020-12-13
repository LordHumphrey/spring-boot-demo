package tao.springbootdemo.common.config;

import io.undertow.server.DefaultByteBufferPool;
import io.undertow.websockets.jsr.WebSocketDeploymentInfo;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 * @Author: Tao
 * @Time: 2020/12/7 11:55
 * @ProjectName：spring-boot-demo
 * @FileName: UndertowBufferPoolConfiguration.java
 * @IDE: IntelliJ IDEA
 */

@Component
public class UndertowBufferPoolConfiguration implements WebServerFactoryCustomizer<UndertowServletWebServerFactory> {
    @Override
    public void customize(UndertowServletWebServerFactory factory) {
        factory.addDeploymentInfoCustomizers(deploymentInfo -> {
            WebSocketDeploymentInfo webSocketDeploymentInfo = new WebSocketDeploymentInfo();
            webSocketDeploymentInfo.setBuffers(new DefaultByteBufferPool(false, 1024));
            deploymentInfo.addServletContextAttribute("io.undertow.websockets.jsr" +
                    ".WebSocketDeploymentInfo", webSocketDeploymentInfo);
        });
    }


}
