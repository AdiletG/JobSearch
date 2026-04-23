package kg.job.jobsearch.controller;

import jakarta.validation.Valid;
import kg.job.jobsearch.dto.ContactTypesDto;
import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.dto.create.*;
import kg.job.jobsearch.dto.update.ResumeUpdateDto;
import kg.job.jobsearch.exception.createException.ResumeDataCreateException;
import kg.job.jobsearch.exception.notFoundException.*;
import kg.job.jobsearch.model.Resume;
import kg.job.jobsearch.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/resumes")
@RequiredArgsConstructor
public class MvcResumeController {
    private final ResumeService resumeService;
    private final ContactTypeService contactTypeService;
    private final UserService userService;

    @GetMapping
    public String getAllResumes(
            @RequestParam(required = false) String sort,
            Model model,
            @PageableDefault(size = 5, sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable
    ) {

        Page<Resume> page;
        if ("responsesCount,desc".equals(sort)) {
            Pageable pageWithoutSort = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
            page = resumeService.findAllOrderByResponsesCountDesc(pageWithoutSort);
        } else {
            page = resumeService.findResumesByPage(pageable);
        }

        model.addAttribute("page", page);
        model.addAttribute("resumes", page.getContent());
        model.addAttribute("sort", sort);
        model.addAttribute("currentPage", "resumes");
        return "resumes/resumes";
    }

    @GetMapping("/create")
    public String create(
            Model model) throws ContactsTypeNotFoundException {
        List<ContactTypesDto> contactTypes = contactTypeService.getAllContactType();

        ResumeCreateDto resume = new ResumeCreateDto();
        resume.setEducations(List.of(new EducationInfoCreateDto()));
        resume.setWorkExperiences(List.of(new WorkExperienceInfoCreateDto()));
        resume.setContacts(
                contactTypes.stream()
                        .map(ct -> ContactsInfoCreateDto.builder().type_id(ct.getId()).build())
                        .collect(Collectors.toList())
        );

        model.addAttribute("resume", resume);
        model.addAttribute("contactTypes", contactTypes);
        return "resumes/resumes-create";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) throws ResumeNotFoundException, ContactsTypeNotFoundException {
        ResumeUpdateDto resume = resumeService.getById(id);
        List<ContactTypesDto> contactTypes = contactTypeService.getAllContactType();

        model.addAttribute("resume", resume);
        model.addAttribute("contactTypes", contactTypes);
        return "resumes/resumes-update";
    }

    @PostMapping("/create")
    public String createPost(
            @Valid @ModelAttribute("resume") ResumeCreateDto dto,
            BindingResult bindingResult, Principal principal, Model model)
            throws UserNotFoundException, ResumeNotFoundException, ResumeDataCreateException {
        UsersDto user = userService.findByEmail(principal.getName());
        if(!bindingResult.hasErrors()){
           resumeService.createResume(user.getId(), dto);
            return "redirect:/profile";
        }

        model.addAttribute("resume", new VacanciesCreateDto());
        return "resumes/resumes-create";
    }

    @PostMapping("/update/{id}")
    public String updatePost(
            @Valid @ModelAttribute("resume") ResumeUpdateDto dto,
            @PathVariable Long id, BindingResult bindingResult, Model model) throws EducationNotFoundException, ResumeNotFoundException, WorkExperienceInfoNotFoundException, ContactsInfoNotFoundException, CategoryNotFoundException {
        if(!bindingResult.hasErrors()){
            resumeService.updateResume(id, dto);
            return "redirect:/profile";
        }

        model.addAttribute("resume", dto);
        return "resumes/resumes-update";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) throws ResumeNotFoundException {
        resumeService.deleteResume(id);
        return "redirect:/profile";
    }
}