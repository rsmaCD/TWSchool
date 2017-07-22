"use strict";

describe("OO入门", function(){
    it("对象之间的交互-5", function(){
        it("对象之间的交互-4", function(){
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
    });
});