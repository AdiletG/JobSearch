package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.enums.AccountType;
import kg.job.jobsearch.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private List<UsersDto> users = new ArrayList<>(
            List.of(
                    UsersDto.builder()
                            .id(1)
                            .name("Adilet")
                            .surname("Gainazarov")
                            .age(24)
                            .email("adilet@mail.ru")
                            .password("qweqweqwe123")
                            .phone_number("+996500411713")
                            .avatar("/")
                            .account_type(AccountType.EMPLOYER)
                            .build(),
                    UsersDto.builder()
                            .id(2)
                            .name("Asan")
                            .surname("Uson")
                            .age(24)
                            .email("asan@mail.ru")
                            .password("123qweqweqwe")
                            .phone_number("+996550490711")
                            .avatar("/")
                            .account_type(AccountType.APPLICANT)
                            .build()
            )
    );


    @Override
    public UsersDto getUserById(Integer id){
        return users.stream()
                .filter(users -> users.getId() == id)
                .findFirst()
                .orElse(null);
    }
}