package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.UsersDto;

public interface UserService {
    UsersDto getUserById(Integer id);
}
