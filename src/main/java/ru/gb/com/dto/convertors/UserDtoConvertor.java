package ru.gb.com.dto.convertors;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gb.com.dto.UserDto;
import ru.gb.com.entities.User;

@Component
@Data
@NoArgsConstructor
public class UserDtoConvertor {

    public UserDto userToDto(User user){
        return new UserDto(user.getId(),user.getLogin());
    }


}
