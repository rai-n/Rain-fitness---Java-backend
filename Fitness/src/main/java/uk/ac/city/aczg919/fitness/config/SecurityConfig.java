package uk.ac.city.aczg919.fitness.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import uk.ac.city.aczg919.fitness.services.FitnessUserDetails;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Custom user details service that also records user login
     * history in the database.
     */
    private FitnessUserDetails fitnessUserDetails;

    /**
     * Constructor based dependency injection of custom user details service.
     *
     * @param fitnessUserDetails Used to link the beans to the details service
     */
    @Autowired
    public SecurityConfig(FitnessUserDetails fitnessUserDetails){
        this.fitnessUserDetails = fitnessUserDetails;
    }

    /**
     * Authentication Service is provided by the Configuration module
     * by passing in FitnessUser details
     *
     * @param auth The authentication parameter bean
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .authenticationProvider(authenticationProvider());
    }

    /**
     * Only provide access to the profile and enroll pages to logged in users.
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception{

        http.authorizeRequests()
                .antMatchers("/register","/diet","/fitness")
                .permitAll()
                .antMatchers("/enroll", "/profile","/add","/load","statcount")
                .authenticated()
                .and()
                .formLogin();

        //disable security so that the database console can be accessed.
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    /**
     * PasswordEncoder is applied to FitnessUser and authentication model is made
     * @return DaoAuthenticationProvider container for user details and password encoder
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(fitnessUserDetails);
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authProvider;
    }
}
