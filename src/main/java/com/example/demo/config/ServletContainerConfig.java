package com.example.demo.config;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.File;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ServletContainerConfig {

    @Bean
    public ServletWebServerFactory servletContainer() {
        // 创建 Tomcat 容器工厂
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        // 添加 HTTPS 连接器
        tomcat.addAdditionalTomcatConnectors(createHttpsConnector());
        return tomcat;
    }

    private Connector createHttpsConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("https");
        connector.setSecure(true);
        connector.setPort(8443);  // HTTPS 端口
        connector.setAttribute("sslProtocol", "TLS");
        connector.setAttribute("SSLEnabled", true);
        connector.setAttribute("keystoreFile", loadKeystoreFile("keystore.p12"));
        connector.setAttribute("keystorePass", "zxcvbnm");
        connector.setAttribute("keyAlias", "mycert");
        connector.setAttribute("keyStoreType", "PKCS12");
        return connector;

    }
    private String loadKeystoreFile(String path) {
        try {
            Resource resource = new ClassPathResource(path);
            File tempFile = File.createTempFile("keystore", ".p12");
            try (InputStream is = resource.getInputStream();
                 FileOutputStream os = new FileOutputStream(tempFile)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = is.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }
            tempFile.deleteOnExit(); // 确保应用程序退出时删除临时文件
            return tempFile.getAbsolutePath();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load keystore file", e);
        }
    }
}
