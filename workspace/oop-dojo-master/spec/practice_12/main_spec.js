"use strict";
import {Person,Class,Student,Teacher} from '../../main/practice_12';
describe("OO入门", function(){
    it("对象之间的交互-6", function(){
        const class1 = new Class(1);
        const class2 = new Class(2);
        const teacher1 = new Teacher(110,'Tom',21,[class1,class2]);
        const student1 = new Student(111,'Jerry',21);

        spyOn(console, 'log');
        class2.appendMember(student1);

        expect(console.log).toHaveBeenCalledWith('I am Tom. I know Jerry has joined Class 2.');

    });

    it("对象之间的交互-6", function(){
        const class1 = new Class(1);
        const class2 = new Class(2);
        const teacher1 = new Teacher(110,'Tom',21,[class1,class2]);
        const student1 = new Student(111,'Jerry',21,class2);

        spyOn(console, 'log');
        class2.assignLeader(student1);

        expect(console.log).toHaveBeenCalledWith('I am Tom. I know Jerry become Leader of Class 2.');

    });
});