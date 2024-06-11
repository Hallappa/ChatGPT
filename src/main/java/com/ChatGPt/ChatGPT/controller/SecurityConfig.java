package com.ChatGPt.ChatGPT.controller;

import com.ChatGPt.ChatGPT.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RecordService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsService() {
//            @Autowired
//            private UserRepository userRepository;
//
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                User user = userRepository.findByUsername(username);
//                if (user == null) {
//                    throw new UsernameNotFoundException("User not found with username: " + username);
//                }
//                return org.springframework.security.core.userdetails.User.builder()
//                        .username(user.getUsername())
//                        .password(user.getPassword()) // Make sure password is encoded properly
//                        .roles("USER") // Add user roles here if needed
//                        .build();
//            }
//        };
//    }
}
