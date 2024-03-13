package com.moreno.login.configuration;

import com.moreno.login.utils.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

  @Value("domain.allowed")
  private String domain;

  /**
   *
   * Bean creator of cors configuration
   *
   * @return CORS w/GET|POST|DELETE|PATCH
   */
  @Bean
  CorsConfigurationSource corsManager() {
    UrlBasedCorsConfigurationSource basedCors = new UrlBasedCorsConfigurationSource();

    CorsConfiguration cors = new CorsConfiguration();

    cors.addAllowedOrigin(domain);

    cors.addAllowedMethod(HttpMethod.GET);
    cors.addAllowedMethod(HttpMethod.POST);
    cors.addAllowedMethod(HttpMethod.DELETE);
    cors.addAllowedMethod(HttpMethod.PATCH);

    basedCors.registerCorsConfiguration("/**", cors);

    return basedCors;
  }

  @Bean
  SecurityFilterChain httpFilterChain(HttpSecurity security) throws Exception {
    security
      // CSRF
      .csrf(csrf -> csrf.disable())
      // CORS CONFIGURATION
      .cors(cors -> corsManager())
      // SESSION MANAGMENT
      .sessionManagement(session ->
        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      )
      // REQUEST AUTHORIZATION CONFIGURATION
      .authorizeHttpRequests(requests -> {
        // permit all url in whitelist (no need auth to access) | the rest of urls =>
        // need to be authenticated
        requests
          .requestMatchers(Constants.WHITE_LIST_MAPPER.toArray(String[]::new))
          .permitAll()
          .anyRequest()
          .authenticated();
      })
      // DENIED ACCESS CONFIGURATION
      .exceptionHandling(); //TODO configure

    return security.build();
  }
}
