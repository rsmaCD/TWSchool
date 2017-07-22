"use strict";
import {Person,Student,Class,Teacher} from '../../main/practice_9';
describe("OO入门", function(){
    it("对象之间的交互-3", function(){
        const person = new Person(110,'Tom',21);
        const classObj = new Class(2);
        const student = new Student(110,'Tom',21,classObj);
        expect(person.introduce()).toEqual("My name is Tom. I am 21 years old.");
        expect(student.introduce()).toEqual("My name is Tom. I am 21 years old. I am a Student. I am at Class 2.");

        classObj.assignLeader(student);
        expect(student.introduce()).toEqual("My name is Tom. I am 21 years old. I am a Student. I am Leader of Class 2.");

    });

    it("对象之间的交互-3", function(){
        const classObj = new Class(2);
        const teacher1 = new Teacher(111,'Tom',21);
        const teacher2 = new Teacher(112,'Tom',21,classObj);
        expect(teacher1.introduce()).toEqual("My name is Tom. I am 21 years old. I am a Teacher. I teach No Class.");
        expect(teacher2.introduce()).toEqual("My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2.");


    });
});