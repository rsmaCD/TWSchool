"use strict";
import {Person,Student,Teacher,ClassObj} from '../../main/practice_8';
describe("OO入门", function(){
    it("对象之间的交互-2", function(){
        const classObj = new ClassObj(2);
        const person = new Person('Tom',21);
        const student = new Student('Tom',21,classObj);
        const teacher1 = new Teacher('Tom',21,classObj);
        const teacher2 = new Teacher('Tom',21);
        expect(person.introduce()).toEqual('My name is Tom. I am 21 years old.');
        expect(student.introduce()).toEqual('My name is Tom. I am 21 years old. I am a Student. I am at Class 2.');
        expect(teacher1.introduce()).toEqual('My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2.');
        expect(teacher2.introduce()).toEqual('My name is Tom. I am 21 years old. I am a Teacher. I teach No Class.');
    });
});