package vip.pryun.dikas.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 59941
 * @date 2019/5/28 12:19
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SecurityConfig implements WebMvcConfigurer {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*@Bean
    public UserDetailsService userDetailsService() throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .roles("USER").build());
        return manager;
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    public interface BankService {
//
//        @PreAuthorize("isAnonymous()")
//        public Account readAccount(Long id);
//
//        @PreAuthorize("isAnonymous()")
//        public Account[] findAccounts();
//
//        @PreAuthorize("hasAuthority('ROLE_TELLER')")
//        public Account post(Account account, double amount);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
//                    public <O extends FilterSecurityInterceptor> O postProcess(
//                            O fsi) {
//                        fsi.setPublishAuthorizationSuccess(true);
//                        return fsi;
//                    }
//                });
//    }


}