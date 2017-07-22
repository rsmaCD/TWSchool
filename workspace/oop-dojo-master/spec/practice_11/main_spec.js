"use strict";
import {Person,Class,Student,Teacher} from '../../main/practice_11';
describe("OO入门", function(){
    it("对象之间的交互-5", function(){
            const person = new Person(110,'Tom',21);
            expect(person.introduce()).toEqual('My name is Tom. I am 21 years old.');

            const classObj = new Class(2);
            const student = new Student(110,'Tom',21,classObj);
            expect(student.introduce()).toEqual('My name is Tom. I am 21 years old. I am a Student. I am at Class 2.');

            classObj.assignLeader(student);
            expect(student.introduce()).toEqual('My name is Tom. I am 21 years old. I am a Student. I am Leader of Class 2.');

            const student2 = new Student(111,'Anna',22);
            expect(classObj.assignLeader(student2)).toEqual('It is not one of us.');

    });

    it("对象之间的交互-5", function(){
        const classObj1 = new Class(2);
        const classObj2 = new Class(3);
        const teacher1 = new Teacher(111,'Tom',21);
        const teacher2 = new Teacher(112,'Tom',21,[classObj1,classObj2]);
        const teacher3 = new Teacher(113,'Tom',21,[classObj1]);
        expect(teacher1.introduce()).toEqual("My name is Tom. I am 21 years old. I am a Teacher. I teach No Class.");
        expect(teacher2.introduce()).toEqual("My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2, 3.");
        expect(teacher3.introduce()).toEqual("My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2.");

    });

});