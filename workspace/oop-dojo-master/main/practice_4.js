
class Person {
    constructor(name,age){
        this.name = name;
        this.age = age;
    }
    introduce(){
        return `My name is ${this.name}. I am ${this.age} years old.`;
    }
}

class Student extends Person{

    constructor(name,age,classNum){
        super(age, name);
        this.classNum = classNum;
    }

    introduce(){
        return `I am a Student. I am at Class ${this.classNum}.`;
    }
}

export default class Worker extends Person{

    constructor(name,age){
        super(age, name);
    }

    introduce(){
        return `I am a Worker. I have a job.`;
    }
}