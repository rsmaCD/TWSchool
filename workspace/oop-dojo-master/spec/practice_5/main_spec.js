"use strict";

import {Person, Student, Worker} from '../../main/practice_5.js';

describe("OO入门", function(){
    it("覆盖同时复用父类的方法", function(){
        const person = new Person('Tom',21);
        expect(person.basic_introduce()).toEqual("My name is Tom. I am 21 years old.");
    });

    it("覆盖同时复用父类的方法", function(){
        const student = new Student('Tom',21,2);
        expect(student.basic_introduce()).toEqual("My name is Tom. I am 21 years old. I am a Student. I am at Class 2.");
    });

    it("覆盖同时复用父类的方法", function(){
        const worker = new Worker('Tom',21);
        expect(worker.basic_introduce()).toEqual("My name is Tom. I am 21 years old. I am a Worker. I have a job.");
    });
});