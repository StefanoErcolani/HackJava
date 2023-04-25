package it.aulab.springprogetto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import it.aulab.springprogetto.dto.CreateStudentDTO;
import it.aulab.springprogetto.dto.StudentDTO;
import it.aulab.springprogetto.dto.UpdateStudentDTO;
import it.aulab.springprogetto.model.Student;
import it.aulab.springprogetto.repository.StudentRepository;

@Service("studentService")
public class StudentService implements CrudService<StudentDTO, CreateStudentDTO, UpdateStudentDTO, Long>{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired 
    private ModelMapper mapper;

    private Student exists2(Long id) throws Exception {
        if(studentRepository.existsById(id)) return studentRepository.findById(id).get();

        throw new Exception();
    }

    @Override
    public List<StudentDTO> readAll() {
        List<StudentDTO> studtos = new ArrayList<StudentDTO>();

        for(Student s : studentRepository.findAll()) {
            studtos.add(mapper.map(s, StudentDTO.class));
            
        }
        return studtos;
    }
    
    
    @Override
    public StudentDTO readOne(Long id) throws Exception {
        return mapper.map(this.exists2(id), StudentDTO.class);
    }


    @Override
    public List<StudentDTO> read(Map<String, String> params) {
        List<Student> students = new ArrayList<Student>();

        return students.stream().map((el) -> mapper.map(el, StudentDTO.class)).toList(); 
    }

    @Override
    public StudentDTO create(CreateStudentDTO createStudentDTO) {
        Student student = mapper.map(createStudentDTO, Student.class);

        return mapper.map(studentRepository.save(student), StudentDTO.class);
    }

    @Override
    @Modifying
    public StudentDTO update(Long id, UpdateStudentDTO updateStudentDTO) throws Exception {
        Student student = this.exists2(id);
        student.setData(updateStudentDTO.getData());
        studentRepository.save(student);

        return mapper.map(student, StudentDTO.class);
    }

    @Override
    @Modifying
    public StudentDTO delete(Long id) throws Exception {
        Student student = this.exists2(id);

        StudentDTO studtont = mapper.map(student, StudentDTO.class);

        studentRepository.deleteById(id);

        return studtont;
    }

}
