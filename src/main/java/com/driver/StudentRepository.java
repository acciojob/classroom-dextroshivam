package com.driver;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String,Student> studentMap=new HashMap<>();
    HashMap<String,Teacher> teacherMap=new HashMap<>();
    HashMap<String, List<String>> teacherToStudentMap=new HashMap<>();
    HashMap<String,String> studentToTeacherMap=new HashMap<>();


    public void addStudent(Student student) {
        studentMap.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher) {
        teacherMap.put(teacher.getName(),teacher);
        teacherToStudentMap.put(teacher.getName(),new ArrayList<>());
    }

    public void addStudentTeacherPair(String student, String teacher) {
        teacherToStudentMap.get(teacher).add(student);
        studentToTeacherMap.put(student,teacher);
    }

    public Student getStudentByName(String name) {
        return studentMap.get(name);
    }

    public Teacher getTeacherByName(String name) {
        return teacherMap.get(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return teacherToStudentMap.get(teacher);
    }

    public List<String> getAllStudents() {
        List<String> ans=new ArrayList<>();
        for(String name:studentMap.keySet()){
            ans.add(name);
        }
        return ans;
    }


    // student record ko delte krne ki jrurat h ki ni ye dekhna padega
    public void deleteTeacherByName(String teacher) {
        teacherMap.remove(teacher);
        teacherToStudentMap.remove(teacher);
    }


    // student record ko delte krne ki jrurat h ki ni ye dekhna padega
    public void deleteAllTeachers() {
        teacherMap.clear();
        teacherToStudentMap.clear();
    }
}
