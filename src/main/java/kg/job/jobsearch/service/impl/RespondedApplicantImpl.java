package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dto.Responded_applicantsDto;
import kg.job.jobsearch.dto.ResumesDto;
import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.dto.VacanciesDto;
import kg.job.jobsearch.enums.AccountType;
import kg.job.jobsearch.service.RespondedApplicantService;
import kg.job.jobsearch.service.ResumeService;
import kg.job.jobsearch.service.UserService;
import kg.job.jobsearch.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RespondedApplicantImpl implements RespondedApplicantService {
    private final VacancyService vacancyService;
    private final ResumeService resumeService;
    private final UserService userService;

    private final List<Responded_applicantsDto> respond = new ArrayList<>();

    @Override
    public List<Responded_applicantsDto> getAllRespond(){
        return new ArrayList<>(respond);
    }

    @Override
    public void respondToVacancy(Integer userId, Integer vacancyId, Integer resumeId){
        UsersDto user = userService.getUserById(userId);
        VacanciesDto vacancy = vacancyService.getVacancyById(vacancyId);
        ResumesDto resume = resumeService.getresumeById(resumeId);

        if (user.getAccount_type().equals(AccountType.APPLICANT)) {
            throw new RuntimeException("На вакансию может откликнуться только кандидат");
        }

        if (!vacancy.is_active()) {
            throw new RuntimeException("Вакансия неактивка");
        }

        if(user.getId() != resume.getApplicant_id()){
            throw new RuntimeException("У пользователя нет такого резюме");
        }

        int id = 0;

        for(Responded_applicantsDto r : respond){
            if(r.getResume_id() == resumeId && r.getVacancy_id() == vacancyId ){
                throw new RuntimeException("Это резюме уже откликалось на данную вакансию");
            }

            if(r.getId() > id){
                id = r.getId();
            }
        }

        respond.add(new Responded_applicantsDto(
                id + 1,resumeId,vacancyId,false
        ));
    }

    @Override
    public List<Responded_applicantsDto> getResponsesByApplicant(Integer userId, Integer resumeId){
        UsersDto user = userService.getUserById(userId);
        ResumesDto resume = resumeService.getresumeById(resumeId);

        if (!user.getAccount_type().equals(AccountType.APPLICANT)) {
            throw new RuntimeException("Только кандидат может смотреть отклики");
        }

        if (resume.getApplicant_id() != userId) {
            throw new RuntimeException("Это не ваше резюме");
        }

        return respond.stream()
                .filter(r -> r.getResume_id() == resumeId)
                .toList();
    }

    @Override
    public List<Responded_applicantsDto> getResponsesByVacancy(Integer userId, Integer vacancyId){
        UsersDto user = userService.getUserById(userId);
        VacanciesDto vacancy = vacancyService.getVacancyById(vacancyId);

        if (!user.getAccount_type().equals(AccountType.EMPLOYER)) {
            throw new RuntimeException("Только работадатель может смотреть кандидатов");
        }

        if (vacancy.getAuthor_id() != userId) {
            throw new RuntimeException("Это не ваше вакансия");
        }

        return respond.stream()
                .filter(v -> v.getVacancy_id() == vacancyId)
                .toList();
    }


}