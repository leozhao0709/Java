package services.impl;

import org.springframework.stereotype.Service;
import services.StudentService;

@Service("studentService")
class StudentServiceImpl implements StudentService {

    @Override
    public void study() {
        System.out.println("StudentServiceImpl study");
    }
}
