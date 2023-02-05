package ru.gb.com.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.com.dto.JwtRequest;
import ru.gb.com.dto.JwtResponse;
import ru.gb.com.dto.UserDto;
import ru.gb.com.dto.convertors.UserDtoConvertor;
import ru.gb.com.entities.Role;
import ru.gb.com.entities.User;
import ru.gb.com.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService  implements UserDetailsService {


    private final UserRepository userRepository;
    private final UserDtoConvertor userDtoConvertor;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public List<UserDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userDtoConvertor::userToDto)
                .collect(Collectors.toList());
    }

    public void createUser(JwtRequest request){

        User user = new User();
        user.setLogin(request.getLogin());
        user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        userRepository.save(user);
    }

    public boolean isUserExists(String name){
       return userRepository.existsByLogin(name);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username).orElseThrow(() ->new UsernameNotFoundException(username+" not exists"));


        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getType())).collect(Collectors.toList()));
    }


}