FROM tomcat:10.1.30-jdk17

# Establecer un directo de trabajo
WORKDIR /usr/local/tomcat/webapps/

# Copiar tu archivo .war al contenedor Tomcat
COPY target/horoscopo.war /usr/local/tomcat/webapps/

COPY horoscopo.xlsx /app/horoscopo/

#Exponer el puerto en el que Tomcat correra
EXPOSE 8080

CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]