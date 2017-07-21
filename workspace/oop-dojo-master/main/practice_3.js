
class Person {
    constructor(name,age){
        this.name = name;
        this.age = age;
    }
    introduce(){
        return `My name is ${this.name}. I am ${this.age} years old.`;
    }
}

export default class Student extends Person{

    constructor(name,age,classNum){
        super(age, name);
        this.classNum = classNum;
    }

    introduce(){
        return `I am a Student. I am at Class ${this.classNum}.`;
    }
}