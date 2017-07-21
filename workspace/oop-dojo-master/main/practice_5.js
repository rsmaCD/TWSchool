class Person {
    constructor(name,age){
        this.name = name;
        this.age = age;
    }
    introduce(){
        return `My name is ${this.name}. I am ${this.age} years old.`;
    }
    basic_introduce(){
        return this.introduce();
    }
}

class Student extends Person{

    constructor(name,age,classNum){
        super(name, age);
        this.classNum = classNum;
    }

    introduce(){
        return `I am a Student. I am at Class ${this.classNum}.`;
    }

    basic_introduce(){
        return super.introduce() + " " + this.introduce();
    }
}

class Worker extends Person{

    constructor(name,age){
        super(name, age);
    }

    introduce(){
        return `I am a Worker. I have a job.`;
    }
    basic_introduce(){
        return super.introduce() + " " + this.introduce();
    }

}
module.exports =  {
    Person,
    Student,
    Worker
}