"use strict";
import Worker from '../../main/practice_4';

describe("OO入门", function(){
    it("覆盖父类的方法-2", function(){
        const worker = new Worker("Tom",21);
        expect(worker.introduce()).toEqual('I am a Worker. I have a job.');
    });
});