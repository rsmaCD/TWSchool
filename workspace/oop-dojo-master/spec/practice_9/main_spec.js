"use strict";
import {Person,Student,ClassObj} from '../../main/practice_9';
describe("OO入门", function(){
    it("对象之间的交互-3", function(){
        const person = new Person(110,'Tom',21);
        const classObj = new ClassObj(2);
        const student = new Student(110,'Tom',21,classObj);
        expect(person.introduce()).toEqual("My name is Tom. I am 21 years old.");
        expect(student.introduce()).toEqual("My name is Tom. I am 21 years old. I am a Student. I am at Class 2.");

        classObj.assignLeader(student);
        expect(student.introduce()).toEqual("My name is Tom. I am 21 years old. I am a Student. I am Leader of Class 2.");

    });
});